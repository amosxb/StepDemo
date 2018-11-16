package com.example.administrator.stepdemo.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * 所有fragment的基类
 *
 * @author xb
 * @time 2018/11/14 0014 10:32
 */
public abstract class BaseFragment<V, T extends BasePresenter<V>> extends Fragment {

    private T mPresenter;
    private Unbinder mUnbinder;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        init();

        mPresenter = createPresenter();
        if (mPresenter != null) {
            mPresenter.attachView((V) this);
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //子类不再需要设置布局ID，也不再需要使用ButterKnife.bind()
        View rootView = inflater.inflate(contentViewId(), container, false);
        mUnbinder = ButterKnife.bind(this, rootView);
        initView(rootView);
        return rootView;
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initData();
        initListener();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (mUnbinder != null) {
            mUnbinder.unbind();
        }
    }

    protected abstract void initData();

    protected abstract void initListener();

    protected abstract void initView(View rootView);

    protected abstract int contentViewId();

    protected abstract void init();

    protected abstract T createPresenter();
}
