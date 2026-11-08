package literal;

import java.util.Scanner;

public class LiteralDemo2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("请输入第一个整数");
        int num1 = sc.nextInt();
        System.out.println(num1);

        System.out.println("请输入第二个整数");
        int num2 = sc.nextInt();
        System.out.println(num2);

        System.out.println("整数之和为");
        int result = num1 + num2;
        System.out.println(result);
    }
}
