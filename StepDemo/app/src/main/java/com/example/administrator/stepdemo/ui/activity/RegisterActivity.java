package com.example.administrator.stepdemo.ui.activity;

import com.example.administrator.stepdemo.R;
import com.example.administrator.stepdemo.base.BaseActivity;
import com.example.administrator.stepdemo.base.BasePresenter;
import com.jaeger.library.StatusBarUtil;

/**
 * 注册界面
 *
 * @author xb
 * @time 2018/11/16 0016 10:53
 */
public class RegisterActivity extends BaseActivity {

    @Override
    protected int contentViewId() {
        return R.layout.activity_register;
    }

    @Override
    protected BasePresenter createPresenter() {
        return null;
    }

    @Override
    protected void initView() {
        StatusBarUtil.setTranslucent(this, 0);
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initListener() {

    }

    @Override
    protected boolean isLightStatusBar() {
        return false;
    }
}
