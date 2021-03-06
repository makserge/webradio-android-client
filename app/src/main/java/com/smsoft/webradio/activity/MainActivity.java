package com.smsoft.webradio.activity;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.smsoft.webradio.R;
import com.smsoft.webradio.adapter.TabsPageFragmentAdapter;

public class MainActivity extends AppCompatActivity {
    public static final int WEB_TAB_POSITION = 0;
    public static final int FM_TAB_POSITION = 1;
    public static final int MP3_TAB_POSITION = 2;

    private Toolbar mToolbar;
    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setupToolbar();
        setupNavigationView();
        setupTabs();
    }

    private void setupToolbar() {
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        mToolbar.setTitle(R.string.app_name);

        mToolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                return false;
            }
        });

        mToolbar.inflateMenu(R.menu.toolbar);
    }

    private void setupNavigationView() {
        final DrawerLayout drawerLayout = (DrawerLayout) findViewById(R.id.drawerLayout);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, mToolbar, 0, 0);
        drawerLayout.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.navigation);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {
                drawerLayout.closeDrawers();

                switch (item.getItemId()) {
                    case R.id.web:
                        gotoTab(WEB_TAB_POSITION);
                        break;
                    case R.id.fm:
                        gotoTab(FM_TAB_POSITION);
                        break;
                    case R.id.mp3:
                        gotoTab(MP3_TAB_POSITION);
                        break;
                    case R.id.settings:
                        //gotoTab(WEB_TAB_POSITION);
                        break;
                }
                return true;
            }
        });
    }

    private void setupTabs() {
        mViewPager = (ViewPager) findViewById(R.id.viewPager);

        TabsPageFragmentAdapter adapter = new TabsPageFragmentAdapter(getSupportFragmentManager(), this);
        mViewPager.setAdapter(adapter);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        tabLayout.setupWithViewPager(mViewPager);
    }

    private void gotoTab(int position) {
        mViewPager.setCurrentItem(position);
    }

}
