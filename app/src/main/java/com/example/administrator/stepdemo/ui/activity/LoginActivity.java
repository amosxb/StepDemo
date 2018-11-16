package com.example.administrator.stepdemo.ui.activity;

import android.view.View;

import com.example.administrator.stepdemo.R;
import com.example.administrator.stepdemo.base.BaseActivity;
import com.example.administrator.stepdemo.model.response.LoginResponse;
import com.example.administrator.stepdemo.presenter.LoginPresenter;
import com.example.administrator.stepdemo.view.ILoginView;
import com.jaeger.library.StatusBarUtil;

import butterknife.OnClick;

/**
 * 登录界面
 *
 * @author xb
 * @time 2018/11/15 0015 17:31
 */
public class LoginActivity extends BaseActivity<ILoginView, LoginPresenter> implements ILoginView {


    @Override
    protected int contentViewId() {
        return R.layout.activity_login;
    }

    @Override
    protected LoginPresenter createPresenter() {
        return new LoginPresenter(this);
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
    public void showResult(LoginResponse loginResponse) {

    }

    @Override
    public void showDialog() {

    }

    @Override
    protected boolean isLightStatusBar() {
        return false;
    }

    @Override
    public void closeDialog() {

    }

    @Override
    public void showToast(String msg) {

    }

    @OnClick(R.id.tv_register)
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_register:
                RegisterActivity.start(this, RegisterActivity.class);
                break;
        }
    }
}
