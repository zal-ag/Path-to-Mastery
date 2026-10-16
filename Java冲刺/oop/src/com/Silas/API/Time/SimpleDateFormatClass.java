package com.Silas.API.Time;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SimpleDateFormatClass {

    /*
        2000-11-11 -> 2000年11月11日
     */
    private static void convert() throws ParseException {
        String str1 = "2000-11-11";
        System.out.println(str1);

        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
        Date d1 = sdf1.parse(str1);
        System.out.println(d1);

        SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy年MM月dd日");
        String str2 = sdf2.format(d1);
        System.out.println(str2);
    }

    /*
        秒杀活动是否参与成功判断
     */
    private static void activity(String orderStr) throws ParseException {
        String startStr = "2026年10月12日 12:00:00";
        String endStr = "2026年10月12日 18:00:00";

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
        Date startDate = sdf.parse(startStr);
        Date endDate = sdf.parse(endStr);
        Date orderDate = sdf.parse(orderStr);

        Long startTime = startDate.getTime();
        Long endTime = endDate.getTime();
        Long orderTime = orderDate.getTime();

        if(orderTime >= startTime && orderTime <= endTime){
            System.out.println("恭喜你，买一送一");
        }else{
            System.out.println("活动已结束");
        }

    }
    static void main() throws ParseException {

        // 空参构造创建默认格式的对象
        SimpleDateFormat sdf1 = new SimpleDateFormat();
        Date d1 = new Date();
        String str1 = sdf1.format(d1); // 格式化 日期对象->字符串
        System.out.println(str1);

        // 有参构造创建指定格式的对象
        SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss E");
        Date d2 = new Date(0L);
        String str2 = sdf2.format(d2);
        System.out.println(str2);

        // 解析字符串 字符串->日期对象
        String str3 = "2011-11-11 11:11:11";
        SimpleDateFormat sdf3 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date d3 = sdf3.parse(str3);
        System.out.println(d3);
        System.out.println(d3.getTime());

        convert();

        activity("2026年10月12日 12:01:15");
        activity("2026年10月12日 18:01:15");
    }
}
