package com.example.administrator.stepdemo.view;

import com.example.administrator.stepdemo.base.IBaseView;
import com.example.administrator.stepdemo.model.response.LoginResponse;

public interface ILoginView extends IBaseView {

    void showResult(LoginResponse loginResponse);
}
