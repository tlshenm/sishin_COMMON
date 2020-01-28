package com.sinseong_il.sishin_common.string;

import java.util.regex.Pattern;

public class StringUtil {

    /**
     * 문자열에 특수 문자 있는지 체크
     *
     * @param
     * @return
     */
    public static boolean hasCharacters (CharSequence s) {

        Pattern ps = Pattern.compile("^[a-zA-Z0-9가-힣ㄱ-ㅎㅏ-ㅣ\\u318D\\u119E\\u11A2\\u2022\\u2025a\\u00B7\\uFE55.,?/'\\\"~*(){}|_ `:;!@#$%^*+-=]+$");  //영문, 숫자, 한글만 허용
        if(ps.matcher(s).matches()){
            return false;
        }
        return true;
    }
}
