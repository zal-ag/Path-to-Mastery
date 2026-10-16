package com.Silas.API.String;

import java.util.Scanner;

// 将数字转换为汉字
public class AmountConverter {
    public static String convert(int num){
        String[] arr = {"零","壹","贰","叁","肆","伍","陆","柒","捌","玖"};
        return arr[num];
    }

    static void main() {

        Scanner sc = new Scanner(System.in);
        // 数字金钱额
        int money;
        // 存储汉字金钱额
        String result = "";
        // 金钱最大位数
        int MAXSIZE = 8;
        // 金钱额度汉字单位
        String[] amountUnit = {"仟","佰","什","万","仟","佰","什","元"};
        // 存储最后的结果
        String CNY = "";

        // 对输入金额进行检验
        while(true){
            money = sc.nextInt();
            if(money>=0 && money <= 99999999) {
                break;
            }else{
                System.out.println("金额无效！");
            }
        }

        // 将金钱额转换为汉字版
        while(money!=0){
            int num = money % 10;
            result = convert(num) + result;
            money /= 10;
        }

        // 对汉字版额度进行位数补齐
        for(int i = 0; i < MAXSIZE - result.length(); i++){
            result = "零" + result;
        }
        // 测试：System.out.println(result);

        // 为汉字各金额添加单位
        for(int i = 0; i < MAXSIZE; i++){
            CNY += result.charAt(i)+amountUnit[i];
        }

        // 打印结果
        System.out.println(CNY);
    }
}
