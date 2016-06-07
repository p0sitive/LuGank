package com.lee.lugank.http;

/**
 * Created by lihe6 on 2016/6/7.
 */
public class Response<T> {
    private String error;
    private T results;

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public T getResults() {
        return results;
    }

    public void setResults(T results) {
        this.results = results;
    }
}
