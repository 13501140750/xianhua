/**
 * Copyright 2008-2014 OpenTide Inc. All Rights Reserved.
 * 
 * @ProjectName:  sim dao
 * @Package:      com.otc.sim.common
 * @FileName:     DateHelper.java
 * @Description:  
 * @CreateUser:   yang.liu
 * @CreateDate:   2014-4-12 下午9:31:22
 * @UpdateUser:   yang.liu
 * @UpdateDate:   2014-4-12 下午9:31:22
 * @UpdateRemark: 
 * 
 */
package com.jifenbao.common;

import java.io.UnsupportedEncodingException;
import java.text.DecimalFormat;
import java.text.FieldPosition;
import java.text.Format;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;



import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.otc.framework.common.Constants;
import com.otc.framework.utils.DateTimeUtil;

/**
 * @ClassName DateHelper
 * @Description TODO
 * 
 * @author yang.liu
 * @version 1.0
 * 
 */
public final class DateHelper {
    // 占位
    public static final FieldPosition HELPER_POSITION = new FieldPosition(0);
    // 数字格式化
    public final static NumberFormat  NUMBER_FORMATE  = new DecimalFormat(
                                                              "0000");
    
    private static final Log          LOG             = LogFactory
                                                              .getLog(DateHelper.class);
    
    private static final Format       DATA_FORMATE    = new SimpleDateFormat(
                                                              "yyyyMMdd");
    private static int                seq             = 1;
    private static final int          MAX             = 9999;
    
    private static String DATE_FORMAT ="";
    
    /**
     * 判断是否为周末
     * 
     * @param date
     *            日期
     * @return 是未false 否为true
     */
    public static boolean isWeekend(Date date) {
        Calendar cal = new GregorianCalendar();
        cal.setTime(date);
        /*
         * Sunday Day of Week 1 Monday Day of Week 2 Tuesday Day of Week 3
         * Wednesday Day of Week 4 Thrusday Day of Week 5 Friday Day of Week 6
         * Saturday Day of Week 7
         */
        
        int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
        return dayOfWeek == Calendar.SUNDAY || dayOfWeek == Calendar.SATURDAY;
    }
    
    /**
     * 判断是否为周六
     * 
     * @param date
     *            日期
     * @return 是未false 否为true
     */
    public static boolean isSaturday(Date date) {
        Calendar cal = new GregorianCalendar();
        cal.setTime(date);
        
        int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
        return dayOfWeek == Calendar.SATURDAY;
    }
    
    /**
     * 判断是否为周日
     * 
     * @param date
     *            日期
     * @return 是未false 否为true
     */
    public static boolean isSunday(Date date) {
        Calendar cal = new GregorianCalendar();
        cal.setTime(date);
        
        int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
        return dayOfWeek == Calendar.SUNDAY;
    }
    
    /**
     * 格式化日期 2014年 5月 1日 am 11:00
     * 
     * @param date
     * @return
     */
    public static String formatDate(Date date, String yearString,
            String monthString, String dayString) {
        String s = DateTimeUtil.format(date, DateHelper.DATE_FORMAT);
        String[] fs = s.split("-");
        StringBuffer dateString = new StringBuffer("");
        if (StringUtils.isNotEmpty(yearString)) {
            String year = fs[0] + yearString;
            dateString.append(year).append(" ");
        }
        String month = fs[1] + monthString;
        dateString.append(month).append(" ");
        String day = fs[2] + dayString;
        dateString.append(day).append(" ");
        
        Calendar cal = new GregorianCalendar();
        cal.setTime(date);
        int hours = cal.get(Calendar.HOUR_OF_DAY);
        if (hours >= 12) {
            dateString.append("pm").append(" ");
        }
        else {
            dateString.append("am").append(" ");
        }
        String time = DateTimeUtil.format(date, "HH:mm");
        dateString.append(time);
        return dateString.toString();
    }
    
    /**
     * 格式化日期 2014年 5月 1日 am 11:00~12:00
     * 
     * @param date
     * @return
     */
    public static String formatDate(Date date, String timeCd,
            String yearString, String monthString, String dayString) {
        String s = DateTimeUtil.format(date, DateHelper.DATE_FORMAT);
        String[] fs = s.split("-");
        StringBuffer dateString = new StringBuffer("");
        String year = fs[0] + yearString;
        dateString.append(year).append(" ");
        String month = fs[1] + monthString;
        dateString.append(month).append(" ");
        String day = fs[2] + dayString;
        dateString.append(day).append(" ");
        
        Calendar cal = new GregorianCalendar();
        cal.setTime(date);
        int hours = cal.get(Calendar.HOUR_OF_DAY);
        if (hours >= 12) {
            dateString.append("pm").append(" ");
        }
        else {
            dateString.append("am").append(" ");
        }
        dateString.append(timeCd);
        return dateString.toString();
    }
    
