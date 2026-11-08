package loopwhile;

public class WhileDemo2 {
    static void main() {
        double money = 100000;
        double target = money*2;
        double rate = 0.017;
        int year = 0;
        while(money<target) {
            money = money+money*rate;
            year += 1;
        }
        System.out.println(year);
    }
}
