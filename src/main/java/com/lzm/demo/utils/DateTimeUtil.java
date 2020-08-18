package com.lzm.demo.utils;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.*;

public class DateTimeUtil {

    private static Logger logger = LoggerFactory.getLogger(DateTimeUtil.class);

    public static final String DATE_PATTERN_JUEST_YEAR = "yyyy";
    public static final String DATE_PATTERN_JUEST_DAY = "dd";
    public static final String DATE_PATTERN_JUEST_MONTH = "MM";
	public static final String DAY_FIRST_TIME = " 00:00:00";
    public static final String DAY_LAST_TIME = " 23:59:59";
    public static final String HOUR_OF_DAY_START = "yyyy-MM-dd HH:00:00";
    public static final String HOUR_OF_DAY_END = "yyyy-MM-dd HH:59:59";
    public static final String DATE_PATTERN_MONTH = "yyyy-MM";
    public static final String DATE_PATTERN_DAY = "yyyy-MM-dd";
    public static final String DATE_PATTERN_DEFAULT = "yyyy-MM-dd HH:mm:ss";
    public static final String DATE_PATTERN_DEFAULT_TWO = "yyyy-MM-dd HH:mm:ss.SSS";
    public static final String DATE_PATTERN_TIME = "HH:mm:ss";
    public static final String DATE_PATTERN = "yyyyMMddHHmmss";
    public static final String DATE_HOUSE_MIN = "HH:mm";

    public static final String SINGLE_BIDDAY_FIRST_TIME = " 02:00:00";
    public static final String SINGLE_AUTO_BID_LOAN_TIME = " 22:00:00";
    public static final String SINGLE_BID_DAY_LAST_TIME = " 23:00:00";
    public static final String DATE_PATTERN_DAY_NUM = "yyyyMMdd";
    public static final String DATE_PATTERN_DAY_DIAGONAL = "yyyy/M/d";
    public static final String DATE_PATTERN_MINUTE = "yyyy-MM-dd HH:mm";
    public static final String DATE_PATTERN_DAY_CHINNESS = "【yyyy】年【MM】月【dd】";
    public static final String DATE_PATTERN_DAY_CHINNESS_DEFAULT = "yyyy年MM月dd日";

    public static long MILLISECOND = 1;
    public static long SECOND = 1000;
    public static long MINUTE = SECOND * 60;
    public static long HOUR = MINUTE * 60;
    public static long DAY = HOUR * 24;
    public static long YEAR = DAY * 365;

    public static String getDateTimeString(Calendar c) {
        return getDateTimeString(c.getTime());
    }

    public static String getDateTimeString(Date date) {
        return getDateTimeString(date, "yyyy-MM-dd HH:mm:ss");
    }

    public static String getDateTimeString(Calendar c, String format) {
        return getDateTimeString(c.getTime(), format);
    }

    public static String getDateTimeString(Date date, String format) {
        return new SimpleDateFormat(format).format(date);
    }

    public static String getDateString(Calendar c) {
        return getDateString(c.getTime());
    }

    public static String getDateString(Date date) {
        return getDateString(date, "yyyy-MM-dd");
    }

    public static String getDateYearDay(Date date) {
        return getDateString(date, "MM-dd");
    }

    public static String getDateString(Calendar c, String format) {
        return getDateString(c.getTime(), format);
    }

    public static String getDateString(Date date, String format) {
        return new SimpleDateFormat(format).format(date);
    }

    public static Calendar getDateTime(String str) throws ParseException {
        return getDateTime(str, "yyyy-MM-dd HH:mm:ss");
    }

    public static Calendar getDateTime(String str, String format) throws ParseException {
        Calendar cal = Calendar.getInstance();
        cal.setTime(new SimpleDateFormat(format).parse(str));
        return cal;
    }

    public static Calendar getDate(String str) throws ParseException {
        return getDate(str, "yyyy-MM-dd");
    }

    public static Calendar getDate(String str, String format) throws ParseException {
        Calendar cal = Calendar.getInstance();
        cal.setTime(new SimpleDateFormat(format).parse(str));
        return cal;
    }

    public static long getTimeInterval(Date before, Date later) {
        return getTimeInterval(before, later, MILLISECOND);
    }

    public static long getTimeInterval(Date before, Date later, long unit) {
        return (later.getTime() - before.getTime()) / unit;
    }

