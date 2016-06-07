package com.lee.lugank.http;

import com.lee.lugank.Content;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by lihe6 on 2016/6/7.
 */
public class GankRetofit {
    public static Retrofit gankRetofit;

    public static Retrofit getRetrofit() {
        if (null == gankRetofit) {
            synchronized (GankRetofit.class) {
                if (null == gankRetofit) {
                    gankRetofit = new Retrofit.Builder()
                            .baseUrl(Content.GANK_URL)
                            .addConverterFactory(GsonConverterFactory.create())
                            .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                            .build();
                }
            }
        }
        return gankRetofit;
    }

}
