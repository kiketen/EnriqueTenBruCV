package com.linhoapps.tenbrucv.utils.animations;

import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.text.style.ScaleXSpan;
import android.transition.AutoTransition;
import android.transition.TransitionManager;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.BounceInterpolator;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.linhoapps.tenbrucv.Application;
import com.linhoapps.tenbrucv.R;

/**
 * Created by KTB on 09/02/2017.
 */

public class ViewAnimation {

    public static final int SLOW_ANIM = 1300;
    public static final int MID_ANIM = 900;
    public static final int FAST_ANIM = 500;

    public static int animSpeed, delay;

    public static void scaleXY(View view) {

        Activity aplication = Application.getCurrentActivity();

        view.setScaleX(0.2f);
        view.setScaleY(0.2f);
        view.animate()
                .scaleX(1f)
                .scaleY(1f)
                .setStartDelay(delay)
                .setDuration(animSpeed)
                .setInterpolator(AnimationUtils.loadInterpolator(aplication,
                        android.R.anim.anticipate_overshoot_interpolator));

    }

    public static void scaleXYandAlpha(View view) {

        Activity aplication = Application.getCurrentActivity();

        view.setAlpha(0f);
        view.setScaleX(0.2f);
        view.setScaleY(0.2f);
        view.animate()
                .alpha(1f)
                .scaleX(1f)
                .scaleY(1f)
                .setStartDelay(delay)
                .setDuration(animSpeed)
                .setInterpolator(AnimationUtils.loadInterpolator(aplication,
                        android.R.anim.anticipate_overshoot_interpolator));

    }

    public static void scaleDownXYandAlpha(View view) {

        Activity aplication = Application.getCurrentActivity();

        view.setAlpha(1f);
        view.setScaleX(1f);
        view.setScaleY(1f);
        view.animate()
                .alpha(0f)
                .scaleX(0f)
                .scaleY(0f)
                .setStartDelay(delay)
                .setDuration(animSpeed)
                .setInterpolator(AnimationUtils.loadInterpolator(aplication,
                        android.R.anim.anticipate_overshoot_interpolator));

    }

    public static void scaleAlpha(View view) {

        Activity aplication = Application.getCurrentActivity();

        view.setAlpha(0f);
        view.animate()
                .alpha(1f)
                .setStartDelay(delay)
                .setDuration(animSpeed)
                .setInterpolator(AnimationUtils.loadInterpolator(aplication,
                        android.R.anim.anticipate_overshoot_interpolator));

    }

    public static void scaleAlphaDown(View view) {
        Activity aplication = Application.getCurrentActivity();

        view.setAlpha(1f);
        view.animate()
                .alpha(0f)
                .setStartDelay(delay)
                .setDuration(animSpeed)
                .setInterpolator(AnimationUtils.loadInterpolator(aplication,
                        android.R.anim.anticipate_overshoot_interpolator));
    }

    public static void scaleDownAlpha(View view) {

        Activity aplication = Application.getCurrentActivity();

        view.setAlpha(0.9f);
        view.animate()
                .alpha(0f)
                .setStartDelay(delay)
                .setDuration(animSpeed)
                .setInterpolator(AnimationUtils.loadInterpolator(aplication,
                        android.R.anim.anticipate_overshoot_interpolator));

    }

    public static void rotate(Context context, final ImageView imageView) {
        final Animation a = AnimationUtils.loadAnimation(context, R.anim.rotate180);
        a.setDuration(animSpeed);
        imageView.startAnimation(a);
        a.setFillAfter(true);
    }

    public static void moveTofinishX(final View view, final View viewOverLapped) {
        TranslateAnimation animation = new TranslateAnimation(0, viewOverLapped.getRight(), 0, viewOverLapped.getY());
        animation.setDuration(animSpeed);
        animation.setFillAfter(false);
        animation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
                scaleDownAlpha(viewOverLapped);
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                scaleAlpha(viewOverLapped);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {
            }
        });

        view.startAnimation(animation);
    }

    public static void moveToXYpoistionAndScale(View btnSpanish, TextView titleSpanish, View layoutLanguages) {

        Activity aplication = Application.getCurrentActivity();

        float w1 = btnSpanish.getWidth();
        float w2 = titleSpanish.getWidth();
        float h1 = btnSpanish.getHeight();
        float h2 = layoutLanguages.getHeight();
        float x1 = btnSpanish.getX();
        float x2 = titleSpanish.getX();
        float y1 = btnSpanish.getY();
        float y2 = titleSpanish.getY();

        btnSpanish.animate()
                .scaleX(w2 / w1)
                .scaleY(h2 / h1)
                .translationX(x2 - x1 - w1 * (1 - (w2 / w1)) / 2)
                .translationY(y2 - y1 - h1 * (1 - (h2 / h1)) / 2)
                .setStartDelay(delay)
                .setDuration(animSpeed)
                .setInterpolator(AnimationUtils.loadInterpolator(aplication,
                        android.R.anim.anticipate_overshoot_interpolator));
    }

    public static void moveToXYpoistionAndScale(Context context, View horizontalBar, float percentage, int width) {

        horizontalBar.setScaleX(0f);

        horizontalBar.animate()
                .scaleX(percentage)
                .translationX(- width * (1 - (percentage))/2)
                .setDuration(animSpeed)
                .setInterpolator(AnimationUtils.loadInterpolator(context,
                        android.R.anim.accelerate_decelerate_interpolator));
    }

    public static void backgroundColorAnimation(Context context, final View view, int colorTo) {
        ObjectAnimator animator = ObjectAnimator.ofInt(view, "backgroundColor",
                ContextCompat.getColor(context, R.color.cardview_light_background), colorTo).setDuration(animSpeed);
        animator.setEvaluator(new ArgbEvaluator());
        animator.start();
    }

    public static void openCloseCard(final View contentCard, ImageButton btnCollapseCard, ViewGroup contentMain) {
        animSpeed = FAST_ANIM;
        if (contentCard.getVisibility() == View.VISIBLE) {
            closeCard(contentCard, btnCollapseCard, contentMain);
        } else {
            openCard(contentCard, btnCollapseCard, contentMain);
        }
    }

    public static void closeCard(final View contentCard, final ImageButton btnCollapseCard, ViewGroup contentMain) {
        btnCollapseCard.setImageResource(R.drawable.ic_arrow_drop_up_24dp);
        ViewAnimation.rotate(Application.getCurrentContext(), btnCollapseCard);
        contentCard.setVisibility(View.GONE);
        TransitionManager.beginDelayedTransition(contentMain, new AutoTransition());
    }

    public static void openCard(View contentCard, final ImageButton btnCollapseCard, ViewGroup contentMain) {
        btnCollapseCard.setImageResource(R.drawable.ic_arrow_drop_down_24dp);
        ViewAnimation.rotate(Application.getCurrentContext(), btnCollapseCard);
        contentCard.setVisibility(View.VISIBLE);
        TransitionManager.beginDelayedTransition(contentMain, new AutoTransition());
    }

}
