package com.example.administrator.stepdemo.ui.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;

/**
 * 创建fragment的工厂类
 */
public class FragmentFactory {

    private static FragmentFactory sINSTANCE;

    private Fragment mFindFragment;
    private Fragment mMeFragment;
    private Fragment mHomeFragment;

    public static FragmentFactory getInstance() {
        if (sINSTANCE == null) {
            synchronized (FragmentFactory.class) {
                if (sINSTANCE == null) {
                    sINSTANCE = new FragmentFactory();
                }
            }
        }
        return sINSTANCE;
    }

    public Fragment getFindFragment() {
        if (mFindFragment == null) {
            synchronized (FragmentFactory.class) {
                if (mFindFragment == null) {
                    mFindFragment = new FindFragment();
                }
            }
        }
        return mFindFragment;
    }

    public Fragment getMeFragment() {
        if (mMeFragment == null) {
            synchronized (FragmentFactory.class) {
                if (mMeFragment == null) {
                    mMeFragment = new MeFragment();
                }
            }
        }
        return mMeFragment;
    }

    public Fragment getHomeFragment() {
        if (mHomeFragment == null) {
            synchronized (FragmentFactory.class) {
                if (mHomeFragment == null) {
                    mHomeFragment = new HomeFragment();
                }
            }
        }
        return mHomeFragment;
    }
}
