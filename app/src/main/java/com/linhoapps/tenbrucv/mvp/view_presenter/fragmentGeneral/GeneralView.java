package com.linhoapps.tenbrucv.mvp.view_presenter.fragmentGeneral;

/**
 * Created by KTB on 09/02/2017.
 */
public interface GeneralView {
    void requestForSpecificPermission(String[] permissions);

    void existPermissionPhoneCall();

    void toolbarCollapsed();

    void toolbarNoCollapsed();

    void startHelpScreen();

    void clickBtnCollapseEducationCard();

    void clickBtnCollapseContactCard();

    void clickBtnPhone();

    void clickBtnEmail();

    void clickBtnLinkedin();

    void clickTextPhone();

    void clickTextEmail();

    void clickTextLinkedin();

    void clickBtnLanguagesCard();

    void startTranslateSpanish();

    void startTranslateCatalan();

    void startTranslateEnglish();

    void clickBtnCollapseDescriptionCard();

    void noTranslateEnglish();

    void noTranslateCatalan();

    void noTranslateSpanish();
}
