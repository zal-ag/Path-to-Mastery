package literal;

import java.util.Scanner;

public class LiteralDemo1 {
    public static void main(String[] args) {
        // 初始化 Scanner
        Scanner sc = new Scanner(System.in);
        // 接收键盘录入的整数
        int num1 = sc.nextInt();
        System.out.println(num1);
        // 接收键盘录入的浮点数
        double num2 = sc.nextDouble();
        System.out.println(num2);
        // 接收键盘录入的字符串
        String str = sc.next();
        System.out.println(str);
    }
}
