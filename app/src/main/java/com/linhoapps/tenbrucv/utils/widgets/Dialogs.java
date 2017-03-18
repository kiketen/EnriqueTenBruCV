package com.linhoapps.tenbrucv.utils.widgets;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Handler;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import com.linhoapps.tenbrucv.Application;
import com.linhoapps.tenbrucv.R;
import com.linhoapps.tenbrucv.utils.animations.ViewAnimation;

import static com.linhoapps.tenbrucv.mvp.view_presenter.activityMain.MainActivity.openingDialog;
import static com.linhoapps.tenbrucv.utils.animations.ViewAnimation.animSpeed;

/**
 * Created by @KTB on 21/11/2016.
 */

public class Dialogs {

    private static Activity activity;

    public static void show1ButtonDialog(String title, String message, final View cvComponents,
                                         final View cvLibraries, final View cvTools) {
        activity = Application.getCurrentActivity();
        AlertDialog.Builder builder = new AlertDialog.Builder(activity, R.style.customDialog);
        builder.setTitle(title);
        builder.setMessage(message);

        String positiveText = activity.getString(android.R.string.ok);
        builder.setPositiveButton(positiveText,
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        closeDialog(dialog);
                        animationCardView(cvComponents);
                        Handler handler = new Handler();
                        handler.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                animationCardView(cvLibraries);
                            }
                        }, animSpeed / 2);
                        Handler handler2 = new Handler();
                        handler2.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                animationCardView(cvTools);
                            }
                        }, animSpeed);

                    }
                });

        AlertDialog dialog = builder.create();
        startDialog(dialog);
        ViewAnimation.scaleXYandAlpha(dialog.getWindow().getDecorView());

    }

    private static void closeDialog(DialogInterface dialog) {
        dialog.dismiss();
        openingDialog = false;
    }

    public static void animationCardView(View cvComponents) {
        cvComponents.setVisibility(View.VISIBLE);
        Animation fadeInAnimation = AnimationUtils.loadAnimation(activity, R.anim.slide_in_left);
        cvComponents.startAnimation(fadeInAnimation);
    }

    private static void startDialog(Dialog dialog) {
        dialog.show();
        dialog.setCancelable(false);
        dialog.setCanceledOnTouchOutside(false);
        openingDialog = true;
    }

    public static void showAngularJSButtonDialog(String title, String message, final View cvDescription) {
        activity = Application.getCurrentActivity();
        AlertDialog.Builder builder = new AlertDialog.Builder(activity, R.style.customDialog);
        builder.setTitle(title);
        builder.setMessage(message);

        String positiveText = activity.getString(android.R.string.ok);
        builder.setPositiveButton(positiveText,
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        closeDialog(dialog);
                        animationCardView(cvDescription);
                    }
                });

        AlertDialog dialog = builder.create();
        startDialog(dialog);
        ViewAnimation.scaleXYandAlpha(dialog.getWindow().getDecorView());
    }
}
