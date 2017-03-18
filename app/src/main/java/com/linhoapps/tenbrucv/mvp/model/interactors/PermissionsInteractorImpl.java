package com.linhoapps.tenbrucv.mvp.model.interactors;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;

import com.linhoapps.tenbrucv.Application;
import com.linhoapps.tenbrucv.R;

import static com.linhoapps.tenbrucv.Application.getCurrentActivity;

/**
 * Created by KTB on 03/01/2017.
 */

public class PermissionsInteractorImpl implements PermissionsInteractor {

    Activity activity;

    @Override
    public void setPermissionsPhoneCall(OnPermissionsListener onPermissionsListener) {
        activity = Application.getCurrentActivity();
        String[] permissionsStorage = new String[]{Manifest.permission.CALL_PHONE};
        if (!checkIfAlreadyhavePermission(permissionsStorage[0])) {
            onPermissionsListener.requestForSpecificPermission(permissionsStorage);
        } else {
            onPermissionsListener.existPermissionPhoneCall();
        }

    }

    private boolean checkIfAlreadyhavePermission(String permission) {
        int result = ActivityCompat.checkSelfPermission(activity, permission);
        if (result == PackageManager.PERMISSION_GRANTED) {
            return true;
        } else {
            return false;
        }
    }

    public void checkPermissionsPhoneCall(OnPermissionsListener onPermissionsListener) {
        activity = Application.getCurrentActivity();
        if (checkIfAlreadyhavePermission(Manifest.permission.CALL_PHONE)) {
            Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse(activity.getString(R.string.tel) +
                    activity.getString(R.string.phone_number)));
            activity.startActivity(intent);
        } else {
            onPermissionsListener.notExistPermissionPhoneCall();
        }
    }
}
