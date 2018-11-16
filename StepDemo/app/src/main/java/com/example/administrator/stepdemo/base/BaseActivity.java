package com.example.administrator.stepdemo.base;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.AppBarLayout;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.administrator.stepdemo.R;
import com.example.administrator.stepdemo.utils.LightStatusBarUtils;
import com.example.administrator.stepdemo.utils.UIUtils;
import com.jaeger.library.StatusBarUtil;
import com.trello.rxlifecycle2.components.support.RxAppCompatActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 所有activity基类
 *
 * @author xb
 * @time 2018/11/13 0013 14:48
 */
public abstract class BaseActivity<V, T extends BasePresenter<V>> extends RxAppCompatActivity {

    protected T mPresenter;

    @BindView(R.id.appBar)
    AppBarLayout appBarLayout;

    @BindView(R.id.iv_appbar_back)
    ImageView ivAppbarBack;

    @BindView(R.id.tv_appbar_title)
    TextView tvAppbarTitle;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        BaseApp.activities.add(this);

        mPresenter = createPresenter();
        if (mPresenter != null) {
            mPresenter.attachView((V) this);
        }
        //设置布局id
        setContentView(contentViewId());
        //注册butterKnife
        ButterKnife.bind(this);

        //设置状态栏颜色(根据UI给出的颜色值设置)
        StatusBarUtil.setColor(this, UIUtils.getColor(R.color.colorPrimaryDark), 0);

        //设置系统字体栏深色
        if (isLightStatusBar()) {
            LightStatusBarUtils.setLightStatusBar(this, true);
        }

        //设置appbar等信息
        setupAppBarAndToolbar();

        initView();
        initData();
        initListener();
    }

    /**
     * 设置appbar等信息
     */
    private void setupAppBarAndToolbar() {
        ivAppbarBack.setVisibility(isToolbarCanBack() ? View.VISIBLE : View.GONE);
        ivAppbarBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        //V层和P层解除绑定（当P层在进行网络访问时，V层关闭了，此时P层还存在V层的引用，会导致内存泄漏）
        if (mPresenter != null) {
            mPresenter.detachView();
        }
    }

    /**
     * 普通activity跳转
     *
     * @param context 上下文对象
     * @param t       跳转的activity对象
     */
    public static <M> void start(Context context, Class<M> t) {
        context.startActivity(new Intent(context, t));
    }

    /**
     * 设置布局id
     */
    protected abstract int contentViewId();

    /**
     * 用于创建Presenter和判断是否使用MVP模式(由子类实现)
     */
    protected abstract T createPresenter();

    /**
     * 初始化布局等操作
     */
    protected abstract void initView();

    /**
     * 初始化数据等操作
     */
    protected abstract void initData();

    /**
     * 设置监听等操作
     */
    protected abstract void initListener();


    /**
     * 是否让appbar有返回按钮(默认可以，一般一个应用中除了主界面，其他界面都是可以有返回按钮的)
     */
    protected boolean isToolbarCanBack() {
        return true;
    }


    protected TextView getAppbarTitleTextView() {
        return tvAppbarTitle;
    }

    /**
     * 是否设置系统字体深色
     * 注：本项目系统字体颜色默认为深色，如不需要改成深色，返回false即可
     */
    protected boolean isLightStatusBar() {
        return true;
    }
}
