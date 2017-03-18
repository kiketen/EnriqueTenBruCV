package com.linhoapps.tenbrucv.mvp.model.interactors;

import com.linhoapps.tenbrucv.R;

/**
 * Created by KTB on 22/02/2017.
 */
public class NavigationBottomInteractorImpl implements NavigationBottomInteractor{

    @Override
    public void processClick(OnNavigationBottomListener onNavigationBottomListener, int itemId) {
        switch (itemId) {
            case R.id.knowledgements:
                onNavigationBottomListener.startKnowledgementsActivity();
                break;
            case R.id.general:
                onNavigationBottomListener.startGeneralInformationActivity();
                break;
            case R.id.expericence:
                onNavigationBottomListener.startExperienceActivity();
                break;
        }
    }
}
