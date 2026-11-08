package operator;

import java.util.Scanner;

public class OperatorDemo5 {
    public static void main() {

        Scanner sc = new Scanner(System.in);
        System.out.println("你要买多少钱的烧烤");
        double money = sc.nextDouble();

        // 闪购 全场9折
        double price1 = money * 0.9;
        System.out.printf("闪购要%f元%n",price1);

        // 美团 满30立减10
        double price2 = money;
        if (money>=30) {
            price2 = price2 - 10;
        }
        System.out.printf("美团要%f元%n",price2);

        // 比价
        if (price1<=price2) {
            System.out.println("闪购更划算");
        }else{
            System.out.println("美团更划算");
        }
    }
}
