package operator;

import java.util.Scanner;

public class OperatorDemo6 {
    static void main() {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入星期");
        int week = sc.nextInt();

        switch(week) {
            case 1:
                System.out.println("练肩");
                break;
            case 2:
                System.out.println("练背");
                break;
            case 3:
                System.out.println("练胸");
                break;
            case 4:
                System.out.println("有氧");
                break;
            case 5:
                System.out.println("游泳");
                break;
            case 6:
                System.out.println("爬山");
                break;
            case 7:
                System.out.println("吃饭");
                break;
            default:
                System.out.println("不存在");
                break;

        }
    }
}
