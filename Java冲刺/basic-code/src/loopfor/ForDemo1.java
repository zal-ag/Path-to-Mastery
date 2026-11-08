package loopfor;

import java.util.Scanner;

public class ForDemo1 {
    static void main() {
        /*
            返回一个区间范围内既能被3整除，又能被5整除的数
         */
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入第一个数字：");
        int num1 = sc.nextInt();
        System.out.println("请输入第二个数字：");
        int num2 = sc.nextInt();

        int max = num1 > num2 ? num1 : num2;
        int min = num1 < num2 ? num1 : num2;

        int count = 0;
        for(int i =min;i<=max;i++){
            if(i%3==0 && i%5==0){
                count++;
            }
        }
        System.out.println(count);
    }
}
