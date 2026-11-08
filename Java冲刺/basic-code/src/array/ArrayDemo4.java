package array;

import java.util.Random;

public class ArrayDemo4 {
    static void main() {
        int[] arr = {1,2,3,4,5,6,7,8,9,10};
        Random r = new Random();
        for (int i = 0; i < arr.length; i++) {
            int randomIndex = r.nextInt(arr.length);
            int temp = arr[randomIndex];
            arr[randomIndex] = arr[i];
            arr[i] = arr[randomIndex];
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
}
