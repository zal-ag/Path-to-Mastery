package operator;

import java.util.Scanner;

public class OperatorDemo2 {
    public static void main(String[] args) {
        // 输入秒数
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入秒数seconds：");
        int seconds = sc.nextInt();
        // 小时
        int hour = seconds / 3600;
        // 分钟
        int minute = seconds % 3600 / 60;
        // 秒
        int second = seconds % 10;
        System.out.println(hour+" "+minute+" "+second);
        System.out.printf("%d %d %d",hour,minute,second);
    }
}
