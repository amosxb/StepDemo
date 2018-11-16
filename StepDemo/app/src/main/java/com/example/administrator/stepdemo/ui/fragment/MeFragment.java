package com.example.administrator.stepdemo.ui.fragment;

import android.view.View;

import com.example.administrator.stepdemo.R;
import com.example.administrator.stepdemo.base.BaseFragment;
import com.example.administrator.stepdemo.base.BasePresenter;
import com.example.administrator.stepdemo.ui.activity.AboutActivity;
import com.example.administrator.stepdemo.ui.activity.LoginActivity;
import com.example.administrator.stepdemo.ui.activity.MyQRCodeActivity;
import com.example.administrator.stepdemo.ui.activity.SettingActivity;
import com.zhy.autolayout.AutoRelativeLayout;

import butterknife.BindView;
import butterknife.OnClick;

public class MeFragment extends BaseFragment {

    @BindView(R.id.arl_me_scan)
    AutoRelativeLayout arlMeScan;

    @BindView(R.id.arl_me_about)
    AutoRelativeLayout arlMeAbout;

    @BindView(R.id.arl_me_setting)
    AutoRelativeLayout arlMeSetting;

    @BindView(R.id.arl_me_user_info)
    AutoRelativeLayout arlMeUserInfo;

    @Override
    protected void initData() {

    }

    @Override
    protected void initListener() {

    }

    @Override
    protected void initView(View rootView) {

    }

    @Override
    protected int contentViewId() {
        return R.layout.fragment_me;
    }

    @Override
    protected void init() {

    }

    @Override
    protected BasePresenter createPresenter() {
        return null;
    }

    @OnClick({R.id.arl_me_scan, R.id.arl_me_about, R.id.arl_me_setting, R.id.arl_me_user_info})
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.arl_me_scan:
                MyQRCodeActivity.start(getActivity(), MyQRCodeActivity.class);
                break;
            case R.id.arl_me_about:
                SettingActivity.start(getActivity(), AboutActivity.class);
                break;
            case R.id.arl_me_setting:
                SettingActivity.start(getActivity(), SettingActivity.class);
                break;
            case R.id.arl_me_user_info:
                LoginActivity.start(getActivity(), LoginActivity.class);
                break;
        }
    }
}
