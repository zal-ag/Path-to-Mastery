package controllerloop;

public class ContinueDemo2 {
    static void main() {
        /*
            逢7过
         */
        for (int i = 1; i <= 100; i++) {
            if(i % 10 == 7|| i / 10 == 7|| i % 7 == 0){
                continue;
            }
            System.out.println(i);
        }
    }
}
