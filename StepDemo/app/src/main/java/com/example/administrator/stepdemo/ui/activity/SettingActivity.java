package com.example.administrator.stepdemo.ui.activity;

import android.view.View;

import com.example.administrator.stepdemo.R;
import com.example.administrator.stepdemo.base.BaseActivity;
import com.example.administrator.stepdemo.base.BasePresenter;
import com.zhy.autolayout.AutoRelativeLayout;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * 设置界面
 *
 * @author xb
 * @time 2018/11/15 0015 17:32
 */
public class SettingActivity extends BaseActivity {

    @BindView(R.id.arl_feedback)
    AutoRelativeLayout arlFeedback;
    @BindView(R.id.arl_clear_cache)
    AutoRelativeLayout arlClearCache;
    @BindView(R.id.arl_privacy)
    AutoRelativeLayout arlPrivacy;
    @BindView(R.id.arl_sign_out)
    AutoRelativeLayout arlSignOut;

    @Override
    protected int contentViewId() {
        return R.layout.activity_setting;
    }

    @Override
    protected BasePresenter createPresenter() {
        return null;
    }

    @Override
    protected void initView() {
        getAppbarTitleTextView().setText("设置");
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initListener() {

    }

    @OnClick({R.id.arl_feedback, R.id.arl_clear_cache, R.id.arl_privacy, R.id.arl_sign_out})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.arl_feedback:
                FeedbackActivity.start(SettingActivity.this, FeedbackActivity.class);
                break;
            case R.id.arl_clear_cache:
                break;
            case R.id.arl_privacy:
                TermsPrivacyActivity.start(SettingActivity.this, TermsPrivacyActivity.class);
                break;
            case R.id.arl_sign_out:
                break;
        }
    }
}
