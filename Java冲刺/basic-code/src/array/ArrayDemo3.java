package array;

import java.util.Scanner;

public class ArrayDemo3 {
    static void main() {
        int[] arr = new int [5];
        Scanner sc = new Scanner(System.in);
        for(int i = 0;i < arr.length;i++){
            int number = sc.nextInt();
            arr[i] = number;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }

    }
}
