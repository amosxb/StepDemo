package com.example.administrator.stepdemo.base;

import com.trello.rxlifecycle2.LifecycleProvider;
import com.trello.rxlifecycle2.android.ActivityEvent;

import java.lang.ref.Reference;
import java.lang.ref.WeakReference;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * 封装P层与V层生命周期绑定，在进行超时的操作时候，V层关闭，同时将P层的引用释放掉
 *
 * @author xb
 * @time 2018/11/13 0013 14:03
 */
public abstract class BasePresenter<T> {

    private Reference<T> mViewRef;//View接口类的引用；
    private LifecycleProvider<ActivityEvent> mProvider;

    public BasePresenter(LifecycleProvider<ActivityEvent> provider) {
        this.mProvider = provider;
    }

    //V层和P层建立关联
    public void attachView(T view) {
        mViewRef = new WeakReference<T>(view);
    }

    //获取view对象
    protected T getView() {
        return mViewRef.get();
    }

    //判断V层和P层是否建立关联
    public boolean isViewAttached() {
        return mViewRef != null && mViewRef.get() != null;
    }

    //解除关联
    public void detachView() {//解除关联
        if (mViewRef != null) {
            mViewRef.clear();
            mViewRef = null;
        }
    }

    public LifecycleProvider<ActivityEvent> getProvider() {
        return mProvider;
    }

    public void setProvider(LifecycleProvider<ActivityEvent> mProvider) {
        this.mProvider = mProvider;
    }

    /**
     * 提取公共订阅的方法
     *
     * @param observable 订阅对象
     */
    protected <M> Observable<M> observe(Observable<M> observable) {
        return observable.subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .compose(getProvider().<M>bindUntilEvent(ActivityEvent.DESTROY))
                .observeOn(AndroidSchedulers.mainThread());
    }
}
