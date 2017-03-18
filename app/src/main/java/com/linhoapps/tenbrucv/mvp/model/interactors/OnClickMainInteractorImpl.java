package com.linhoapps.tenbrucv.mvp.model.interactors;

import com.linhoapps.tenbrucv.R;

import static com.akexorcist.localizationactivity.LanguageSetting.getLanguage;

/**
 * Created by KTB on 22/02/2017.
 */
public class OnClickMainInteractorImpl implements OnClickMainInteractor{


    @Override
    public void processOnClick(OnClickMainListener onClickMainListener, int id) {
        switch (id) {
            case R.id.btn_collapse_education_card:
                onClickMainListener.clickBtnCollapseEducationCard();
                break;
            case R.id.btn_collapse_contact_card:
                onClickMainListener.clickBtnCollapseContactCard();
                break;
            case R.id.btn_phone:
                onClickMainListener.clickBtnPhone();
                break;
            case R.id.btn_email:
                onClickMainListener.clickBtnEmail();
                break;
            case R.id.btn_linkedin:
                onClickMainListener.clickBtnLinkedin();
                break;
            case R.id.title_phone:
                onClickMainListener.clickTextPhone();
                break;
            case R.id.title_email:
                onClickMainListener.clickTextEmail();
                break;
            case R.id.title_linkedin:
                onClickMainListener.clickTextLinkedin();
                break;
            case R.id.btn_collapse_languages_card:
                onClickMainListener.clickBtnLanguagesCard();
                break;
            case R.id.btn_spanish:
                clickedSpanish(onClickMainListener);
                break;
            case R.id.btn_catalan:
                clickedCatalan(onClickMainListener);
                break;
            case R.id.btn_english:
                clickedEnglish(onClickMainListener);
                break;
            case R.id.title_spanish:
                clickedSpanish(onClickMainListener);
                break;
            case R.id.title_catalan:
                clickedCatalan(onClickMainListener);
                break;
            case R.id.title_english:
                clickedEnglish(onClickMainListener);
                break;
            case R.id.btn_collapse_description_card:
                onClickMainListener.clickBtnCollapseDescriptionCard();
                break;
        }
    }

    private void clickedEnglish(OnClickMainListener onClickMainListener) {
        if(!getLanguage().equals("en")){
            onClickMainListener.startTranslateEnglish();
        }else{
            onClickMainListener.noTranslateEnglish();
        }

    }

    private void clickedCatalan(OnClickMainListener onClickMainListener) {
        if(!getLanguage().equals("ca")){
            onClickMainListener.startTranslateCatalan();
        }else{
            onClickMainListener.noTranslateCatalan();
        }
    }

    private void clickedSpanish(OnClickMainListener onClickMainListener) {
        if(!getLanguage().equals("es")){
            onClickMainListener.startTranslateSpanish();
        }else{
            onClickMainListener.noTranslateSpanish();
        }
    }
}
