package com.lee.lugank.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.lee.lugank.R;
import com.lee.lugank.base.BaseFragment;
import com.lee.lugank.http.GankBean;
import com.lee.lugank.http.GankRetofit;
import com.lee.lugank.http.GankService;
import com.lee.lugank.http.Response;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 *
 */
public class GankFragment extends BaseFragment {
    private static final String TAG = "GankFragment";
    @BindView(R.id.toolbar)
    Toolbar mToolbar;
    @BindView(R.id.tab_layout)
    TabLayout mTabLayout;
    @BindView(R.id.viewPager)
    ViewPager mViewPager;

    public static GankFragment newInstance() {
        return new GankFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_discover, container, false);
        ButterKnife.bind(this,view);
        initView();

        return view;
    }

    private void initView() {

        mToolbar.setTitle(R.string.app_name);
        initToolbarNav(mToolbar);

        mViewPager.setAdapter(new GankFragmentAdapter(getChildFragmentManager()));
        mTabLayout.setupWithViewPager(mViewPager);

        GankRetofit.getRetrofit()
                .create(GankService.class)
                .getAndroid(1)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<Response<List<GankBean>>>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e(TAG, "onError: " + e.getMessage());
                    }

                    @Override
                    public void onNext(Response<List<GankBean>> listResponse) {
                        Log.i(TAG, "onNext: " + listResponse.getResults().get(0));
                    }
                });

    }
}
