package com.hpe.digitalservices.accessibledemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Utils.setUiTheme(this);

        setContentView(R.layout.activity_main);

        this.setUpNavigation();

        List<FragmentItem> fragments = getFragments();

        DemoPagerAdapter pageAdapter = new DemoPagerAdapter(getSupportFragmentManager(), fragments);

        ViewPager pager = (ViewPager)findViewById(R.id.viewpager);
        pager.setAdapter(pageAdapter);
        pager.setOffscreenPageLimit(3);
        // Give the TabLayout the ViewPager
        TabLayout tabLayout = (TabLayout) findViewById(R.id.sliding_tabs);
        tabLayout.setupWithViewPager(pager);

        startService(new Intent(getApplication(), RecorderService.class));

    }

    private List<FragmentItem> getFragments(){

        List<FragmentItem> fList = new ArrayList<>(3);


        fList.add(new FragmentItem("Who", new WhoFragment()));
        fList.add(new FragmentItem("Where", new WhereFragment()));
        fList.add(new FragmentItem("What", new WhatFragment()));

        return fList;
    }


    class DemoPagerAdapter extends FragmentPagerAdapter {
        private List<FragmentItem> fragments;

        public DemoPagerAdapter(FragmentManager fm, List<FragmentItem> fragments) {
            super(fm);
            this.fragments = fragments;
        }
        @Override
        public Fragment getItem(int position) {
            FragmentItem item = this.fragments.get(position);
            return item.getFragment();
        }
        @Override
        public int getCount() {
            return this.fragments.size();
        }

        @Override
        public CharSequence getPageTitle(int position) {
            // Generate title based on item position
            FragmentItem item = this.fragments.get(position);
            return item.getName();
        }
    }
}
