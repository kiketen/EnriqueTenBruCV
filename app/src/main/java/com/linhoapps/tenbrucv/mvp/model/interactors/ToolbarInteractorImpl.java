package com.linhoapps.tenbrucv.mvp.model.interactors;

import com.linhoapps.tenbrucv.R;

/**
 * Created by KTB on 22/02/2017.
 */

public class ToolbarInteractorImpl implements ToolbarInteractor {
    @Override
    public void getToolbarState(OnToolbarListener onToolbarListener, String actualState, String previousState) {
        if (actualState.equals("COLLAPSED")) {
            onToolbarListener.toolbarCollapsed();
        } else if (previousState.equals("COLLAPSED")) {
            onToolbarListener.toolbarNoCollapsed();
        }
    }

    @Override
    public void processClickButtons(OnToolbarListener onToolbarListener, int itemId) {
        if (itemId == R.id.action_settings) {
            onToolbarListener.startHelpScreen();
        }
    }
}
