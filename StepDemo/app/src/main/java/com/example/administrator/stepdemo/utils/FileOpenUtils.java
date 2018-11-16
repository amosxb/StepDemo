package com.example.administrator.stepdemo.utils;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;

import java.io.File;

/**
 * 处理文件操作类
 * @author xb
 * @time 2018/11/13 0013 11:07
 */
public class FileOpenUtils {

    /**
     * 调用自带的视频播放器
     *
     * @param context
     * @param path
     */
    private static void openVideo(Context context, String path) {
        Uri uri = Uri.parse(path);
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.setDataAndType(uri, "video/mp4");// "video/mp4"
        context.startActivity(intent);
    }

    /**
     * 调用自带的音频播放器
     *
     * @param context
     * @param path
     */
    private static void openAudio(Context context, String path) {
        File f = new File(path);
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.setDataAndType(Uri.fromFile(f), "audio/*");// "audio/mp3"
        context.startActivity(intent);
    }

    /**
     * 调用自带的图库
     *
     * @param context
     * @param path
     */
    private static void openPic(Context context, String path) {
        File f = new File(path);
        Intent intent = new Intent();
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.setAction(Intent.ACTION_VIEW);
        intent.setDataAndType(Uri.fromFile(f), "image/*");
        context.startActivity(intent);
    }

    /**
     * 调用手机上能打开对应类型文件的程序
     *
     * @param context
     * @param path
     * @return true表示成功找到程序，false表示找不到能成功打开的程序
     */
    public static boolean openFile(Context context, String path) {
        String mimeType = MimeTypeUtils.getMimeType(path);
        File f = new File(path);
        Intent intent = new Intent();
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.setAction(Intent.ACTION_VIEW);
        intent.setDataAndType(Uri.fromFile(f), mimeType);
        try {
            context.startActivity(intent);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

}
