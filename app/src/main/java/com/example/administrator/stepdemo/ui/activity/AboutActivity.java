package com.example.administrator.stepdemo.ui.activity;

import com.example.administrator.stepdemo.R;
import com.example.administrator.stepdemo.base.BaseActivity;
import com.example.administrator.stepdemo.base.BasePresenter;

/**
 * 关于界面
 * @author xb
 * @time 2018/11/15 0015 17:31
 */
public class AboutActivity extends BaseActivity {


    @Override
    protected int contentViewId() {
        return R.layout.activity_about;
    }

    @Override
    protected BasePresenter createPresenter() {
        return null;
    }

    @Override
    protected void initView() {
        getAppbarTitleTextView().setText("关于我们");
    }

    @Override
    protected void initData() {

    }


    @Override
    protected void initListener() {

    }
}
