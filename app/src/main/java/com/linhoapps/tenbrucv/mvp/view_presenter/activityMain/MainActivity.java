package com.linhoapps.tenbrucv.mvp.view_presenter.activityMain;

import android.app.Fragment;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.ActivityCompat;
import android.transition.ChangeBounds;
import android.transition.Slide;
import android.view.Gravity;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.Toast;

import com.akexorcist.localizationactivity.LocalizationActivity;
import com.linhoapps.tenbrucv.Application;
import com.linhoapps.tenbrucv.R;
import com.linhoapps.tenbrucv.mvp.view_presenter.fragmentGeneral.GeneralFragment;
import com.linhoapps.tenbrucv.mvp.view_presenter.fragmentSkills.SkillsFragment;

import java.util.List;

import static com.linhoapps.tenbrucv.utils.animations.ViewAnimation.FAST_ANIM;
import static com.linhoapps.tenbrucv.utils.animations.ViewAnimation.MID_ANIM;
import static com.linhoapps.tenbrucv.utils.animations.ViewAnimation.animSpeed;

public class MainActivity extends LocalizationActivity implements GeneralFragment.OnClickListener, MainView {

    private GeneralFragment generalFragment;
    private MainPresenterImpl presenter;
    static public ImageView toolbarActImage;
    static public String fragmentActual;
    public static boolean onBackPressedAction = false;
    public static boolean openingDialog = false;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Application.setCurrentActivity(MainActivity.this);
        Application.setCurrentContext(this);
        setContentView(R.layout.activity_main);
        presenter = new MainPresenterImpl(this);
        presenter.setPermisions();
        fragmentActual = "";
        startGeneralFragment();
        setNavigationBottomBar();
    }

    private void setNavigationBottomBar() {
        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.navigation_view);
        bottomNavigationView.setOnNavigationItemSelectedListener(
                new BottomNavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                        if (!openingDialog) {
                            animSpeed = FAST_ANIM;
                            presenter.navigationBottomClick(item.getItemId());
                            return true;
                        } else {
                            return false;
                        }
                    }
                });
    }

    @Override
    public void translateApp(String language) {
        setLanguage(language);
    }

    @Override
    public void startLinkedin() {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(getString(R.string.linkedin_url_app)));
        final PackageManager packageManager = this.getPackageManager();
        final List<ResolveInfo> list = packageManager.queryIntentActivities(intent, PackageManager.MATCH_DEFAULT_ONLY);
        if (list.isEmpty()) {
            intent = new Intent(Intent.ACTION_VIEW, Uri.parse(getString(R.string.linkedin_url)));
        }

        startActivity(intent);
    }

    @Override
    public void startSkillsFragment() {
        if (fragmentActual.equals("general")) {
            Fragment skillsFragment = new SkillsFragment();
            Slide slideTransition = new Slide(Gravity.LEFT);
            slideTransition.setDuration(animSpeed / 2);
            changeFrangment(skillsFragment, slideTransition);
        }
    }

    @Override
    public void startGeneralFragment() {
        if (!fragmentActual.equals("general")) {
            Fragment generalFragment = new GeneralFragment();
            Slide slideTransition = new Slide(Gravity.RIGHT);
            slideTransition.setDuration(animSpeed / 2);
            changeFrangment(generalFragment, slideTransition);
        }
    }

    @Override
    public void startExperienceFragment() {
        Toast.makeText(this, R.string.part_no_developed, Toast.LENGTH_SHORT).show();
    }

    private void changeFrangment(Fragment newFragment, Slide slideTransition) {
        // Defines enter transition for all fragment views

        ChangeBounds changeBoundsTransition = new ChangeBounds();
        changeBoundsTransition.setDuration(animSpeed / 2);

        newFragment.setEnterTransition(slideTransition);
        newFragment.setAllowEnterTransitionOverlap(true);
        newFragment.setSharedElementEnterTransition(changeBoundsTransition);

        getFragmentManager().beginTransaction()
                .replace(R.id.fragment_layout, newFragment)
                .commit();
    }

    @Override
    public void requestForSpecificPermission(String[] permissions) {
        ActivityCompat.requestPermissions(this, permissions, 101);
    }

    @Override
    public void existPermissionPhoneCall() {

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        onBackPressedAction = true;
    }
}
