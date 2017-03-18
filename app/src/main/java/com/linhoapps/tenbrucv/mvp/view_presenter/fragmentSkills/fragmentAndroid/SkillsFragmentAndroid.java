package com.linhoapps.tenbrucv.mvp.view_presenter.fragmentSkills.fragmentAndroid;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.LinearLayout;

import com.linhoapps.tenbrucv.Application;
import com.linhoapps.tenbrucv.R;
import com.linhoapps.tenbrucv.mvp.model.business_logic.objects.Skill;
import com.linhoapps.tenbrucv.mvp.model.business_logic.objects.ResultSkills;
import com.linhoapps.tenbrucv.mvp.view_presenter.horizontalBarLibrary.MyRecyclerViewAdapter;
import com.linhoapps.tenbrucv.utils.widgets.Dialogs;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static com.akexorcist.localizationactivity.LanguageSetting.getLanguage;
import static com.linhoapps.tenbrucv.utils.ReadJSONFile.getLanguageJSON;
import static com.linhoapps.tenbrucv.utils.animations.ViewAnimation.animSpeed;
import static com.linhoapps.tenbrucv.utils.animations.ViewAnimation.openCloseCard;

/**
 * A placeholder fragment containing a simple view.
 */
public class SkillsFragmentAndroid extends Fragment implements SkillsViewAndroid {

    private static Activity activity;
    @BindView(R.id.btn_collapse_components_card)
    ImageButton btnCollapseComponentsCard;
    @BindView(R.id.cv_components)
    CardView cvComponents;
    @BindView(R.id.btn_collapse_libraries_card)
    ImageButton btnCollapseLibrariesCard;
    @BindView(R.id.cv_libraries)
    CardView cvLibraries;
    @BindView(R.id.btn_collapse_tools_card)
    ImageButton btnCollapseToolsCard;
    @BindView(R.id.cv_tools)
    CardView cvTools;
    @BindView(R.id.content_components)
    LinearLayout contentComponents;
    @BindView(R.id.content_libraries)
    LinearLayout contentLibraries;
    @BindView(R.id.content_tools)
    LinearLayout contentTools;
    @BindView(R.id.fragment_android_skill_layout)
    LinearLayout fragmentAndroidSkillLayout;
    private SkillsPresenterAndroidImpl presenter;
    private static ResultSkills androidSkills;
    public static String fragmentSkillActual;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        fragmentSkillActual = "android";
        presenter = new SkillsPresenterAndroidImpl(this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_skills_android, container, false);
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
        cvComponents.setVisibility(View.GONE);
        cvLibraries.setVisibility(View.GONE);
        cvTools.setVisibility(View.GONE);
        presenter.callRepository();
    }

    @Override
    public void successGetAndroidSkills(ResultSkills resultSkills) {
        androidSkills = resultSkills;
        setExperience(androidSkills.getSkills().get(3));
    }

    private void setExperience(final Skill skill) {
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                int language = getLanguageJSON();
                if (language == 0) {
                    Dialogs.show1ButtonDialog(getString(R.string.androidstr) + " " + getString(R.string.expericence),
                            skill.getParticularSkills().get(language).getName(), cvComponents,
                            cvLibraries, cvTools);
                } else {
                    Dialogs.show1ButtonDialog(getString(R.string.expericence) + " " + getString(R.string.androidstr),
                            skill.getParticularSkills().get(language).getName(), cvComponents,
                            cvLibraries, cvTools);
                }

            }
        }, animSpeed);
    }

    private static void setCardComponents(Skill skill) {
        RecyclerView recyclerViewComponents = (RecyclerView) activity.findViewById(R.id.recycler_view_components);
        recyclerViewComponents.setHasFixedSize(true);
        recyclerViewComponents.setLayoutManager(new LinearLayoutManager(activity));

        MyRecyclerViewAdapter adapterComponents = new MyRecyclerViewAdapter(activity, skill.getParticularSkills());
        recyclerViewComponents.setAdapter(adapterComponents);
    }

    private static void setCardLibraries(Skill skill) {
        RecyclerView recyclerViewLibraries = (RecyclerView) activity.findViewById(R.id.recycler_view_libraries);
        recyclerViewLibraries.setHasFixedSize(true);
        recyclerViewLibraries.setLayoutManager(new LinearLayoutManager(activity));

        MyRecyclerViewAdapter adapterLibraries = new MyRecyclerViewAdapter(activity, skill.getParticularSkills());
        recyclerViewLibraries.setAdapter(adapterLibraries);
    }

    private static void setCardTools(Skill skill) {
        RecyclerView recyclerViewTools = (RecyclerView) activity.findViewById(R.id.recycler_view_tools);
        recyclerViewTools.setHasFixedSize(true);
        recyclerViewTools.setLayoutManager(new LinearLayoutManager(activity));

        MyRecyclerViewAdapter adapterTools = new MyRecyclerViewAdapter(activity, skill.getParticularSkills());
        recyclerViewTools.setAdapter(adapterTools);
    }

    @OnClick({R.id.btn_collapse_components_card, R.id.btn_collapse_libraries_card, R.id.btn_collapse_tools_card})
    public void onClick(View view) {
        Handler handler = new Handler();
        switch (view.getId()) {
            case R.id.btn_collapse_components_card:
                openCloseCard(contentComponents, btnCollapseComponentsCard, fragmentAndroidSkillLayout);
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        setCardComponents(androidSkills.getSkills().get(0));
                    }
                }, animSpeed/2);
                break;
            case R.id.btn_collapse_libraries_card:
                openCloseCard(contentLibraries, btnCollapseLibrariesCard, fragmentAndroidSkillLayout);
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        setCardLibraries(androidSkills.getSkills().get(1));
                    }
                }, animSpeed/2);
                break;
            case R.id.btn_collapse_tools_card:
                openCloseCard(contentTools, btnCollapseToolsCard, fragmentAndroidSkillLayout);
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        setCardTools(androidSkills.getSkills().get(2));
                    }
                }, animSpeed/2);
                break;
        }
    }

}
