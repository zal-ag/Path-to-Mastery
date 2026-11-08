package loopwhile;

import java.util.Scanner;

public class WhileDemo4 {
    static void main() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int sum = 0;
        if (n<0) n = -n;
        while(n!=0){
            sum += n % 10;
            n = n/10;
        }
        System.out.println(sum);
    }
}
