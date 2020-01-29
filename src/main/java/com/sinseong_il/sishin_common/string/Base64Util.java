package com.sinseong_il.sishin_common.string;

import org.apache.commons.codec.binary.Base64;


/**
 * Base64 유틸리티
 */
public class Base64Util {
	
	public static byte[] dec(byte[] src) throws Exception {
		try {
			return Base64.decodeBase64(src);
		} catch(Throwable e) {
			throw new Exception(new Exception(e));
		}
	}
	
	public static byte[] enc(byte[] src) throws Exception {
		try {
			return Base64.encodeBase64(src);
		} catch(Throwable e) {
			throw new Exception(new Exception(e));
		}		
	}
	
	public static byte[] decodeBinay(String src) throws Exception {
		try {
			return Base64.decodeBase64(src.getBytes());
		} catch(Throwable e) {
			throw new Exception(new Exception(e));
		}
	}
	
	public static String encodeBinary(byte[] src) throws Exception {
		try {
			return new String(Base64.encodeBase64(src));
		} catch(Throwable e) {
			throw new Exception(new Exception(e));
		}		
	}
	
	public static String encode(String src) throws Exception {
		try {
    		return encodeBinary(src.getBytes());
		} catch(Throwable e) {
			throw new Exception(new Exception(e));
		}
	}
	
	public static String decode(String src) throws Exception {
		try {
			return new String(Base64Util.decodeBinay(src));
		} catch(Throwable e) {
			throw new Exception(new Exception(e));
		}
	}
	
}
