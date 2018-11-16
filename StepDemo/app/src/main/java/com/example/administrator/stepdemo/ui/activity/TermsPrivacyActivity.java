package com.example.administrator.stepdemo.ui.activity;

import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.widget.TextView;

import com.example.administrator.stepdemo.R;
import com.example.administrator.stepdemo.base.BaseActivity;
import com.example.administrator.stepdemo.base.BasePresenter;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 条款隐私
 *
 * @author xb
 * @time 2018/11/15 0015 16:29
 */
public class TermsPrivacyActivity extends BaseActivity {

    @BindView(R.id.tv_content)
    TextView tvContent;

    @Override
    protected int contentViewId() {
        return R.layout.activity_terms_privacy;
    }

    @Override
    protected BasePresenter createPresenter() {
        return null;
    }

    @Override
    protected void initView() {
        getAppbarTitleTextView().setText("条款隐私");
        tvContent.setMovementMethod(ScrollingMovementMethod.getInstance());
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initListener() {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }
}
