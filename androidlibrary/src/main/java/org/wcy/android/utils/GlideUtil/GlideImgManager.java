package org.wcy.android.utils.GlideUtil;

import android.content.Context;
import android.net.Uri;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CircleCrop;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;

/**
 * Created by wcy on 2017/3/28.
 */

public class GlideImgManager {
    private static int placeholderImage = 0;

    /**
     * @param context
     * @param url      图片地址
     * @param erroImg  加载错误之后的错误图
     * @param emptyImg 加载成功之前占位图
     * @param iv
     * @param width    加载成功之前占位图
     * @param height
     */
    public static void loadImage(Context context, Object url, int erroImg, int emptyImg, final ImageView iv, int width, int height) {
        RequestOptions options = new RequestOptions().override(width, height).placeholder(emptyImg)  //加载成功之前占位图
                .error(erroImg);//加载错误之后的错误图
        Glide.with(context).asBitmap().load(url).apply(options).into(iv);
    }

    public static void loadImage(Context context, Object url, ImageView iv, RequestOptions options) {
        Glide.with(context).asBitmap().load(url).apply(options).into(iv);
    }

    public static void loadImage(Context context, Object url, final ImageView iv, int width, int height) {
        RequestOptions options = new RequestOptions().override(width, height).placeholder(placeholderImage)  //加载成功之前占位图
                .error(placeholderImage);//加载错误之后的错误图
        Glide.with(context).asBitmap().load(url).apply(options).into(iv);
    }

    /**
     * @param context
     * @param url      图片地址
     * @param erroImg  加载错误之后的错误图
     * @param emptyImg 加载成功之前占位图
     * @param iv
     */
    public static void loadImage(Context context, Object url, int erroImg, int emptyImg, final ImageView iv) {
        RequestOptions options = new RequestOptions().placeholder(emptyImg)  //加载成功之前占位图
                .error(erroImg);//加载错误之后的错误图
        Glide.with(context).asBitmap().load(url).apply(options).into(iv);
    }

    public static void loadImage(Context context, Object url, final ImageView iv) {
        loadImage(context, url, placeholderImage, placeholderImage, iv);

    }


    /**
     * 圆形显示
     **/
    public static void loadCircleImage(Context context, Object url, final ImageView iv) {
        RequestOptions options = new RequestOptions().placeholder(placeholderImage)  //加载成功之前占位图
                .centerCrop().transform(new CircleCrop()).error(placeholderImage);//加载错误之后的错误图
        Glide.with(context).load(url).apply(options).into(iv);
    }


    /**
     * 圆角显示
     **/
    public static void loadRoundCornerImage(Context context, Object url, final ImageView iv) {
        loadRoundCornerImage(context, url, 20, iv);
    }

    /**
     * @param context
     * @param url     图片加载地址
     * @param radius  圆角图片大小
     * @param iv
     */
    public static void loadRoundCornerImage(Context context, Object url, int radius, final ImageView iv) {
        RequestOptions options = new RequestOptions().placeholder(placeholderImage)  //加载成功之前占位图
                .transform(new RoundedCorners(radius)).error(placeholderImage);//加载错误之后的错误图
        Glide.with(context).load(url).apply(options).into(iv);
    }

    /**
     * 加载本地图片
     **/
    public static void loadLockImage(Context context, String imagePath, final ImageView imageView) {
        Glide.with(context).load("file://" + imagePath).into(imageView);


    }

    public static void loadLockImage(Context context, Uri imagePath, final ImageView imageView) {
        Glide.with(context).load("file://" + imagePath).into(imageView);


    }


    /**
     * 加载git图片
     *
     * @param context
     * @param resourceId
     * @param imageView
     */
    public static void loadGif(Context context, int resourceId, final ImageView imageView) {
        RequestOptions options = new RequestOptions().placeholder(placeholderImage)  //加载成功之前占位图
                .error(placeholderImage);//加载错误之后的错误图
        Glide.with(context).asBitmap().load(resourceId).apply(options).into(imageView);
    }

    public static void setPlaceholderImage(int placeholderImage) {
        GlideImgManager.placeholderImage = placeholderImage;
    }
}
