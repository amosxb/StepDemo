package com.example.administrator.stepdemo.utils;

import java.io.Closeable;
import java.io.IOException;

/**
 * IO流工具类
 *
 * @author xb
 * @time 2018/11/13 0013 11:09
 */
public class IOUtils {
    /**
     * 关闭流
     */
    public static boolean close(Closeable io) {
        if (io != null) {
            try {
                io.close();
            } catch (IOException e) {
                LogUtils.e(e);
            }
        }
        return true;
    }
}