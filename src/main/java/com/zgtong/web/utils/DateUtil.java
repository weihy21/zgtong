package com.zgtong.web.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 
 */
public class DateUtil {

    public static final  String YYYYMMDDHHMMSS = "yyyy-MM-dd HH:mm:ss";
    /**
     * 从当前日期到n天后
     *
     * @param num
     * @return
     */
    public static Date now2NDay(int num) {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_YEAR, num);
        return calendar.getTime();
    }

    public static int nowCompareTo(Date date) {
        return compareTo(new Date(), date);
    }

    public static int compareTo(Date first, Date second) {
        return first.compareTo(second);
    }

    public static String dateToString(Date date,String patten){
        SimpleDateFormat sdf = new SimpleDateFormat(patten);
        return  sdf.format(date);
    }

    public static boolean validataPwdResetDate(Date date){
        long restDate=date.getTime();
        long max=restDate+(90L*24L*60L*60L*1000L);
        long now = new Date().getTime();
        if(max>=now){
            return true;
        }
        return  false;
    }

}
