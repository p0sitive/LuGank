package com.lee.lugank.ui.Gank;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.lee.lugank.R;
import com.lee.lugank.base.RefreshableFragment;
import com.lee.lugank.http.GankBean;
import com.lee.lugank.http.GankRetofit;
import com.lee.lugank.http.GankService;
import com.lee.lugank.http.Response;

import java.util.ArrayList;
import java.util.List;

import me.yokeyword.fragmentation.anim.DefaultNoAnimator;
import me.yokeyword.fragmentation.anim.FragmentAnimator;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 *
 */
public class PagerChildFragment extends RefreshableFragment {
    private static final String ARG_FROM = "arg_from";
    private static final String TAG = "PagerChildFragment";
    private int mFrom;

    private RecyclerView mRecy;
    private PagerAdapter mAdapter;
    private GankItemAdapter gankItemAdapter;

    public static PagerChildFragment newInstance(int from) {
        Bundle args = new Bundle();
        args.putInt(ARG_FROM, from);

        PagerChildFragment fragment = new PagerChildFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Bundle args = getArguments();
        if (args != null) {
            mFrom = args.getInt(ARG_FROM);
        }
    }

    @Override
    protected View onCreateContentView(LayoutInflater inflater, ViewGroup container) {
        View view = inflater.inflate(R.layout.fragment_pager, container, false);

        initView(view);

        return view;
    }

    @Override
    protected FragmentAnimator onCreateFragmentAnimation() {
        return new DefaultNoAnimator();
    }

    private void initView(View view) {
        mRecy = (RecyclerView) view.findViewById(R.id.recy);

        mAdapter = new PagerAdapter(_mActivity);
        LinearLayoutManager manager = new LinearLayoutManager(_mActivity);
        mRecy.setLayoutManager(manager);
        //mRecy.setAdapter(mAdapter);

        mAdapter.setOnItemClickListener(new PagerAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position, View view) {
                if (getParentFragment() instanceof GankFragment) {
                    //((GankFragment) getParentFragment()).start(CycleFragment.newInstance(1));
                }
            }
        });

        // Init Datas
        List<String> items = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            String item;
            if (mFrom == 0) {
                item = "推荐 " + i;
            } else if (mFrom == 1) {
                item = "热门 " + i;
            } else {
                item = "收藏 " + i;
            }
            items.add(item);
        }
        mAdapter.setDatas(items);

        //=======

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
                        gankItemAdapter = new GankItemAdapter(getContext(), listResponse.getResults());
                        mRecy.setAdapter(gankItemAdapter);
                    }
                });



    }

    @Override
    public void onRefresh() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                getRefreshLayout().setRefreshing(false);
            }
        }, 2000);
    }
}
