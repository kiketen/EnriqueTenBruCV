package com.linhoapps.tenbrucv.mvp.view_presenter.fragmentSkills.fragmentAngularJS;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.linhoapps.tenbrucv.Application;
import com.linhoapps.tenbrucv.R;
import com.linhoapps.tenbrucv.mvp.model.business_logic.objects.ResultSkills;
import com.linhoapps.tenbrucv.mvp.model.business_logic.objects.Skill;
import com.linhoapps.tenbrucv.utils.widgets.Dialogs;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.akexorcist.localizationactivity.LanguageSetting.getLanguage;
import static com.linhoapps.tenbrucv.mvp.view_presenter.fragmentSkills.fragmentAndroid.SkillsFragmentAndroid.fragmentSkillActual;
import static com.linhoapps.tenbrucv.utils.ReadJSONFile.getLanguageJSON;
import static com.linhoapps.tenbrucv.utils.animations.ViewAnimation.animSpeed;

/**
 * A placeholder fragment containing a simple view.
 */
public class SkillsFragmentAngularJS extends Fragment implements SkillsViewAngularJS {

    @BindView(R.id.skills_angularjs)
    TextView skillsAngularjs;
    @BindView(R.id.cv_description)
    CardView cvDescription;
    private Activity activity;
    private SkillsPresenterAngularJSImpl presenter;
    private ResultSkills androidSkills;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        fragmentSkillActual = "anguarjs";
        presenter = new SkillsPresenterAngularJSImpl(this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_skills_angularjs, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        activity = Application.getCurrentActivity();
        initializeVariables();
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

    private void initializeVariables() {
        cvDescription.setVisibility(View.GONE);
        presenter.callRepository();
    }

    @Override
    public void successGetAngularJSSkills(ResultSkills resultSkills) {
        androidSkills = resultSkills;
        setExperienceAndCardInfo(resultSkills);
    }

    private void setExperienceAndCardInfo(final ResultSkills skill) {
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                int language = getLanguageJSON();
                String experience = skill.getSkills().get(0).getParticularSkills().get(language).getName();
                if (language == 0) {
                    Dialogs.showAngularJSButtonDialog(getString(R.string.angularjs) + " " + getString(R.string.expericence),
                            experience, cvDescription);
                } else {
                    Dialogs.showAngularJSButtonDialog(getString(R.string.expericence) + " " + getString(R.string.angularjs),
                            experience, cvDescription);
                }
                String cardInfo = skill.getSkills().get(1).getParticularSkills().get(language).getName();
                skillsAngularjs.setText(cardInfo);
            }
        }, animSpeed);
    }

}
