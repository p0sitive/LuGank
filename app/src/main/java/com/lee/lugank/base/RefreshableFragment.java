package com.lee.lugank.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.lee.lugank.R;


/**
 * Created by lihe6 on 2016/6/7.
 */
public abstract class RefreshableFragment extends BaseFragment implements SwipeRefreshLayout.OnRefreshListener {

    public SwipeRefreshLayout getRefreshLayout() {
        return refreshLayout;
    }

    private SwipeRefreshLayout refreshLayout;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_base_refreshable, container, false);
        ViewGroup contentView = (ViewGroup) view.findViewById(R.id.refreshlayout);
        contentView.addView(onCreateContentView(inflater, container));
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        refreshLayout= (SwipeRefreshLayout) view.findViewById(R.id.refreshlayout);
        if(refreshLayout!=null){
            refreshLayout.setOnRefreshListener(this);
            refreshLayout.setColorSchemeColors(R.color.colorPrimary);
        }
    }

    protected abstract View onCreateContentView(LayoutInflater inflater, ViewGroup container);
}
