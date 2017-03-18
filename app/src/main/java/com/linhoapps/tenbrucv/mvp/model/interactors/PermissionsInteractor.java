package com.linhoapps.tenbrucv.mvp.model.interactors;

/**
 * Created by KTB on 03/01/2017.
 */

public interface PermissionsInteractor {

    void setPermissionsPhoneCall(OnPermissionsListener onPermissionsListener);

    interface OnPermissionsListener{

        void requestForSpecificPermission(String[] permissionsStorage);

        void existPermissionPhoneCall();

        void notExistPermissionPhoneCall();
    }

}
