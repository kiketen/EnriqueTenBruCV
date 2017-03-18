package com.linhoapps.tenbrucv.mvp.view_presenter.fragmentSkills;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.linhoapps.tenbrucv.Application;
import com.linhoapps.tenbrucv.R;
import com.linhoapps.tenbrucv.mvp.view_presenter.fragmentSkills.fragmentAndroid.SkillsFragmentAndroid;
import com.linhoapps.tenbrucv.mvp.view_presenter.fragmentSkills.fragmentAngularJS.SkillsFragmentAngularJS;
import com.linhoapps.tenbrucv.mvp.view_presenter.fragmentSkills.fragmentOthers.SkillsFragmentOthers;
import com.linhoapps.tenbrucv.mvp.view_presenter.fragmentSkills.fragmentSQL.SkillsFragmentSQL;
import com.linhoapps.tenbrucv.utils.animations.ViewAnimation;
import com.linhoapps.tenbrucv.utils.listeners.CircleTransform;
import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static com.linhoapps.tenbrucv.mvp.view_presenter.activityMain.MainActivity.fragmentActual;
import static com.linhoapps.tenbrucv.mvp.view_presenter.activityMain.MainActivity.onBackPressedAction;
import static com.linhoapps.tenbrucv.mvp.view_presenter.activityMain.MainActivity.openingDialog;
import static com.linhoapps.tenbrucv.mvp.view_presenter.fragmentSkills.fragmentAndroid.SkillsFragmentAndroid.fragmentSkillActual;
import static com.linhoapps.tenbrucv.utils.animations.ViewAnimation.MID_ANIM;
import static com.linhoapps.tenbrucv.utils.animations.ViewAnimation.SLOW_ANIM;
import static com.linhoapps.tenbrucv.utils.animations.ViewAnimation.animSpeed;

/**
 * A placeholder fragment containing a simple view.
 */
public class SkillsFragment extends Fragment {

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.tab_layout)
    TabLayout tabLayout;
    @BindView(R.id.skill_image)
    ImageView skillImage;
    @BindView(R.id.toolbar_icon)
    ImageView toolbarIcon;
    private Activity activity;
    private Fragment skillFragment;
    private FragmentTransaction transaction;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_skills, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        fragmentActual = "skills";
        fragmentSkillActual = "";
        animSpeed = MID_ANIM;
        activity = Application.getCurrentActivity();
        setToolbar();
        setTabLayout();
        initializeVariables();
        startSkillsAndroidFragment();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if (!onBackPressedAction) {
            transaction = getFragmentManager().beginTransaction();
            transaction.remove(skillFragment).commit();
        }
    }

    @Override
    public void onStop() {
        super.onStop();
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

    private void setToolbar() {
        Picasso.with(activity).load(R.drawable.toolbar_image).transform(new CircleTransform()).into(toolbarIcon);
        ((AppCompatActivity) getActivity()).setSupportActionBar(toolbar);
        ((AppCompatActivity) getActivity()).getSupportActionBar().setDisplayShowTitleEnabled(false);
    }

    private void setTabLayout() {
        tabLayout.addTab(tabLayout.newTab().setText(activity.getString(R.string.androidstr)));
        tabLayout.addTab(tabLayout.newTab().setText(activity.getString(R.string.angularjs)));
        tabLayout.addTab(tabLayout.newTab().setText(activity.getString(R.string.sql)));
        tabLayout.addTab(tabLayout.newTab().setText(activity.getString(R.string.others)));
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                animSpeed = MID_ANIM;
                if(!openingDialog){
                    switch (tab.getPosition()) {
                        case 0:
                            startSkillsAndroidFragment();
                            break;
                        case 1:
                            startSkillsAngularJSFragment();
                            break;
                        case 2:
                            startSkillsSQLFragment();
                            break;
                        case 3:
                            startSkillsOthersFragment();
                            break;
                        default:
                            break;
                    }
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

    private void initializeVariables() {

    }

    private void startSkillsAndroidFragment() {
        if (!fragmentSkillActual.equals("android")) {
            skillFragment = new SkillsFragmentAndroid();
            skillImage.setImageResource(R.drawable.android);
            changeFrangment();
        }
    }

    private void startSkillsAngularJSFragment() {
        if (!fragmentSkillActual.equals("angularjs")) {
            skillFragment = new SkillsFragmentAngularJS();
            skillImage.setImageResource(R.drawable.angularjs);
            changeFrangment();
        }
    }

    private void startSkillsSQLFragment() {
        if (!fragmentSkillActual.equals("sql")) {
            skillFragment = new SkillsFragmentSQL();
            skillImage.setImageResource(R.drawable.sql);
            changeFrangment();
        }
    }

    private void startSkillsOthersFragment() {
        if (!fragmentSkillActual.equals("others")) {
            skillFragment = new SkillsFragmentOthers();
            changeOthersFrangment();
        }
    }

    private void changeOthersFrangment() {
        getFragmentManager().beginTransaction().replace(R.id.fragment_skill_layout, skillFragment).commit();
    }

    private void changeFrangment() {
        openingDialog = true;
        ViewAnimation.scaleXYandAlpha(skillImage);
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                ViewAnimation.scaleDownXYandAlpha(skillImage);
            }
        }, animSpeed * 2);
        getFragmentManager().beginTransaction().replace(R.id.fragment_skill_layout, skillFragment).commit();
    }

    @OnClick(R.id.toolbar_icon)
    public void onClick() {
    }
}
