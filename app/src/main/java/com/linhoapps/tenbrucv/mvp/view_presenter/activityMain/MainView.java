package com.linhoapps.tenbrucv.mvp.view_presenter.activityMain;

/**
 * Created by KTB on 09/02/2017.
 */
public interface MainView {
    void requestForSpecificPermission(String[] permissions);

    void existPermissionPhoneCall();

    void startSkillsFragment();

    void startGeneralFragment();

    void startExperienceFragment();
}
