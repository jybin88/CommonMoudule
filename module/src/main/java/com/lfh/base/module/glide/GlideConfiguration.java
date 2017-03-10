package com.lfh.base.module.glide;

import android.content.Context;

import com.bumptech.glide.Glide;
import com.bumptech.glide.GlideBuilder;
import com.bumptech.glide.load.engine.bitmap_recycle.LruBitmapPool;
import com.bumptech.glide.load.engine.cache.DiskLruCacheFactory;
import com.bumptech.glide.load.engine.cache.LruResourceCache;
import com.bumptech.glide.module.GlideModule;

import java.io.File;

/**
 * 自定义Glide相关配置
 * Created by lifuhai on 2017/3/9 0009.
 */
public class GlideConfiguration implements GlideModule {
    @Override
    public void applyOptions(Context context, GlideBuilder builder) {
        int maxMemory = (int) Runtime.getRuntime().maxMemory();//获取系统分配给应用的总内存大小
        int memoryCacheSize = maxMemory / 8;//设置图片内存缓存占用八分之一
        /*设置内存缓存大小*/
        builder.setMemoryCache(new LruResourceCache(memoryCacheSize));
        /*设置缓存内存大小*/
        builder.setBitmapPool(new LruBitmapPool(memoryCacheSize));

        /*设置磁盘缓存大小*/
        int diskCacheSize = 1024 * 1024 * 30;//最多可以缓存多少字节的数据
        File cacheDir = context.getExternalCacheDir();//指定的是数据的缓存地址

        if (null != cacheDir) {
            builder.setDiskCache(new DiskLruCacheFactory(cacheDir.getPath(), "glide", diskCacheSize));
        }
//        //也可以通过如下两种方式
//        builder.setDiskCache(new InternalCacheDiskCacheFactory(context, "glide", diskCacheSize));//存放在data/data/xxxx/cache/
//        builder.setDiskCache(new ExternalCacheDiskCacheFactory(context, "glide", diskCacheSize));//存放在外置文件浏览器

        /*设置图片解码格式*/
//        builder.setDecodeFormat(DecodeFormat.PREFER_ARGB_8888);//默认为PREFER_RGB_565
    }

    @Override
    public void registerComponents(Context context, Glide glide) {

    }
}
