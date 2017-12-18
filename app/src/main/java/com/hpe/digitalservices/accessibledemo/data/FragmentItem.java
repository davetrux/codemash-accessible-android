package com.hpe.digitalservices.accessibledemo.data;

import android.support.v4.app.Fragment;

/**
 * Data transfer object
 *
 * @author trux on 9/13/16.
 */
public class FragmentItem {

    private String name;
    private Fragment fragment;

    public FragmentItem(String name, Fragment fragment) {

        this.name = name;
        this.fragment = fragment;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Fragment getFragment() {
        return fragment;
    }

    public void setFragment(Fragment fragment) {
        this.fragment = fragment;
    }
}
