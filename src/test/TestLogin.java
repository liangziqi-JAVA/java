package test;

import service.UserService;
import java.util.Scanner;

public class TestLogin {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("请输入用户名：");
        String username = sc.next();
        System.out.print("请输入密码：");
        String password = sc.next();

        // 直接找业务员
        UserService userService = new UserService();
        boolean success = userService.login(username, password);

        if (success) {
            System.out.println("登录成功！");
        } else {
            System.out.println("登录失败，用户名或密码错误！");
        }
    }
}