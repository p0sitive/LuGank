package com.lee.lugank.ui;

import android.widget.ImageView;
import android.widget.Toast;

import com.lee.lugank.R;
import com.lee.lugank.base.BaseActivity;
import com.lee.lugank.ui.view.AnimDrawable;
import com.lee.lugank.ui.view.MultiAnimDrawable;

import butterknife.BindView;

/**
 * Created by Lee on 2017/5/3.
 */

public class DrawableActivity extends BaseActivity {

    @BindView(R.id.imageview)
    ImageView view;

    @BindView(R.id.imageview2)
    ImageView view2;

    @Override
    protected int setContainerId() {
        return 0;
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initView() {
        Toast.makeText(this,"set Drawable",Toast.LENGTH_SHORT).show();
        view.setImageDrawable(new AnimDrawable());

        MultiAnimDrawable multiCircle = new MultiAnimDrawable();
//        multiCircle.setBounds(0, 0, 100, 100);
        view2.setImageDrawable(multiCircle);
    }

    @Override
    public int getContentViewId() {
        return R.layout.activity_drawable;
    }
}
