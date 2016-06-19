package com.lee.lugank.ui;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

import com.lee.lugank.R;
import com.lee.lugank.base.BaseActivity;

import butterknife.BindView;

/**
 * Created by lihe6 on 2016/6/19.
 */
public class WebActivity extends BaseActivity {

    @BindView(R.id.webview)
    WebView webView;
    @BindView(R.id.progressbar)
    ProgressBar progressBar;

    String url;

    @Override
    protected void initData() {
        webView.loadUrl(url);
    }

    @Override
    protected void initView() {
        webView.getSettings().setUseWideViewPort(true);
        webView.getSettings().setLoadWithOverviewMode(true);
        webView.getSettings().setSupportZoom(true);
        webView.getSettings().setBuiltInZoomControls(true);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.setVerticalScrollBarEnabled(true);
        webView.setVerticalScrollBarEnabled(true);
        webView.setWebViewClient(new CustomWebViewClient());
        webView.setWebChromeClient(new CustomWebChromeClient());
    }

    @Override
    public int getContentViewId() {
        return R.layout.activity_web;
    }

    @Override
    protected int setContainerId() {
        return 0;
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        if (webView != null) {
            if (webView.canGoBack()) {
                webView.goBack();
            } else {
                webView.removeAllViews();
                webView.destroy();
                webView = null;
            }
        }
    }

    class CustomWebViewClient extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            return false;
        }
    }

    class CustomWebChromeClient extends WebChromeClient {
        @Override
        public void onProgressChanged(WebView view, int newProgress) {
            super.onProgressChanged(view, newProgress);
            progressBar.setVisibility(View.VISIBLE);
            progressBar.setProgress(newProgress);
            if (newProgress == 100) {
                progressBar.setVisibility(View.GONE);
            }
        }
    }

    public static void startWebActivity(Context context, String url) {
        Intent intent = new Intent(context, WebActivity.class);
        intent.putExtra("url", url);
        context.startActivity(intent);

    }
}