    /**
     * 获取默认的日期格式
     * @return
     */
    public static DateFormat getDateFormatByName(String format) {
        return new SimpleDateFormat(format);
    }
    /**
     * String转Date
     * @param str
     * @param format
     * @return
     * @throws ParseException
     */
    public static Date stringToDate(String str, String format){
        try {
            return getDateFormatByName(format).parse(str);
        }catch (ParseException e){
            logger.error("出现异常:{}",e);
        }
        return null;
    }

    /**
     * String转long
     * @param str (2018-10-10 12:00:00)
     * @return
     */
    public static long time(String str){
        SimpleDateFormat format = new SimpleDateFormat(DateTimeUtil.DATE_PATTERN_DEFAULT);
        ParsePosition pos = new ParsePosition(0);
        long time = format.parse(str, pos).getTime();
        return time;
    }

    /**
     * Date转String
     * @param date
     * @param pattern
     * @return
     */
    public static String dateToString(Date date, String pattern) {
        String str = "";
        try {
            SimpleDateFormat formater = new SimpleDateFormat(pattern);
            str = formater.format(date);
        } catch (Throwable e) {
            logger.error("出现异常:{}",e);
        }
        return str;
    }

    /**
     * @param
     * @return Calendar
     * @throws
     * @Title: getNow
     * @Description: 获取当前时间
     * @author MaoWei
     * @version 1.0
     * @createtime 2010-10-23 下午12:24:18
     */
    public static Calendar getNow() {
        return Calendar.getInstance();
    }

    /**
     * @param
     * @return Calendar
     * @throws
     * @Title: getNowDate
     * @Description: 获取当前时间
     * @author MaoWei
     * @version 1.0
     * @createtime 2010-10-23 下午12:36:16
     */
    public static Date getNowDate() {
        return Calendar.getInstance().getTime();
    }

    /**
     * 获取指定日期的 零点时间 即：00:00:00
     */
    public static Date getFirstSecondOfDay(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal = getFirstSecondOfDay(cal);
        return cal.getTime();
    }

    /**
     * 获取指定日期的 零点时间 即：00:00:00
     */
    public static Calendar getFirstSecondOfDay(Calendar cal) {
        Calendar c = cal;
        c.set(Calendar.HOUR_OF_DAY, 0);
        c.set(Calendar.MINUTE, 0);
        c.set(Calendar.SECOND, 0);
        c.set(Calendar.MILLISECOND, 0);
        return c;
    }

    /**
     * 获取指定日期的 最后一秒的时间  即：23:59:59
     */
    public static Date getLastSecondOfDay(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal = getLastSecondOfDay(cal);
        return cal.getTime();
    }

    /**
     * 获取指定日期的 最后一秒的时间  即：23:59:59
     */
    public static Calendar getLastSecondOfDay(Calendar cal) {
        Calendar c = cal;
        c.set(Calendar.HOUR_OF_DAY, 23);
        c.set(Calendar.MINUTE, 59);
        c.set(Calendar.SECOND, 59);
        c.set(Calendar.MILLISECOND, 999);
        return c;
    }

    /**
     * 获取上月第一天日期
     */
    public static Calendar getPreviousMonthFirstDay() {
        Calendar lastDate = Calendar.getInstance();
        lastDate.add(Calendar.MONTH, -1);// 减一个月，变为下月的1号
        lastDate.set(Calendar.DATE, 1);// 设为当前月的1号
        lastDate.set(Calendar.HOUR_OF_DAY, 0);
        lastDate.set(Calendar.MINUTE, 0);
        lastDate.set(Calendar.SECOND, 0);
        lastDate.set(Calendar.MILLISECOND, 0);
        return lastDate;
    }

    /**
     * 获得上月最后一天的日期
     */
    public static Calendar getPreviousMonthLastDay() {
        Calendar lastDate = Calendar.getInstance();
        lastDate.add(Calendar.MONTH, -1);// 减一个月
        lastDate.set(Calendar.DATE, 1);// 把日期设置为当月第一天
        lastDate.roll(Calendar.DATE, -1);// 日期回滚一天，也就是上月最后一天
        lastDate.set(Calendar.HOUR_OF_DAY, 23);
        lastDate.set(Calendar.MINUTE, 59);
        lastDate.set(Calendar.SECOND, 59);
        lastDate.set(Calendar.MILLISECOND, 999);
        return lastDate;
    }

