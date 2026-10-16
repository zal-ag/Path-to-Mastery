package com.Silas.API.Regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CrawlText {
    static void main() {

        String str = "Java自从95年问世以来，经历了很多版本，目前企业中用的最多的是Java8和Java11，" +
                "因为这两个是长期支持版本，下一个长期支持版本是Java17，相信在未来不久Java17也会逐渐登上历史舞台";


        // 获取正则表达式的对象
        Pattern p = Pattern.compile("Java\\d{0,2}");
        // 获取文本读取器的对象（将文本与正则表达式匹配）
        Matcher m = p.matcher(str);

        // m.find() 按照正则表达式进行抓取，返回类型为boolean
        while(m.find()){
            // 返回抓取到的字符串
            String s = m.group();
            System.out.println(s);
        }
        /*
            m.find() 和 m.group() 都是一次性的，需要循环反复调用
         */
    }
}
