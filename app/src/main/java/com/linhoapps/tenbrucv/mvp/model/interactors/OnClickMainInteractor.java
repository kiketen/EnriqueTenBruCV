package com.linhoapps.tenbrucv.mvp.model.interactors;

/**
 * Created by KTB on 22/02/2017.
 */

public interface OnClickMainInteractor {

    void processOnClick(OnClickMainListener onClickMainListener, int id);

    interface OnClickMainListener{

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
}
