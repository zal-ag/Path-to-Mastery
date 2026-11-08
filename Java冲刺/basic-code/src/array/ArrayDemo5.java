package array;

import java.util.Random;

public class ArrayDemo5 {
    static void main() {
        Random r = new Random();
        int[] arr = new int [10];
        for (int i = 0; i < arr.length;) {
            int num = r.nextInt(1,101);
            boolean flag = false;
            for (int j = 0; j < arr.length; j++) {
                if(num == arr[j]){
                    flag = true;
                    break;
                }
            }
            if(!flag){
                arr[i] = num;
                i++;
            }
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+" ");
        }

    }
}
