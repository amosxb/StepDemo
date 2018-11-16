package com.example.administrator.stepdemo.ui.activity;

import android.widget.ImageView;
import android.widget.TextView;

import com.example.administrator.stepdemo.R;
import com.example.administrator.stepdemo.base.BaseActivity;
import com.example.administrator.stepdemo.base.BasePresenter;
import com.example.administrator.stepdemo.utils.QRCodeUtil;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * 我的二维码界面
 *
 * @author xb
 * @time 2018/11/15 0015 17:31
 */
public class MyQRCodeActivity extends BaseActivity {


    @BindView(R.id.iv_scan)
    ImageView ivScan;
    @BindView(R.id.tv_scan)
    TextView tvScan;

    @Override
    protected int contentViewId() {
        return R.layout.activity_my_qr_code;
    }

    @Override
    protected BasePresenter createPresenter() {
        return null;
    }

    @Override
    protected void initView() {
        getAppbarTitleTextView().setText("我的二维码");
        ivScan.setImageBitmap(QRCodeUtil.createQRCodeBitmap("www.baidu.com", 215, 215));
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initListener() {

    }

    @OnClick(R.id.tv_scan)
    public void onClick() {
    }
}
