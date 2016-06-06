package com.lee.lugank.ui.Gank;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.lee.lugank.R;
import com.lee.lugank.base.BaseFragment;

/**
 *
 */
public class GankFragment extends BaseFragment {

    public static GankFragment newInstance() {
        return new GankFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_discover, container, false);

        initView(view);

        return view;
    }

    private void initView(View view) {
        Toolbar mToolbar = (Toolbar) view.findViewById(R.id.toolbar);
        TabLayout mTabLayout = (TabLayout) view.findViewById(R.id.tab_layout);
        ViewPager mViewPager = (ViewPager) view.findViewById(R.id.viewPager);

        mToolbar.setTitle("发现");
        initToolbarNav(mToolbar);

        mTabLayout.addTab(mTabLayout.newTab().setText("11"));
        mTabLayout.addTab(mTabLayout.newTab().setText("22"));
        mTabLayout.addTab(mTabLayout.newTab().setText("33"));
        mViewPager.setAdapter(new GankFragmentAdapter(getChildFragmentManager()));
        mTabLayout.setupWithViewPager(mViewPager);
    }
}
