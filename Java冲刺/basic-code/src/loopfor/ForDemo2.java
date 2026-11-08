package loopfor;

import java.util.Scanner;

public class ForDemo2 {
    static void main() {
        int sum = 0;
        Scanner sc = new Scanner(System.in);
        int up = sc.nextInt();
        for(int i = 1;i <= up;i++) {
            if (i%2==0) {
                sum -= i;
            }else{
                sum += i;
            }
        }
        System.out.println(sum);
    }
}