    /**
     * 
     * @param date
     */
    public static String formatDate(Date date) {
        return DateTimeUtil.format(date, "yyyy년MM월dd일 KK:mm:ss a,zzzz");
    }
    
   
    
    /**
     * 时间格式生成序列
     * 
     * @return String
     */
    public static synchronized String generateSequenceNo() {
        
        Calendar rightNow = Calendar.getInstance();
        
        StringBuffer sb = new StringBuffer();
        
        DATA_FORMATE.format(rightNow.getTime(), sb, HELPER_POSITION);
        
        NUMBER_FORMATE.format(seq, sb, HELPER_POSITION);
        
        if (seq == MAX) {
            // 到达最大值后 重新开始
            seq = 1;
        }
        else {
            seq++;
        }
        
        LOG.info("THE SQUENCE IS :" + sb.toString());
        
        return sb.toString();
    }
    
    public static String getCurDateString() {
        return DateTimeUtil.format(DateTimeUtil.now(), "yyyyMMdd");
    }
    
    /**
     * 返回给定日期所在的年的日期。
     * 
     * @param date
     * @return
     */
    public static Date getSameDateOfYear(Date date, int year) {
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(date);
        
        calendar.set(Calendar.YEAR, year);
        return calendar.getTime();
    }
    
    public static List<String> getBetweenWeek(String startDate, String endDate) {
        List<String> list = new ArrayList<String>();
        Date strStartDate = null;
        Date strEndDate = null;
        strStartDate = DateTimeUtil.parseDate(startDate);
		strEndDate = DateTimeUtil.parseDate(endDate);
        
        Date startSunday = DateTimeUtil.getFirstDateOfWeek(strStartDate);
        Date startSaturday = DateTimeUtil.getLastDateOfWeek(strStartDate);
        
        // Date endSunday = DateTimeUtil.getFirstDateOfWeek(strEndDate);
        Date endSaturday = DateTimeUtil.getLastDateOfWeek(strEndDate);
        
        Calendar startCalendar = new GregorianCalendar();
        startCalendar.setTime(startSunday);
        
        Calendar saturdayCalendar = new GregorianCalendar();
        saturdayCalendar.setTime(startSaturday);
        
        Calendar endCalendar = new GregorianCalendar();
        endCalendar.setTime(endSaturday);
        
        long start = startCalendar.getTimeInMillis();
        long end = endCalendar.getTimeInMillis();
        
        do {
            GregorianCalendar gc1 = (GregorianCalendar) startCalendar.clone();
            GregorianCalendar gc2 = (GregorianCalendar) saturdayCalendar
                    .clone();
            gc1.setFirstDayOfWeek(GregorianCalendar.SUNDAY);// 每周以周日开始
            gc2.setFirstDayOfWeek(GregorianCalendar.SUNDAY);// 每周以周日开始
            
            if (gc1.get(Calendar.YEAR) != gc2.get(Calendar.YEAR)) {
                // list.add(DateTimeUtil.format(gc1.getTime(), "yyyy-ww"));
                // 与数据库同步
                list.add(gc1.get(Calendar.YEAR) + "-53");
                list.add(DateTimeUtil.format(gc2.getTime(), "yyyy-ww"));
                
            }
            else {
                list.add(DateTimeUtil.format(gc1.getTime(), "yyyy-ww"));
            }
            
            startCalendar.add(Calendar.DAY_OF_MONTH, 7);
            saturdayCalendar.add(Calendar.DAY_OF_MONTH, 7);
            
            start = startCalendar.get(Calendar.YEAR) * 100
                    + startCalendar.get(Calendar.WEEK_OF_YEAR);
            
            end = endCalendar.get(Calendar.YEAR) * 100
                    + endCalendar.get(Calendar.WEEK_OF_YEAR);
            
            System.out.println("start==" + start);
            System.out.println("end==" + end);
            
        } while (start <= end);
        
        return list;
    }
    
}
