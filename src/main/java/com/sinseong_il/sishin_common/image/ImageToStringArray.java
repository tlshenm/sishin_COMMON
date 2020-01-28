package com.sinseong_il.sishin_common.image;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Base64;
import android.util.Log;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;

public class ImageToStringArray {

    private static final int DEFAULT_QUALITY = 90;


    /**
     * 해당 경로의 이미지 파일을 base4로 인코딩하여 리턴해준다.
     * 예시
     * String root = Environment.getExternalStorageDirectory().getAbsolutePath() ;
     * String encodeBase64 = encodeTobase64( root + "/zerotake0/ic_launcher.png" ) ;
     */
    public static String encodeTobase64(String path) {
        return encodeTobase64(path, DEFAULT_QUALITY);
    }

    /**
     * 비트맵을 base64로 인코딩하여 리턴해준다.
     * 예시
     * Bitmap bitmap = BitmapFactory.decodeResource( activity.getResources( ),  R.drawable.ic_launcher ) ;
     * String encodeBase64 = encodeTobase64( bitmap ) ;
     */
    public static String encodeTobase64(Bitmap image) {
        return encodeTobase64(image, DEFAULT_QUALITY);
    }

    /**
     * 해당 경로의 이미지 파일을 base4로 인코딩하여 리턴해준다.
     * 예시
     * String root = Environment.getExternalStorageDirectory().getAbsolutePath() ;
     * String encodeBase64 = encodeTobase64( root + "/zerotake0/ic_launcher.png" ) ;
     */
    public static String encodeTobase64JPEG(String path) {
        return encodeTobase64JPEG(path, DEFAULT_QUALITY);
    }


    /**
     * 비트맵을 base64로 인코딩하여 리턴해준다.
     * 예시
     * Bitmap bitmap = BitmapFactory.decodeResource( activity.getResources( ),  R.drawable.ic_launcher ) ;
     * String encodeBase64 = encodeTobase64( bitmap ) ;
     */
    public static String encodeTobase64JPEG(Bitmap image) {
        return encodeTobase64JPEG(image, DEFAULT_QUALITY);
    }

    /**
     * 해당 경로의 이미지 파일을 base4로 인코딩하여 리턴해준다.
     * 예시
     * String root = Environment.getExternalStorageDirectory().getAbsolutePath() ;
     * String encodeBase64 = encodeTobase64( root + "/zerotake0/ic_launcher.png" ) ;
     */
    public static String encodeTobase64(String path, int quality) {
        Bitmap bitmap = BitmapFactory.decodeFile(path);
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, quality, baos);
        byte[] b = baos.toByteArray();
        String imageEncode = Base64.encodeToString(b, Base64.DEFAULT);
        b = null;
        return imageEncode;
    }


    /**
     * 비트맵을 base64로 인코딩하여 리턴해준다.
     * 예시
     * Bitmap bitmap = BitmapFactory.decodeResource( activity.getResources( ),  R.drawable.ic_launcher ) ;
     * String encodeBase64 = encodeTobase64( bitmap ) ;
     */
    public static String encodeTobase64(Bitmap image, int quality) {
        Bitmap bitmap = image;
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, quality, baos);
        byte[] b = baos.toByteArray();
        String imageEncode = Base64.encodeToString(b, Base64.DEFAULT);
        b = null;
        return imageEncode;
    }

    /**
     * 해당 경로의 이미지 파일을 base4로 인코딩하여 리턴해준다.
     * 예시
     * String root = Environment.getExternalStorageDirectory().getAbsolutePath() ;
     * String encodeBase64 = encodeTobase64( root + "/zerotake0/ic_launcher.png" ) ;
     */
    public static String encodeTobase64JPEG(String path, int quality) {
        Bitmap bitmap = BitmapFactory.decodeFile(path);

        ByteArrayOutputStream baos = new ByteArrayOutputStream();

        bitmap.compress(Bitmap.CompressFormat.JPEG, quality, baos);

        byte[] b = baos.toByteArray();

        String imageEncode = Base64.encodeToString(b, Base64.DEFAULT);

        b = null;

        return imageEncode;
    }


    /**
     * 비트맵을 base64로 인코딩하여 리턴해준다.
     * 예시
     * Bitmap bitmap = BitmapFactory.decodeResource( activity.getResources( ),  R.drawable.ic_launcher ) ;
     * String encodeBase64 = encodeTobase64( bitmap ) ;
     */
    public static String encodeTobase64JPEG(Bitmap image, int quality) {
        Bitmap bitmap = image;
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, quality, baos);
        byte[] b = baos.toByteArray();
        String imageEncode = Base64.encodeToString(b, Base64.DEFAULT);
        b = null;
        return imageEncode;
    }


    /**
     * @param data
     * @return
     */
    public static Bitmap decodeTobase64(String data) {

        Bitmap bm = null;
        try {
            if (data != null && !data.equals("")) {
                byte[] b = Base64.decode(data, Base64.DEFAULT);

                bm = BitmapFactory.decodeByteArray(b, 0, b.length);

                b = null;
            }

        } catch (IllegalArgumentException e) {
            Log.d("trace", "java.lang.IllegalArgumentException: bad base-64 : " + data);
        }


        return bm;
    }

    /**
     * @param data
     * @return
     */
    public static Bitmap decodeTobase64Resize(String data) {

        Bitmap bm = null;
        Bitmap resizeBm = null;
        byte[] b = null;
        try {
            if (data != null && !data.equals("")) {

                b = Base64.decode(data, Base64.DEFAULT);

                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inSampleSize = 2;

                bm = BitmapFactory.decodeByteArray(b, 0, b.length, options);
                int dstHeight = bm.getHeight() / 2;
                int dstWidth = bm.getWidth() / 2;

                resizeBm = Bitmap.createScaledBitmap(bm, dstWidth, dstHeight, true);
                b = null;
            }

        } catch (IllegalArgumentException e) {
            Log.d("trace", "java.lang.IllegalArgumentException: bad base-64 : " + data);
        } finally {
            if (bm != null) {
                bm.recycle();
                bm = null;
            }
            b = null;
        }

        return resizeBm;
    }

    /**
     * 스트링을 지정한 바이트 기준으로 잘라서 배열로 만들기
     * 이미지 또는 비트맵을 가지고 스트링을 만든 후 잘라내는데 사용
     * 예시
     * ArrayList<String> imgstr = diviceStringSize(imgString, 1024);
     */
    public static ArrayList<String> diviceStringSize(String str, int len) {
        ArrayList<String> stringArr = new ArrayList<String>();

        int strLen = str.length();
        int cnt = (int) Math.ceil(strLen / len);

        for (int i = 0; i <= cnt; i++) {
            int startLen = i * len;
            int endLen = (i + 1) * len;
            if (endLen > strLen) endLen = strLen;
            String sStr = str.substring(startLen, endLen);
            stringArr.add(sStr);
        }

        return stringArr;
    }


}
