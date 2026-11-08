package operator;

import java.util.Scanner;

public class OperatorDemo4 {
    public static void main(String[] args) {
        /*
            定义一个变量表示人的体温，对体温进行判断是否大于等于38度，如果是则打印语音警告
         */
        // 定义变量
        Scanner sc = new Scanner(System.in);
        System.out.println("当前温度：");
        double bodyTemperature = sc.nextDouble();
        // 进行判断
        if(bodyTemperature >= 38) {
            System.out.println("语音警告，温度超过38度");
        }else{
            System.out.print("体温正常");
        }
    }
}
