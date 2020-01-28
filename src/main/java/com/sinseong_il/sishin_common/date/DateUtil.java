package com.sinseong_il.sishin_common.date;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {


    /**
     * @return 현재 날짜와 시간 반환
     */
    public static String currentDate(){
        long time = System.currentTimeMillis();
        SimpleDateFormat dayTime = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

        return dayTime.format(new Date(time));
    }

    /**
     * <PRE>현재 년도조회</PRE>
     *
     * @param
     * @return 현재 년도
     */
    public static String getYear() {
        long now = System.currentTimeMillis();
        Date date = new Date(now);

        SimpleDateFormat curYearFormat = new SimpleDateFormat("yyyy");
        String resultYear = curYearFormat.format(date);

        return resultYear;
    }

    /**
     * <PRE>현재 Month조회</PRE>
     *
     * @param
     * @return 현재 Month
     */
    public static String getMonth() {
        long now = System.currentTimeMillis();
        Date date = new Date(now);

        return getMonth(date);
    }

    /**
     * <PRE>다음 Month조회</PRE>
     *
     * @param
     * @return 현재 Month
     */
    public static String getNextMonth() {
        long now = System.currentTimeMillis();
        Date date = new Date(now);
        date.setMonth(date.getMonth()+1);
        return getMonth(date);
    }

    /**
     * <PRE>이전 Month조회</PRE>
     *
     * @param
     * @return 현재 Month
     */
    public static String getPrevMonth() {
        long now = System.currentTimeMillis();
        Date date = new Date(now);
        date.setMonth(date.getMonth()-1);
        return getMonth(date);
    }


    /**
     * <PRE>현재 Month조회</PRE>
     *
     * @param
     * @return 현재 Month
     */
    public static String getMonth(Date date) {
        SimpleDateFormat curMonthFormat = new SimpleDateFormat("MM");
        String resultMonth = curMonthFormat.format(date);

        return resultMonth;
    }

    /**
     * <PRE>현재 날조회</PRE>
     *
     * @param
     * @return 현재 Day
     */
    public static String getDay() {
        long now = System.currentTimeMillis();
        Date date = new Date(now);

        SimpleDateFormat curDayFormat = new SimpleDateFormat("dd");
        String resultDay = curDayFormat.format(date);

        return resultDay;
    }

    /**
     * <PRE>현재 시간조회</PRE>
     *
     * @param
     * @return String
     */
    public static String getTime() {
        long now = System.currentTimeMillis();
        Date date = new Date(now);

        SimpleDateFormat curTimeFormat = new SimpleDateFormat("HH:mm:ss");
        String resultTime = curTimeFormat.format(date);

        return resultTime;
    }

    /**
     * <PRE>현재 분조회</PRE>
     *
     * @param
     * @return String
     */
    public static String getMinute() {
        long now = System.currentTimeMillis();
        Date date = new Date(now);

        SimpleDateFormat curYearFormat = new SimpleDateFormat("mm");
        String resultYear = curYearFormat.format(date);

        return resultYear;
    }




    /**
     * 관련
     * System.currentTimeMillis()
     *
     * 형식(time
     * 날짜 비교
     *
     * @param selectDay 선택된 날
     * @return String 변경된 문자열
     */
    public static String compareTo(String selectDay, String today) {
        String result = "Y";
        if (selectDay.compareTo(today) > 0) { //"select가 today보다 날짜가 느립니다."
            result = "Y";
        } else if (selectDay.compareTo(today) < 0) { //"select가 today보다 날짜가 빠릅니다."
            result = "N";
        } else { //"날짜가 같습니다."
            result = "identical";
        }

        return result;
    }
}
