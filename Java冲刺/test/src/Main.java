public class Main {
    public static void main(String[] args){
        int studyMinutes = 60;
        System.out.println(studyMinutes);
        studyMinutes -= 15;
        System.out.println(studyMinutes);
        studyMinutes -= 10;
        System.out.println(studyMinutes);

        int plannedMinutes = 60;
        int remainingMinutes = plannedMinutes;
        remainingMinutes -= 20;
        remainingMinutes -= 10;
        remainingMinutes -= 5;
        int studiedMinutes = plannedMinutes - remainingMinutes;
        System.out.println("计划时间：" + plannedMinutes + "分钟");
        System.out.println("剩余时间：" + remainingMinutes + "分钟");
        System.out.println("已学时间：" + studiedMinutes + "分钟");
        System.out.println("平均每次：" + studiedMinutes/3 + "分钟");
        double average = studiedMinutes/3.0;
        System.out.println("平均每次：" + average + "分钟");

        int[] minutes = {10,25,15,30,20};
        int sum = 0;
        for (int i=0;i<minutes.length;i++) {
            System.out.println("第"+(i+1)+"天："+minutes[i]+"分钟");
            sum += minutes[i];
        }
        System.out.println("总时长："+sum+"分钟");

    }
}