    /**
     * 35. 获取今年是哪一年
     *
     * @return
     */
    public static Integer getNowYear() {
        Date date = new Date();
        GregorianCalendar gc = (GregorianCalendar) Calendar.getInstance();
        gc.setTime(date);
        return Integer.valueOf(gc.get(1));
    }


    /**
     * 36. 获取本月是哪一月
     *
     * @return
     */
    public static int getNowMonth() {
        Date date = new Date();
        GregorianCalendar gc = (GregorianCalendar) Calendar.getInstance();
        gc.setTime(date);
        return gc.get(2) + 1;
    }

    /**
     * 41. 获取下月的开始时间
     *
     * @return
     */
    public static Date getBeginTimeOfNextMonth() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(getNowYear(), getNowMonth(), 1);
        return getBeginTimeOfDay(calendar.getTime());
    }


    /**
     * 42. 获取下月的结束时间
     *
     * @return
     */
    public static Date getEndTimeOfNextMonth() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(getNowYear(), getNowMonth(), 1);
        int day = calendar.getActualMaximum(5);
        calendar.set(getNowYear(), getNowMonth(), day);
        return getEndTimeOfDay(calendar.getTime());
    }

    /**
     * 得到本周的第一天（认为周一是第一天）
     */
    public static Calendar getCurrentWeekFirstDay() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        return calendar;
    }

    /**
     * 得到本周的最后一天（认为周六是最后一天）
     */
    public static Calendar getCurrentWeekLastDay() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.DAY_OF_WEEK, Calendar.SATURDAY);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        return calendar;
    }

    /**
     * @param
     * @return Calendar
     * @throws
     * @Title: getCurrentMonthFirstDay
     * @Description: 获取当月第一天
     * @author MaoWei
     * @version 1.0
     * @createtime 2010-10-23 下午12:23:21
     */
    public static Calendar getCurrentMonthFirstDay() {
        Calendar lastDate = Calendar.getInstance();
        lastDate.set(Calendar.DATE, 1);// 设为当前月的1号
        lastDate.set(Calendar.HOUR_OF_DAY, 0);
        lastDate.set(Calendar.MINUTE, 0);
        lastDate.set(Calendar.SECOND, 0);
        lastDate.set(Calendar.MILLISECOND, 0);
        return lastDate;
    }

    /**
     * @param
     * @return Calendar
     * @throws
     * @Title: getCurrentMonthFirstDay
     * @Description: 获取当月最后一天
     * @author MaoWei
     * @version 1.0
     * @createtime 2010-10-23 下午12:20:36
     */
    public static Calendar getCurrentMonthLastDay() {
        Calendar lastDate = Calendar.getInstance();
        lastDate.set(Calendar.DATE, 1);// 设为当前月的1号
        lastDate.roll(Calendar.DATE, -1);
        lastDate.set(Calendar.HOUR_OF_DAY, 0);
        lastDate.set(Calendar.MINUTE, 0);
        lastDate.set(Calendar.SECOND, 0);
        lastDate.set(Calendar.MILLISECOND, 0);
        return lastDate;
    }

    /**
     * 获取单位时间前的时间值
     * @param date 时间
     * @param unit  时间单位
     * @param value  时间差
     * @return
     */
    public static Date getDateBefore(Date date, int unit, int value) {
        Calendar now = Calendar.getInstance();
        now.setTime(date);
        now.add(unit, -value);
        return now.getTime();
    }


    /**
     * 获取单位时间后的时间值
     * @param date 时间
     * @param unit  时间单位
     * @param value  时间差
     * @return
     */
    public static Date getDateAfter(Date date, int unit, int value) {
        Calendar now = Calendar.getInstance();
        now.setTime(date);
        now.add(unit, value);
        return now.getTime();
    }

    /**
     * @param
     * @return Timestamp
     * @throws
     * @Title: getTimestamp
     * @Description: 获取指定日期的 Timestamp 格式日期
     * @author MaoWei
     * @version 1.0
     * @createtime 2010-10-23 下午12:23:00
     */
    public static Timestamp getTimestamp(Date date) {
        return new Timestamp(date.getTime());
    }

    public static int getAge(Date birthday, Date now) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(now);
        int yearNow = cal.get(Calendar.YEAR);
        int monthNow = cal.get(Calendar.MONTH);
        int dayOfMonthNow = cal.get(Calendar.DAY_OF_MONTH);

        cal.setTime(birthday);

        int yearBirth = cal.get(Calendar.YEAR);
        int monthBirth = cal.get(Calendar.MONTH);
        int dayOfMonthBirth = cal.get(Calendar.DAY_OF_MONTH);

        int age = yearNow - yearBirth;

        if (monthNow <= monthBirth) {
            if (monthNow == monthBirth) {
                if (dayOfMonthNow < dayOfMonthBirth) {
                    age--;
                }
            } else {
                age--;
            }
        }
        return age;
    }


    /**
     * Description: 获取时间差
     * @param
     * @return
     * @throws
     * @see
     * @Note:
     */
    public static Integer getTimeDifference(Date elaryDate,Date laterDate) {
        Calendar elary = Calendar.getInstance();
        elary.setTime(elaryDate);
        Calendar later = Calendar.getInstance();
        later.setTime(laterDate);
        Long aTime = later.getTimeInMillis();
        Long bTime = elary.getTimeInMillis();
        Long cTime = aTime-bTime;
        Long sTime = cTime/1000;//时间差，单位：秒
        Long mTime = sTime/60;
        Long hTime = mTime/60;
        Long dTime = hTime/24;
        if(dTime != null){
            return Integer.parseInt(dTime.toString());
        }
        return null;
    }

    /**
     * 毫秒换算时间差
     * @param mss
     * @return
     */
    public static String formatDuring(long mss) {
        long days = mss / (1000 * 60 * 60 * 24);
        long hours = (mss % (1000 * 60 * 60 * 24)) / (1000 * 60 * 60);
        long minutes = (mss % (1000 * 60 * 60)) / (1000 * 60);
        long seconds = (mss % (1000 * 60)) / 1000;
        StringBuffer sb = new StringBuffer();
        if(days > 0){
            sb.append(days + "天");
        }
        if(hours > 0){
            sb.append(hours + "小时");
        }
        if(minutes > 0){
            sb.append(minutes + "分钟");
        }
       if(seconds > 0) {
           sb.append(minutes + "秒");
       }
       return sb.toString();
    }

    /**
     * 秒换算时间差
     * @param mss
     * @return
     */
    public static String formatHour(long mss) {
        long days = mss / (60 * 60 * 24);
        long hours = (mss % (60 * 60 * 24)) / (60 * 60);
        long minute = (mss % (60 * 60 )) / 60;
        long seconds =  mss % 60;
        StringBuffer sb = new StringBuffer();
        if(days > 0){
            sb.append(days + "天");
        }
        if(hours > 0){
            sb.append(hours + "小时");
        }
        if(minute > 0){
            sb.append(minute + "分钟");
        }
//        if(seconds > 0){
//            sb.append(seconds + "秒");
//        }
        return sb.toString();
    }

    /**
     * 秒换算小时
     * @param mss
     * @return
     */
    public static long getHour(long mss) {
        long hours = (mss % (60 * 60 * 24)) / (60 * 60);
        return hours;
    }
    
    /**
     * 获取两个日期之间的所有日期
     */
    public static List<String> getStrDate(Date start, Date end, String formatStr,int field){
        List<String> list = new ArrayList<String>(); //保存日期集合
        Date date = start;
		Calendar cd = Calendar.getInstance();//用Calendar 进行日期比较判断
		while (date.getTime() <= end.getTime()) {
		    list.add(dateToString(date, formatStr));
		    cd.setTime(date);
		    cd.add(field, 1);//增加一天 放入集合
		    date = cd.getTime();
		}
        return list;
    }
    
    /**
     * 获取两个日期之间的所有日期
     * @throws ParseException
     */
    public static List<String> getStrDate(String start, String end, String formatStr,int field){
        Date startDate = stringToDate(start, formatStr);
        Date endDate = stringToDate(end, formatStr);
        return getStrDate(startDate,endDate,formatStr,field);
    }

    /**
     * 平均时长
     * @param count    天数
     * @param time     总时长
     * @return
     */
    public static StringBuffer averageTime(int count,Long time) {
        //故障平均解决时长
        if (count > 0) {
            long l = time / count;
            time = l;
        }
        long day = time / (24 * 3600);
        long hour = time % (24 * 3600) / 3600;
        StringBuffer stringBuffer = new StringBuffer();
        if (day > 0) {
            stringBuffer.append(day).append("天");
        }
        if (hour > 0) {
            stringBuffer.append(hour).append("小时");
        }
        return stringBuffer;

    }

    /**
     * 获取当前时间前一天
      * @return
     */
    public static String preNday(int dayNumber){
        SimpleDateFormat format = new SimpleDateFormat(DATE_PATTERN_DAY);
        Calendar c = Calendar.getInstance();
        //过去N天
        c.setTime(new Date());
        c.add(Calendar.DATE, - dayNumber);
        Date d = c.getTime();
        String day = format.format(d);
        return day;
    }

    /**
     * 获取当前时间前N月
     * @return
     */
    public static String preNmonth(int monthNumber){
        SimpleDateFormat format = new SimpleDateFormat(DATE_PATTERN_DAY);
        Calendar c = Calendar.getInstance();
        //过去N月
        c.setTime(new Date());
        c.add(Calendar.MONTH, - monthNumber);
        Date m = c.getTime();
        String mon = format.format(m);
        return mon;
    }

    /**
     * 获取当前时间前N年
     * @return
     */
    public static String preNyear(int yearNumber){
        SimpleDateFormat format = new SimpleDateFormat(DATE_PATTERN_DAY);
        Calendar c = Calendar.getInstance();
        //过去N年
        c.setTime(new Date());
        c.add(Calendar.YEAR, - yearNumber);
        Date y = c.getTime();
        String year = format.format(y);
        return year;
    }

    /**
     * 19. 获取指定日期的开始时间 即：00:00:00
     *
     * @param date
     * @return
     */
    public static Date getBeginTimeOfDay(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar = getBeginTimeOfDay(calendar);
        return calendar.getTime();
    }

    /**
     * 20. 获取指定日期的开始时间 即：00:00:00
     *
     * @param calendar
     * @return
     */
    public static Calendar getBeginTimeOfDay(Calendar calendar) {
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        return calendar;
    }

    /**
     * 21. 获取指定日期的结束时间  即：23:59:59
     *
     * @param date
     * @return
     */
    public static Date getEndTimeOfDay(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar = getEndTimeOfDay(calendar);
        return calendar.getTime();
    }

    /**
     * 22. 获取指定日期的结束时间  即：23:59:59
     *
     * @param calendar
     * @return
     */
    public static Calendar getEndTimeOfDay(Calendar calendar) {
        calendar.set(Calendar.HOUR_OF_DAY, 23);
        calendar.set(Calendar.MINUTE, 59);
        calendar.set(Calendar.SECOND, 59);
        calendar.set(Calendar.MILLISECOND, 999);
        return calendar;
    }

    /**
     * 23. 获取当天开始时间
     *
     * @return
     */
    public static Date getBeginTimeOfToday() {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.HOUR_OF_DAY, 0);//0点
        cal.set(Calendar.MINUTE, 0);//0分
        cal.set(Calendar.SECOND, 0);//0秒
        cal.set(Calendar.MILLISECOND, 0);//0毫秒
        return cal.getTime();
    }


    /**
     * 24. 获取当天结束时间
     *
     * @return
     */
    public static Date getEndTimeOfToday() {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.HOUR_OF_DAY, 23);//23点
        cal.set(Calendar.MINUTE, 59);//59分
        cal.set(Calendar.SECOND, 59);//59秒
        return cal.getTime();
    }

    /**
     * 29. 获取本周的开始时间
     *
     * @return
     */
    public static Date getBeginDayOfWeek() {
        Date date = new Date();
        if (date == null) {
            return null;
        }
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
        if (dayOfWeek == 1) {
            dayOfWeek += 7;
        }
        cal.add(Calendar.DATE, 2 - dayOfWeek);
        return getBeginTimeOfDay(cal.getTime());
    }


    /**
     * 30. 获取本周的结束时间
     *
     * @return
     */
    public static Date getEndDayOfWeek() {
        Calendar cal = Calendar.getInstance();
        cal.setTime(getBeginDayOfWeek());
        cal.add(Calendar.DAY_OF_WEEK, 6);
        Date weekEndSta = cal.getTime();
        return getEndTimeOfDay(weekEndSta);
    }

    /**
     * 判断指定时间是否在[startTime, endTime]区间，注意时间格式要一致
     *
     * @param nowTime 当前时间
     * @param startTime 开始时间
     * @param endTime 结束时间
     * @return
     * @author jqlin
     */
    public static boolean isEffectiveDate(Date nowTime, Date startTime, Date endTime) {
        if (nowTime.getTime() == startTime.getTime()
                || nowTime.getTime() == endTime.getTime()) {
            return true;
        }
        Calendar date = Calendar.getInstance();
        date.setTime(nowTime);
        Calendar begin = Calendar.getInstance();
        begin.setTime(startTime);
        Calendar end = Calendar.getInstance();
        end.setTime(endTime);
        return date.after(begin) && date.before(end);
    }

    /**
     * 获取两个日期之间的所有日期
     * @throws ParseException
     */
    public static List<String> getStrDate(String start, String end, String formatStr,String outDataFormat,int field){
        Date startDate = stringToDate(start, formatStr);
        Date endDate = stringToDate(end, formatStr);
        long startTime = startDate.getTime();
        long endTime = endDate.getTime();
        if(startTime > endTime){
            endDate = getDateAfter(endDate,Calendar.DAY_OF_WEEK, 1);
        }
        return getStrDate(startDate,endDate,outDataFormat,field);
    }


    private static String getDateStr(String dateStr,String hmStr){
        StringBuffer sb = new StringBuffer(dateStr);
        return sb.append(" ").append(hmStr).toString();
    }

    /**
     * 获取时间值当月天数
     * @param date
     * @return
     */
    public static int getDaysOfMonth(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
    }

    /**
     * 获取时间值当月天数
     * @param date
     * @return
     */
    public static int getDaysOfMonth(String date){
        Date dateM = stringToDate(date, DATE_PATTERN_MONTH);
        return getDaysOfMonth(dateM);
    }


    /**
     * 获取指定日期月第一天的00:00:00
     * @param date
     * @return
     */
    public static Date  getfirstDaysOfMonth(Date date){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMinimum(Calendar.DAY_OF_MONTH));
        String s = dateToString(calendar.getTime(), DATE_PATTERN_DAY + DAY_FIRST_TIME);
        Date date1 = stringToDate(s, DATE_PATTERN_DEFAULT);
        return date1;
    }

    /**
     * 获取指定日期月最后一天的23:59:59
     * @param date
     * @return
     */
    public static Date getlastDaysOfMonth(Date date){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
        String s = dateToString(calendar.getTime(), DATE_PATTERN_DAY + DAY_LAST_TIME);
        Date date1 = stringToDate(s, DATE_PATTERN_DEFAULT);
        return date1;
    }

    /**
     * 某一个月第一天和最后一天
     * @param date
     * @return -1 指定时间的上个月  0 指定时间的月份  1下个月
     */
    public static Map<String, String> getFirstdayAndLastdayOfMonth(Date date,int month) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.MONTH, month);
        Date theDate = calendar.getTime();

        GregorianCalendar gcLast = (GregorianCalendar) Calendar.getInstance();
        gcLast.setTime(theDate);
        gcLast.set(Calendar.DAY_OF_MONTH, 1);
        String firstDay = getDateString(gcLast.getTime());

        calendar.add(Calendar.MONTH, 1);    //加一个月
        calendar.set(Calendar.DATE, 1);        //设置为该月第一天
        calendar.add(Calendar.DATE, -1);    //再减一天即为上个月最后一天
        String lastDay = getDateString(calendar.getTime());
        Map<String, String> map = new HashMap<String, String>();
        map.put("first", firstDay);
        map.put("last", lastDay);
        return map;
    }

    /**
     * 某一个月第一天和最后一天
     * @param date
     * @return -1 指定时间的上个月  0 指定时间的月份  1下个月
     */
    public static Map<String, String> getFirstdayAndLastdayOfMonth(String date,int month) {
        Date monthDate = stringToDate(date, DATE_PATTERN_MONTH);
        return getFirstdayAndLastdayOfMonth(monthDate,month);
    }

    /**
     * 获取指定月份的所有日期
     * @param date
     * @param month -1 指定时间的上个月  0 指定时间的月份  1下个月
     * @return
     */
    public static List<String> getStrDate(String date,int month){
        Map<String, String> firstdayAndLastdayOfMonth = getFirstdayAndLastdayOfMonth(date, month);
        if(null == firstdayAndLastdayOfMonth){
            return null;
        }
       return getStrDate(firstdayAndLastdayOfMonth.get("first"),firstdayAndLastdayOfMonth.get("last"),DATE_PATTERN_DAY,Calendar.DATE);
    }





    public static void main(String[] args) throws Exception{

        List<String> strDate = getStrDate("2020-04-01 20:00", 0);
        System.out.println(strDate.size());
    }
}
