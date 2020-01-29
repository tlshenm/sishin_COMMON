package com.sinseong_il.sishin_common.string;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Base64;


import java.io.ByteArrayOutputStream;


/**
 * Base64 유틸리티
 */
public class Base64Util {

	/**
	 * @param path
	 * 해당 경로의 이미지 파일을 base4로 인코딩하여 리턴해준다.
	 * 예시
	 * String root = Environment.getExternalStorageDirectory().getAbsolutePath() ;
	 * String encodeBase64 = encodeTobase64( root + "/zerotake0/ic_launcher.png" ) ;
	 */
	public static String encodeToBase64( String path ) {
		Bitmap bitmap = BitmapFactory.decodeFile( path ) ;
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		bitmap.compress( Bitmap.CompressFormat.JPEG, 90, baos ) ;
		byte[] b = baos.toByteArray( ) ;
		String imageEncode = Base64.encodeToString( b, Base64.DEFAULT ) ;
		b = null;
		return imageEncode ;
	}

	/**
	 * @param image
	 * 비트맵을 base64로 인코딩하여 리턴해준다.
	 * 예시
	 * Bitmap bitmap = BitmapFactory.decodeResource( activity.getResources( ),  R.drawable.ic_launcher ) ;
	 * String encodeBase64 = encodeTobase64( bitmap ) ;
	 */
	public static String encodeToBase64(Bitmap image) {
		Bitmap bitmap = image;
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		bitmap.compress(Bitmap.CompressFormat.JPEG, 90, baos); /*압축*/
		byte[] b = baos.toByteArray();
		String imageEncode = Base64.encodeToString(b, Base64.DEFAULT);
		b = null;
		return imageEncode;
	}

	/**
	 * Base64 비트맵 반환
	 * @param data
	 * @return Bitmap
	 */
	public static Bitmap decodeToBitmapBase64 (String data) {

		Bitmap bm = null;
		try {
			if (data != null && !data.equals("")) {
				byte[] b = Base64.decode(data,Base64.DEFAULT);
				bm = BitmapFactory.decodeByteArray(b, 0, b.length);
				b = null;
			}
		} catch (IllegalArgumentException e) {
//			Log.d("trace", "java.lang.IllegalArgumentException: bad base-64 : " + data );
		}


		return bm;
	}

	/**
	 * Base64 String 반환
	 * @param src
	 * @return String
	 */
	public static String decodeToStringBase64(String src) throws Exception {
		try {
			return new String(decodeBinay(src));
		} catch(Throwable e) {
			throw new Exception(new Exception(e));
		}
	}

	public static byte[] decodeBinay(String src) throws Exception {
		try {
			return Base64.decode(src.getBytes(), Base64.DEFAULT);
		} catch(Throwable e) {
			throw new Exception(new Exception(e));
		}
	}

//	public static String encode(String src) throws Exception {
//		try {
//			return encodeBinary(src.getBytes());
//		} catch(Throwable e) {
//			throw new Exception(new Exception(e));
//		}
//	}
//
//	public static String encodeBinary(byte[] src) throws Exception {
//		try {
//			return new String(encode(src));
//		} catch(Throwable e) {
//			throw new Exception(new Exception(e));
//		}
//	}
//
//	public static byte[] encode(byte[] src) throws Exception {
//		try {
//			return Base64.encode(src, Base64.DEFAULT);
//		} catch(Throwable e) {
//			throw new Exception(new Exception(e));
//		}
//	}
//
//
//	public static byte[] dec(byte[] src) throws Exception {
//		try {
//			return Base64.decode(src, Base64.DEFAULT);
//		} catch(Throwable e) {
//			throw new Exception(new Exception(e));
//		}
//	}

}
