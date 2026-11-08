package controllerloop;

import java.util.Scanner;

public class BreakDemo1 {
    static void main() {
        /*
            判断质数
         */
        Scanner sc = new Scanner(System.in);
        int number = 0;
        while(true){
            System.out.println("请输入一个大于等于2的正整数：");
            number = sc.nextInt();
            if (number>=2){
                break;
            }else{
                System.out.println("该数字不合规，请重新输入!");
            }
        }
        boolean condition = true;
        for(int i=2;i<=Math.sqrt(number);i++){
            if(number%i==0){
                condition = false;
                System.out.println("该数字不是质数");
                break;
            }
        }
        if(condition){
            System.out.println("该数字是质数");
        }
    }
}
