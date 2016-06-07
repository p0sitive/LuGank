package com.lee.lugank.http;

import com.lee.lugank.Content;

import java.util.List;

import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;

/**
 * Created by lihe6 on 2016/6/7.
 */
public interface GankService {
    @GET("api/data/{type}/{count}/{page}")
    Observable<Response<List<GankBean>>> getDatas(@Path("type") String type, @Path("count") int count, @Path("page") int page);

    @GET("api/data/" + Content.URL_TYPE_ANDROID + "/" + Content.PAGE_SIZE + "/{page}")
    Observable<Response<List<GankBean>>> getAndroid(@Path("page") int page);

    @GET("api/data/" + Content.URL_TYPE_IOS + "/" + Content.PAGE_SIZE + "/{page}")
    Observable<Response<List<GankBean>>> getIOS(@Path("page") int page);

    @GET("api/data/" + Content.URL_TYPE_GIRLS + "/" + Content.PAGE_SIZE + "/{page}")
    Observable<Response<List<GankBean>>> getGirls(@Path("page") int page);

    @GET("api/data/" + Content.URL_TYPE_VIDEO + "/" + Content.PAGE_SIZE + "/{page}")
    Observable<Response<List<GankBean>>> getVideo(@Path("page") int page);

}
