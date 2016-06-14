package com.lee.lugank.ui;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.lee.lugank.R;
import com.lee.lugank.http.GankBean;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by lihe6 on 2016/6/7.
 */
public class GankViewHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.icon_title)
    ImageView icon_title;
    @BindView(R.id.tv_title)
    TextView title;
    @BindView(R.id.item_auther)
    TextView auther;
    @BindView(R.id.item_time)
    TextView time;

    Context context;
    GankBean mBean;

    public GankViewHolder(View itemView) {
        super(itemView);
        this.context = itemView.getContext();
        ButterKnife.bind(this, itemView);
    }

    public void updataView(GankBean bean) {
        this.mBean = bean;
        title.setText(mBean.getDesc());
        time.setText(mBean.getPublishedAt());
        auther.setText(mBean.getWho());

    }
}
