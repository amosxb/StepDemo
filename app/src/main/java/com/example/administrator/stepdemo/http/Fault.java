package com.example.administrator.stepdemo.http;

/**
 * 异常处理类
 *
 * @author xb
 * @time 2018/11/12 0012 20:19
 */
public class Fault extends RuntimeException {

    private int errorCode;

    public Fault(int errorCode, String message) {
        super(message);
        this.errorCode = errorCode;
    }

    public int getErrorCode() {
        return errorCode;
    }
}
