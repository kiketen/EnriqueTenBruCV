package com.linhoapps.tenbrucv.mvp.view_presenter.horizontalBarLibrary;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.linhoapps.tenbrucv.R;
import com.linhoapps.tenbrucv.mvp.model.business_logic.objects.ParticularSkill;
import com.linhoapps.tenbrucv.utils.animations.ViewAnimation;

import java.util.ArrayList;

import static com.linhoapps.tenbrucv.utils.animations.ViewAnimation.FAST_ANIM;
import static com.linhoapps.tenbrucv.utils.animations.ViewAnimation.delay;

/**
 * Created by KTB on 01/03/2017.
 */

public class MyRecyclerViewAdapter extends RecyclerView.Adapter<MyRecyclerViewAdapter.CustomViewHolder> {
    private ArrayList<ParticularSkill> itemsList;
    private Context context;
    private int lastPosition = -1;
    private int width = 0;

    public MyRecyclerViewAdapter(Context context, ArrayList<ParticularSkill> itemsList) {
        this.itemsList = itemsList;
        this.context = context;
    }

    @Override
    public CustomViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.recycler_skills_bars, null);
        CustomViewHolder viewHolder = new CustomViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(MyRecyclerViewAdapter.CustomViewHolder holder, int position) {
        ParticularSkill singleItem = itemsList.get(position);
        holder.tvNameHorizontalBar.setText(singleItem.getName());
        float percentage = (singleItem.getNumber()/5);
        getWidthAndStartAnimation(holder.lyHorizontalBar, position, percentage);
    }

    private void getWidthAndStartAnimation(final View view, final int position, final float percentage) {
            ViewTreeObserver vto = view.getViewTreeObserver();
            vto.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
                @Override
                public void onGlobalLayout() {
                    view.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                    width  = view.getMeasuredWidth();
                    setAnimation(view, position, percentage);
                }
            });

    }

    private void setAnimation(View lyHorizontalBar, int position, float percentage) {
        // If the bound view wasn't previously displayed on screen, it's animated
        if (position > lastPosition)
        {
            int color;
            ViewAnimation.moveToXYpoistionAndScale(context,lyHorizontalBar, percentage, width);
            if(percentage > 0.7){
                color = ContextCompat.getColor(context, R.color.colorAccent);
            }else if(percentage < 0.7 && percentage > 0.4){
                color = ContextCompat.getColor(context, R.color.colorAccent);
            }else{
                color = ContextCompat.getColor(context, R.color.colorAccent);
            }
            ViewAnimation.backgroundColorAnimation(context, lyHorizontalBar, color);
            lastPosition = position;
        }
    }

    @Override
    public int getItemCount() {
        return (null != itemsList ? itemsList.size() : 0);
    }

    public class CustomViewHolder extends RecyclerView.ViewHolder {

        protected TextView tvNameHorizontalBar;
        protected LinearLayout lyHorizontalBar;

        public CustomViewHolder(View view) {
            super(view);
            this.tvNameHorizontalBar = (TextView) view.findViewById(R.id.name);
            this.lyHorizontalBar = (LinearLayout) view.findViewById(R.id.bar);
        }

    }
}