package com.lee.lugank.base;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;

import com.lee.lugank.App;

import butterknife.ButterKnife;
import me.yokeyword.fragmentation.SupportActivity;

/**
 * Created by lihe6 on 2016/6/3.
 */
public abstract class BaseActivity extends SupportActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);
        setContentView(getContentViewId());
        App.getInstance().pushStack(this);
        initView();
        initData();
    }


    protected abstract void initData();

    protected abstract void initView();

    public abstract int getContentViewId();

    public void gotoActivity(Class<? extends Activity> clazz,boolean finish){
        Intent intent=new Intent(this,clazz);
        startActivity(intent);
        if(finish){
            finish();
        }
    }

    public void gotoActivity(Class<? extends Activity> clazz, Bundle bundle, boolean finish) {
        Intent intent = new Intent(this, clazz);
        if (bundle != null) intent.putExtras(bundle);
        startActivity(intent);
        if (finish) {
            finish();
        }
    }


    public void gotoActivity(Class<? extends Activity> clazz, Bundle bundle, int flags, boolean finish) {
        Intent intent = new Intent(this, clazz);
        if (bundle != null) intent.putExtras(bundle);
        intent.addFlags(flags);
        startActivity(intent);
        if (finish) {
            finish();
        }
    }

}
