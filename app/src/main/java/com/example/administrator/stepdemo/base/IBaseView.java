package com.example.administrator.stepdemo.base;

/**
 * V层基类
 */
public interface IBaseView {

    /**
     * 显示dialog
     */
    void showDialog();

    /**
     * 关闭dialog
     */
    void closeDialog();

    /**
     * 显示Toast消息
     */
    void showToast(String msg);
}
