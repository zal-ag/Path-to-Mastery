package com.Silas.exception.logging;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {
    private static final Logger logger =
            Logger.getLogger(Main.class.getName());
    public static void main(String[] args){
        logger.info("程序启动");
        int age = -5;
        if(age < 0){
            logger.warning("年龄不合法"+age);
        }
        logger.info("程序结束");

        logger.fine("当前环境变量 i = 3"); // 默认不显示

        String input = "abc";
        try{
            int num = Integer.parseInt(input);
            logger.info("转换成功");
        }catch(NumberFormatException e){
            logger.log(Level.SEVERE,"数字转换失败，因为用户输入"+input,e);
        }
    }
}
