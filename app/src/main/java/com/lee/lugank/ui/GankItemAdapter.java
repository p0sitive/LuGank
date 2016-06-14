package com.lee.lugank.ui;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.lee.lugank.R;
import com.lee.lugank.http.GankBean;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by lihe6 on 2016/6/7.
 */
public class GankItemAdapter extends RecyclerView.Adapter<GankItemAdapter.ItemViewHolder> {

    Context context;
    List<GankBean> beanList;

    public GankItemAdapter(Context context, List<GankBean> beanList) {
        this.context = context;
        this.beanList = beanList;
    }

    @Override
    public ItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_gank, parent,
                false);
        return new ItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ItemViewHolder holder, int position) {
        holder.updataView(beanList.get(position));
    }

    @Override
    public int getItemCount() {
        return beanList.size();
    }

    public class ItemViewHolder extends RecyclerView.ViewHolder{
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
        public ItemViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }

        public void updataView(GankBean bean) {
            this.mBean = bean;
            title.setText(mBean.getDesc());
            time.setText(mBean.getPublishedAt());
            auther.setText(mBean.getWho());

        }
    }
}
