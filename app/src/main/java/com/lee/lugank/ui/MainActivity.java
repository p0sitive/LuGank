package com.lee.lugank.ui;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.view.MenuItem;

import com.lee.lugank.R;
import com.lee.lugank.base.BaseActivity;
import com.lee.lugank.base.BaseFragment;
import com.lee.lugank.ui.Gank.GankFragment;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity implements NavigationView.OnNavigationItemSelectedListener ,BaseFragment.OnFragmentOpenDrawerListener{

    @BindView(R.id.drawer_layout)
    DrawerLayout drawerLayout;
    @BindView(R.id.nav_view)
    NavigationView navigationView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);
    }

    @Override
    protected int setContainerId() {
        return R.id.fl_container;
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initView() {
//        ActionBarDrawerToggle toggle=new ActionBarDrawerToggle(this,drawerLayout,R.string.aa,R.string.aa);
//        toggle.syncState();
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        navigationView = (NavigationView) findViewById(R.id.nav_view);
        drawerLayout.openDrawer(GravityCompat.START);
        navigationView.setNavigationItemSelectedListener(this);
        navigationView.setCheckedItem(R.id.nav_home);
//        new DrawerBuilder().withActivity(this).build();

        GankFragment fragment = findFragment(GankFragment.class);
        start(GankFragment.newInstance());
    }

    @Override
    public int getContentViewId() {
        return R.layout.activity_main;
    }

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        return false;
    }

    @Override
    public void onOpenDrawer() {
        if (!drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.openDrawer(GravityCompat.START);
        }
    }
}
