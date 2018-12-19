package com.cecgw.cq.util;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.Optional;

/**
 * @author denghualin
 * @version V1.0
 * @since 2018-11-15
 */
public class TimeUtil {

    public static final DateTimeFormatter FUALLDATE = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    public static final DateTimeFormatter YM = DateTimeFormatter.ofPattern("yyyy-MM");
    public static final DateTimeFormatter RFC = DateTimeFormatter.ofPattern("EEE MMM dd HH:mm:ss zzz yyyy",Locale.US);
    public static final String RFC_CODE = "EEE MMM dd HH:mm:ss zzz yyyy";
    public static final String FULL_CODE = "yyyy-MM-dd HH:mm:ss";

    //获取当前时间的前n分钟
    public static LocalDateTime beforeThree(int n){
        LocalDateTime localTime = LocalDateTime.now();
      return localTime.minusMinutes(n);
    }

    /**
     * @param time
     * @return
     */
    public static LocalDateTime createTime(String time){
        return LocalDateTime.parse(time);
    }

    public static LocalDateTime createRfcTime(String time){
        return LocalDateTime.parse(time, TimeUtil.RFC);
    }

    /**
     * 照搬逻辑 封装时间
     * @return
     */
    public static String getEnumTime()
    {
        final String dayNames[] = { "星期日", "星期一", "星期二", "星期三", "星期四", "星期五","星期六" };
        Calendar calendar = Calendar.getInstance();
        int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK)-1;
        if(dayOfWeek <0) {
            return dayNames[0];
        }else {
            return dayNames[dayOfWeek];
        }
    }

    /**
     * 获取星期几
     * @param currentTime
     * @return
     */
    public static String getWeek(Calendar currentTime){

        String weekday = "星期日";
        int currentHour = currentTime.get(Calendar.HOUR_OF_DAY);
        try {// 查询今天是星期几？
            final String dayNames[] = { "星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六" };

            int dayOfWeek = currentTime.get(Calendar.DAY_OF_WEEK) - 1;
            if (dayOfWeek < 0)
                dayOfWeek = 0;
            weekday = dayNames[dayOfWeek];
            if (currentHour == 0) {// 如果是“零点”的数据插入，则将星期向前推一天
                if (dayOfWeek - 1 < 0)
                    dayOfWeek = 7;
                weekday = dayNames[dayOfWeek - 1];
            }
        } catch (Exception e) {

        }
        return weekday;
    }


    public static void main(String[] args) throws ParseException {
//        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EE MM dd HH:mm:ss zzz yyyy");


    }
    /**
     * 字符串转日期
     * @param dateStr
     * @param format
     * @return
     */
    public static Date getDate(String dateStr,String format) throws ParseException {
        SimpleDateFormat dbUseSdf = new SimpleDateFormat(format);
        return dbUseSdf.parse(dateStr);
    }

    /**
     * 字符串转日期
     * @param dateStr
     * @param format
     * @return
     */
    public static Date getDate(Date date,String format) throws ParseException {
        SimpleDateFormat dbUseSdf = new SimpleDateFormat(format);
        return dbUseSdf.parse(dbUseSdf.format(date));
    }


    public static Optional<String> covertFormat(String time, String parttern){
        SimpleDateFormat sdf = new SimpleDateFormat(parttern);
        try {
            Date date = sdf.parse(time);
            return Optional.of(sdf.format(date));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return Optional.of("");
    }

    public static String getTime(Date date,String parttern){
        SimpleDateFormat sdf = new SimpleDateFormat(parttern);
        return sdf.format(date);
    }

}
