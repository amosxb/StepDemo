package com.example.administrator.stepdemo.ui.activity;

import com.example.administrator.stepdemo.R;
import com.example.administrator.stepdemo.base.BaseActivity;
import com.example.administrator.stepdemo.base.BasePresenter;

/**
 * 意见反馈
 *
 * @author xb
 * @time 2018/11/15 0015 15:51
 */
public class FeedbackActivity extends BaseActivity {

    @Override
    protected int contentViewId() {
        return R.layout.activity_feedback;
    }

    @Override
    protected BasePresenter createPresenter() {
        return null;
    }

    @Override
    protected void initView() {
        getAppbarTitleTextView().setText("意见反馈");
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initListener() {

    }
}
