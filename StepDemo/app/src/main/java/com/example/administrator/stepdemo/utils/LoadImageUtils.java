package com.example.administrator.stepdemo.utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.bumptech.glide.request.target.BitmapImageViewTarget;
import com.example.administrator.stepdemo.R;
import com.example.administrator.stepdemo.widget.GlideRoundTransform;

/**
 * 加载圆角或者圆形图片工具类
 *
 * @author xb
 * @time 2018/11/15 0015 9:49
 */
public class LoadImageUtils {

    /**
     * 加载圆角图片
     *
     * @param context     上下文
     * @param imageView   需要显示的imageView
     * @param url         加载图片地址
     * @param placeholder 加载错误图片
     */
    public static void loadRoundImage(Context context, String url, final ImageView imageView, int placeholder) {
        Glide.with(context)
                .load(url)
                .placeholder(placeholder)
                .error(placeholder)
                //.centerCrop() 千万不要加，加了就没有圆角效果了
                .transform(new CenterCrop(context), new GlideRoundTransform(context, 10))
                .into(imageView);
    }


    /**
     * 加载圆形图片
     *
     * @param context     上下文
     * @param imageView   需要显示的imageView
     * @param url         加载图片地址
     * @param placeholder 加载错误图片
     */
    public static void loadCirclePic(final Context context, String url, final ImageView imageView, int placeholder) {
        Glide.with(context)
                .load(url)
                .asBitmap()
                .placeholder(placeholder)
                .error(placeholder)
                .diskCacheStrategy(DiskCacheStrategy.ALL) //设置缓存
                .into(new BitmapImageViewTarget(imageView) {
                    @Override
                    protected void setResource(Bitmap resource) {
                        RoundedBitmapDrawable circularBitmapDrawable =
                                RoundedBitmapDrawableFactory.create(context.getResources(), resource);
                        circularBitmapDrawable.setCircular(true);
                        imageView.setImageDrawable(circularBitmapDrawable);
                    }
                });

    }
}
