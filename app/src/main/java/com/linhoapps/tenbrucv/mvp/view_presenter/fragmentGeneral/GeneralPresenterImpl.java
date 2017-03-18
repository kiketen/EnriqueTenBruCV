package com.linhoapps.tenbrucv.mvp.view_presenter.fragmentGeneral;

import com.linhoapps.tenbrucv.mvp.model.interactors.OnClickMainInteractor;
import com.linhoapps.tenbrucv.mvp.model.interactors.OnClickMainInteractorImpl;
import com.linhoapps.tenbrucv.mvp.model.interactors.PermissionsInteractor;
import com.linhoapps.tenbrucv.mvp.model.interactors.PermissionsInteractorImpl;
import com.linhoapps.tenbrucv.mvp.model.interactors.ToolbarInteractor;
import com.linhoapps.tenbrucv.mvp.model.interactors.ToolbarInteractorImpl;

/**
 * Created by KTB on 09/02/2017.
 */
public class GeneralPresenterImpl implements GeneralPresenter, PermissionsInteractor.OnPermissionsListener,
        ToolbarInteractor.OnToolbarListener, OnClickMainInteractor.OnClickMainListener {

    private OnClickMainInteractorImpl onClickMainInteractor;
    private PermissionsInteractorImpl permissionsInteractor;
    private GeneralView generalView;
    private ToolbarInteractorImpl toolbarInteractor;


    public GeneralPresenterImpl(GeneralView generalView) {
        this.generalView = generalView;
        permissionsInteractor = new PermissionsInteractorImpl();
        toolbarInteractor = new ToolbarInteractorImpl();
        onClickMainInteractor = new OnClickMainInteractorImpl();
    }

    public void setPermisions() {
        permissionsInteractor.setPermissionsPhoneCall(this);
    }

    @Override
    public void requestForSpecificPermission(String[] permissions) {
        generalView.requestForSpecificPermission(permissions);
    }

    @Override
    public void existPermissionPhoneCall() {
        generalView.existPermissionPhoneCall();
    }

    @Override
    public void notExistPermissionPhoneCall() {

    }

    public void checkPermisions() {
        permissionsInteractor.checkPermissionsPhoneCall(this);
    }

    public void changeToolbarState(String actualState, String previousState) {
        toolbarInteractor.getToolbarState(this, actualState, previousState);
    }

    @Override
    public void toolbarCollapsed() {
        generalView.toolbarCollapsed();
    }

    @Override
    public void toolbarNoCollapsed() {
        generalView.toolbarNoCollapsed();
    }

    @Override
    public void startHelpScreen() {
        generalView.startHelpScreen();
    }

    public void clickButtonsToolbar(int itemId) {
        toolbarInteractor.processClickButtons(this, itemId);
    }

    public void onClickActions(int id) {
        onClickMainInteractor.processOnClick(this, id);
    }

    @Override
    public void clickBtnCollapseEducationCard() {
        generalView.clickBtnCollapseEducationCard();
    }

    @Override
    public void clickBtnCollapseContactCard() {
        generalView.clickBtnCollapseContactCard();
    }

    @Override
    public void clickBtnPhone() {
        generalView.clickBtnPhone();
    }

    @Override
    public void clickBtnEmail() {
        generalView.clickBtnEmail();
    }

    @Override
    public void clickBtnLinkedin() {
        generalView.clickBtnLinkedin();
    }

    @Override
    public void clickTextPhone() {
        generalView.clickTextPhone();
    }

    @Override
    public void clickTextEmail() {
        generalView.clickTextEmail();
    }

    @Override
    public void clickTextLinkedin() {
        generalView.clickTextLinkedin();
    }

    @Override
    public void clickBtnLanguagesCard() {
        generalView.clickBtnLanguagesCard();
    }

    @Override
    public void startTranslateSpanish() {
        generalView.startTranslateSpanish();
    }

    @Override
    public void startTranslateCatalan() {
        generalView.startTranslateCatalan();
    }

    @Override
    public void startTranslateEnglish() {
        generalView.startTranslateEnglish();
    }

    @Override
    public void clickBtnCollapseDescriptionCard() {
        generalView.clickBtnCollapseDescriptionCard();
    }

    @Override
    public void noTranslateEnglish() {
        generalView.noTranslateEnglish();
    }

    @Override
    public void noTranslateCatalan() {
        generalView.noTranslateCatalan();
    }

    @Override
    public void noTranslateSpanish() {
        generalView.noTranslateSpanish();
    }
}
