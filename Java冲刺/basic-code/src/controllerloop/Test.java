package controllerloop;

import java.sql.SQLOutput;
import java.util.Random;
import java.util.Scanner;

public class Test {
    static void main() {
        Random r = new Random();
        int targetNumber = r.nextInt(1,101);
        System.out.printf("幸运数字：%d%n",targetNumber);

        Scanner sc = new Scanner(System.in);

        int guessNumber = 0;
        int max = 100;
        int min = 1;
        int count = 0;
        do{
            System.out.println("请输入你猜测的数字：");
            guessNumber = sc.nextInt();
            if(guessNumber>max||guessNumber<min){
                System.out.printf("超出范围请重新输入！%n");
                continue;
            }
            count++;
            if(guessNumber>targetNumber){
                max = guessNumber;
                System.out.printf("猜大了，请在%d-%d范围内重新试试吧！%n",min,max);
            }else if(guessNumber<targetNumber){
                min = guessNumber;
                System.out.printf("猜小了，请在%d-%d范围内重新试试吧！%n",min,max);
            }
        }while(guessNumber!=targetNumber);
        System.out.printf("用了%d次猜对了!%n",count);
        switch(count){
            case 1:
                System.out.println("运！");
                break;
            case 2,3,4,5:
                System.out.println("菜！");
                break;
            case 6,7,8,9,10:
                System.out.println("本质菜！");
                break;
            default:
                System.out.println("卡了！");
                break;

        }


    }
}
