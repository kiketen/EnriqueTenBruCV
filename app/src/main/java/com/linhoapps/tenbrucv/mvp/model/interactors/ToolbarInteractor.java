package com.linhoapps.tenbrucv.mvp.model.interactors;

/**
 * Created by KTB on 22/02/2017.
 */

public interface ToolbarInteractor {
    void getToolbarState(OnToolbarListener onToolbarListener, String actualState, String toolbarState);

    void processClickButtons(OnToolbarListener onToolbarListener, int itemId);

    interface OnToolbarListener{

        void toolbarCollapsed();

        void toolbarNoCollapsed();

        void startHelpScreen();
    }
}
