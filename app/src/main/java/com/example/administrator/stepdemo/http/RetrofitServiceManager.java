package com.example.administrator.stepdemo.http;

import android.support.v4.app.INotificationSideChannel;

import com.example.administrator.stepdemo.constant.ApiConfig;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * 网络请求管理类
 *
 * @author xb
 * @time 2018/11/12 0012 20:20
 */
public class RetrofitServiceManager {

    public static final int DEFAULT_TIME_OUT = 5;
    public static final int DEFAULT_READ_TIME_OUT = 10;

    private Retrofit mRetrofit;

    private RetrofitServiceManager() {
        //构造方法中初始化信息
        // 创建 OKHttpClient
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.connectTimeout(DEFAULT_TIME_OUT, TimeUnit.SECONDS);//连接超时时间
        builder.writeTimeout(DEFAULT_READ_TIME_OUT, TimeUnit.SECONDS);//写操作 超时时间
        builder.readTimeout(DEFAULT_READ_TIME_OUT, TimeUnit.SECONDS);//读操作超时时间

        // 添加公共参数拦截器
        HttpCommonInterceptor commonInterceptor = new HttpCommonInterceptor.Builder()
                .addHeaderParams("paltform", "android")
                .addHeaderParams("userToken", "1234343434dfdfd3434")
                .addHeaderParams("userId", "123445")
                .build();
        builder.addInterceptor(commonInterceptor);


        // 创建Retrofit
        mRetrofit = new Retrofit.Builder()
                .client(builder.build())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(ApiConfig.BASE_URL)
                .build();
    }

    private static class SingletonHolder {
        private static final RetrofitServiceManager INSTANCE = new RetrofitServiceManager();
    }

    public static RetrofitServiceManager getInstance() {
        return SingletonHolder.INSTANCE;
    }

    /**
     * 通过类名获取对应的service的对象
     */
    public <T> T create(Class<T> api) {
        return mRetrofit.create(api);
    }
}
