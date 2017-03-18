package com.linhoapps.tenbrucv.mvp.model.interactors;

/**
 * Created by KTB on 22/02/2017.
 */

public interface NavigationBottomInteractor {
    void processClick(OnNavigationBottomListener onNavigationBottomListener, int itemId);

    interface OnNavigationBottomListener{

        void startKnowledgementsActivity();

        void startGeneralInformationActivity();

        void startExperienceActivity();
    }
}
