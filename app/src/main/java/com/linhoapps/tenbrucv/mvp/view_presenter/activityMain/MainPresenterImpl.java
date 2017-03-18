package com.linhoapps.tenbrucv.mvp.view_presenter.activityMain;

import com.linhoapps.tenbrucv.mvp.model.interactors.NavigationBottomInteractor;
import com.linhoapps.tenbrucv.mvp.model.interactors.NavigationBottomInteractorImpl;
import com.linhoapps.tenbrucv.mvp.model.interactors.OnClickMainInteractorImpl;
import com.linhoapps.tenbrucv.mvp.model.interactors.PermissionsInteractor;
import com.linhoapps.tenbrucv.mvp.model.interactors.PermissionsInteractorImpl;

/**
 * Created by KTB on 09/02/2017.
 */
public class MainPresenterImpl implements MainPresenter, PermissionsInteractor.OnPermissionsListener, NavigationBottomInteractor.OnNavigationBottomListener {

    private OnClickMainInteractorImpl onClickMainInteractor;
    private PermissionsInteractorImpl permissionsInteractor;
    private MainView mainView;
    private NavigationBottomInteractorImpl navigationBottomInteractor;


    public MainPresenterImpl(MainView mainView) {
        this.mainView = mainView;
        permissionsInteractor = new PermissionsInteractorImpl();
        navigationBottomInteractor = new NavigationBottomInteractorImpl();
    }

    @Override
    public void setPermisions() {
        permissionsInteractor.setPermissionsPhoneCall(this);
    }

    @Override
    public void requestForSpecificPermission(String[] permissions) {
        mainView.requestForSpecificPermission(permissions);
    }

    @Override
    public void existPermissionPhoneCall() {
        mainView.existPermissionPhoneCall();
    }

    @Override
    public void notExistPermissionPhoneCall() {

    }

    @Override
    public void navigationBottomClick(int itemId) {
        navigationBottomInteractor.processClick(this, itemId);
    }

    @Override
    public void startKnowledgementsActivity() {
        mainView.startSkillsFragment();
    }

    @Override
    public void startGeneralInformationActivity() {
        mainView.startGeneralFragment();
    }

    @Override
    public void startExperienceActivity() {
        mainView.startExperienceFragment();
    }
}
