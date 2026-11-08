package operator;

import java.util.Scanner;

public class OperatorDemo1 {
    public static void main(String[] args) {
        /*
            需求：键盘录入一个三位数，将其拆分为个位、十位、百位，并打印在控制台上
        */
        // 键盘录入三位数
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入一个三位数");
        int number = sc.nextInt();

        // 个位数
        int ge = number % 10;
        System.out.printf("个位数：%d%n",ge);

        // 十位数
        int shi = number / 10 % 10;
        System.out.printf("十位数：%d%n",shi);

        // 百位数
        int bai = number / 100;
        System.out.printf("百位数：%d%n",bai);

    }

}
