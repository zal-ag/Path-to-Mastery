package com.Silas.StudentManagementSystem;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;


public class Main {

    static Scanner sc =new Scanner(System.in);
    static ArrayList<User> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        while(true){
            System.out.println("----------欢迎进入学生管理系统----------");
            System.out.println("请选择操作：【1】登录 【2】注册 【3】忘记密码 【4】退出");

            String choose = sc.next();
            switch(choose){
                case "1" -> login();
                case "2" -> register();
                case "3" -> forgetPassword();
                case "4" -> {
                    System.out.println("退出");
                    System.exit(0);
                }
                default -> System.out.println("输入无效");
            }
        }

    }

    public static void login() throws IOException {
        System.out.println("请输入用户名：");
        String username = sc.next();
        User user = findUser(username);
        if(user == null) {
            System.out.println("用户名不存在，请检查输入是否正确或者该用户名是否注册");
            return;
        }
        while(true){
            String target = getCode();
            System.out.println("验证码:"+target);
            System.out.println("请输入验证码");
            String code = sc.next();
            if(code.equals(target)){
                System.out.println("验证通过");
                break;
            }else{
                System.out.println("验证失败，请重试");
            }
        }
        int count = 3;
        do{
            System.out.println("请输入密码：");
            String password = sc.next();
            if(user.getPassword().equals(password)) {
                System.out.println("身份验证通过");
                Menu.studentInfo();
                break;
            }else{
                count--;
                System.out.printf("用户名和密码不一致，请重新输入,你还有%d次机会%n",count);
            }

        }while(count>0);
        if(count == 0) System.out.println("错误次数过多，请稍后再试");
    }

    public static void register(){

        // 新用户开始注册
        User user = new User();

        // 设置用户名并校验
        usernameCheck(user);

        // 设置密码并校验
        passwordCheck(user);

        // 绑定身份证号码并校验
        personIDCheck(user);

        // 绑定手机号码并校验
        phoneNumberCheck(user);

        // 将注册号的新用户信息添加到集合里
        list.add(user);
        System.out.println("用户注册成功！");
        // 打印所有的用户信息
        printList();
    }

    public static void forgetPassword(){
        System.out.println("请输入用户名：");
        String username = sc.next();
        User user = findUser(username);
        if(user == null) {
            System.out.println("用户名不存在，请检查输入是否正确或者该用户名是否注册");
            return;
        }
        System.out.println("请输入身份证号码：");
        String personID = sc.next();
        System.out.println("请输入手机号码：");
        String phoneNumber = sc.next();

        if(personID.equals(user.getPersonID()) && phoneNumber.equals(user.getPhoneNumber())){
            System.out.println("身份验证通过");
            user.setPassword(inputConfirmedPassword("请输入新密码"));
            System.out.println("密码修改成功");
            System.out.println("用户信息已更新");
            printList();
        }else{
            System.out.println("身份信息不一致");
        }

    }

    public static User findUser(String username){
        for(User u: list){
            if(username.equals(u.getUsername())) return u;
        }
        return null;
    }

    public static void usernameCheck(User user){
        loop1:while(true){
            System.out.println("请输入设置用户名：");
            String username = sc.next();
            User u = findUser(username);
            if(u != null) {
                System.out.println("该用户名已存在，请重新输入");
                continue loop1;
            }
            int length = username.length();
            if(length < 3 || length > 15) {
                System.out.println("用户名长度必须在3-15之间，请重新输入");
                continue;
            }
            int count = 0;
            for(int i = 0; i < username.length(); i++){
                char c = username.charAt(i);
                boolean isLetter = (c>='a' && c<='z') || (c>='A' && c<='Z');
                boolean isNumber = (c>='0' && c<='9');
                if(!isLetter && !isNumber){
                    System.out.println("只能是数字加字母的组合,请重新输入");
                    continue loop1;
                }
                if(isLetter) count++;
            }
            if(count == 0){
                System.out.println("不能为纯数字，请重新输入");
                continue;
            }
            user.setUsername(username);
            System.out.println("用户名设置成功");
            break;
        }
    }

    public static void passwordCheck(User user){
        user.setPassword(inputConfirmedPassword("请设置密码："));
        System.out.println("密码设置成功");
    }

    public static String inputConfirmedPassword(String prompt){
        while(true){
            System.out.println(prompt);
            String password1 = sc.next();
            System.out.println("请再次输入密码：");
            String password2 = sc.next();
            if(password1.equals(password2)){
                return password1;
            }else{
                System.out.println("两次输入不一致，密码设置失败");
            }
        }
    }

    public static void personIDCheck(User user){
        loop2:while(true){
            System.out.println("请绑定身份证：");
            String personID = sc.next();
            int length = personID.length();
            if(length != 18){
                System.out.println("输入错误，请从重新输入（长度错误）");
                continue;
            }
            char c1 = personID.charAt(0);
            if(c1 == '0'){
                System.out.println("输入错误，请重新输入（首位不能为0）");
                continue;
            }
            for (int i = 0; i < length-1; i++) {
                char c2 = personID.charAt(i);
                if(c2 < '0' || c2 > '9'){
                    System.out.println("输入错误，请重新输入（前17在[0,9]范围内）");
                    continue loop2;
                }
            }
            char c3 = personID.charAt(17);
            boolean isDigit = (c3 >= '0' && c3 <='9');
            boolean isX = (c3 == 'x' || c3 == 'X');
            if(!isDigit && !isX){
                System.out.println("输入错误，请重新输入（最后一位在[0,9]范围内或者为x/X");
                continue;
            }
            user.setPersonID(personID);
            System.out.println("身份证认证成功");
            break;
        }
    }

    public static void phoneNumberCheck(User user){
        loop3:while(true) {
            System.out.println("请绑定手机号码：");
            String phoneNumber = sc.next();
            int length = phoneNumber.length();
            if (length != 11) {
                System.out.println("输入错误，请从重新输入（长度错误）");
                continue;
            }
            char c1 = phoneNumber.charAt(0);
            if(c1 == '0'){
                System.out.println("输入错误，请重新输入（首位不能为0）");
                continue;
            }
            for (int i = 0; i < length; i++) {
                char c2 = phoneNumber.charAt(i);
                if(c2 < '0' || c2 > '9'){
                    System.out.println("输入错误，请重新输入（手机号码每一位都要在[0,9]范围内）");
                    continue loop3;
                }
            }
            user.setPhoneNumber(phoneNumber);
            System.out.println("手机号码绑定成功");
            break;
        }
    }

    public static void printList(){
        for(User u:list){
            System.out.println(u.getUsername()+","+u.getPassword()+","+u.getPersonID()+","+u.getPhoneNumber());
        }
    }

    public static String getCode(){
        ArrayList<Character> list = new ArrayList<>();
        for(int i = 0; i < 26; i++){
            list.add((char)('a'+i));
            list.add((char)('A'+i));
        }
        Random r = new Random();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 4; i++) {
            int index = r.nextInt(list.size());
            char c = list.get(index);
            sb.append(c);
        }
        int index = r.nextInt(5);
        int num = r.nextInt(10);
        sb.insert(index,num);

        return sb.toString();
    }

}