package com.example.administrator.stepdemo.presenter;

import android.app.Activity;

import com.example.administrator.stepdemo.base.BasePresenter;
import com.example.administrator.stepdemo.http.RetrofitServiceManager;
import com.example.administrator.stepdemo.http.api.LoginApi;
import com.example.administrator.stepdemo.model.request.LoginRequest;
import com.example.administrator.stepdemo.model.response.LoginResponse;
import com.example.administrator.stepdemo.view.ILoginView;
import com.trello.rxlifecycle2.LifecycleProvider;
import com.trello.rxlifecycle2.android.ActivityEvent;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * 登录网络请求类
 *
 * @author xb
 * @time 2018/11/13 0013 15:47
 */
public class LoginPresenter extends BasePresenter<ILoginView> {

    public LoginPresenter(LifecycleProvider<ActivityEvent> provider) {
        super(provider);
    }

    public void login(String name, String pwd) {
        getView().showDialog();
        observe(RetrofitServiceManager.getInstance().create(LoginApi.class).
                login(new LoginRequest(name, pwd)))
                .subscribe(new Observer<LoginResponse>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(LoginResponse loginResponse) {
                        getView().showResult(loginResponse);
                    }

                    @Override
                    public void onError(Throwable e) {
                        getView().showToast(e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
