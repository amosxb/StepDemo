package com.example.administrator.stepdemo.http.api;

import com.example.administrator.stepdemo.model.request.LoginRequest;
import com.example.administrator.stepdemo.model.response.LoginResponse;

import io.reactivex.Observable;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * 登录api
 */
public interface LoginApi {

    /**
     * 登录请求api,这里预先模拟请求的api，接口参数可自行修改
     *
     * @param request 请求参数
     */
    @POST("account/login")
    Observable<LoginResponse> login(@Body LoginRequest request);
}
