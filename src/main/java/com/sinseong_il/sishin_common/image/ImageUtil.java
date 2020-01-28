package com.sinseong_il.sishin_common.image;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Base64;
import android.util.DisplayMetrics;

import java.io.ByteArrayOutputStream;

/**
 * Created by sinseong-il on 2018. 6. 7..
 */

public class ImageUtil {

    public static int SCREEN_WIDTH = 480;
    public static int SCREEN_HEIGHT = 800;

    /**
     * 전체해상도를 가져온다.
     * @param context
     */
    public static void setScreenInfo(Context context){
        DisplayMetrics dmath=context.getResources().getDisplayMetrics();	// 화면의 가로,세로 길이를 구할 때 사용합니다.
        SCREEN_WIDTH=dmath.widthPixels;
        SCREEN_HEIGHT=dmath.heightPixels;
    }




}
