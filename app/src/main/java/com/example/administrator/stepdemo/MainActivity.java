package com.example.administrator.stepdemo;

import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageView;

import com.example.administrator.stepdemo.base.BaseActivity;
import com.example.administrator.stepdemo.base.BasePresenter;
import com.example.administrator.stepdemo.ui.adapter.CommonFragmentPagerAdapter;
import com.example.administrator.stepdemo.ui.fragment.FragmentFactory;
import com.example.administrator.stepdemo.utils.UIUtils;
import com.zhy.autolayout.AutoRelativeLayout;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * app主界面
 *
 * @author xb
 * @time 2018/11/14 0014 13:42
 */
public class MainActivity extends BaseActivity implements ViewPager.OnPageChangeListener {

    private List<Fragment> mFragments = new ArrayList<>(3);

    @BindView(R.id.vp_main_Content)
    ViewPager vpMainContent;

    @BindView(R.id.arl_main_home)
    AutoRelativeLayout arlMainHome;

    @BindView(R.id.arl_main_find)
    AutoRelativeLayout arlMainFind;

    @BindView(R.id.arl_main_me)
    AutoRelativeLayout arlMainMe;

    @BindView(R.id.iv_main_home)
    ImageView ivMainHome;

    @BindView(R.id.iv_main_find)
    ImageView ivMainFind;

    @BindView(R.id.iv_main_me)
    ImageView ivMainMe;

    @Override
    protected int contentViewId() {
        return R.layout.activity_main;
    }

    @Override
    protected BasePresenter createPresenter() {
        //TODO 这里处理主界面进来的操作
        return null;
    }

    @Override
    protected void initView() {


        //设置缓存3个界面
        vpMainContent.setOffscreenPageLimit(3);

        //设置默认选择第一个
        ivMainHome.setSelected(true);
        getAppbarTitleTextView().setText(UIUtils.getString(R.string.main_home));

        //存放fragment
        mFragments.add(FragmentFactory.getInstance().getHomeFragment());
        mFragments.add(FragmentFactory.getInstance().getFindFragment());
        mFragments.add(FragmentFactory.getInstance().getMeFragment());
        vpMainContent.setAdapter(new CommonFragmentPagerAdapter(getSupportFragmentManager(), mFragments));
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initListener() {
        vpMainContent.addOnPageChangeListener(this);
    }


    @OnClick({R.id.arl_main_home, R.id.arl_main_find, R.id.arl_main_me})
    public void onClick(View view) {
        resetTabs();
        switch (view.getId()) {
            case R.id.arl_main_home:
                vpMainContent.setCurrentItem(0, false);
                ivMainHome.setSelected(true);
                break;
            case R.id.arl_main_find:
                vpMainContent.setCurrentItem(1, false);
                ivMainFind.setSelected(true);
                break;
            case R.id.arl_main_me:
                vpMainContent.setCurrentItem(2, false);
                ivMainMe.setSelected(true);
                break;
        }
    }

    private void resetTabs() {
        ivMainHome.setSelected(false);
        ivMainFind.setSelected(false);
        ivMainMe.setSelected(false);
    }


    @Override
    protected boolean isToolbarCanBack() {
        return false;
    }

    @Override
    public void onPageScrolled(int i, float v, int i1) {

    }

    @Override
    public void onPageSelected(int i) {
        //先重置状态
        resetTabs();
        switch (i) {
            case 0:
                getAppbarTitleTextView().setText(UIUtils.getString(R.string.main_home));
                ivMainHome.setSelected(true);
                break;
            case 1:
                getAppbarTitleTextView().setText(UIUtils.getString(R.string.main_find));
                ivMainFind.setSelected(true);
                break;
            case 2:
                getAppbarTitleTextView().setText(UIUtils.getString(R.string.main_me));
                ivMainMe.setSelected(true);
                break;
        }
    }

    @Override
    public void onPageScrollStateChanged(int i) {

    }
}
