package loopwhile;

public class WhileDemo3 {
    static void main() {
        double paperDepth = 0.1;
        double mountain = 8848860;
        int count = 0;
        while(paperDepth<mountain) {
            paperDepth = paperDepth * 2;
            count += 1;
        }
        System.out.println(count);
    }
}
