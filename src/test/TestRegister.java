package test;

import service.UserService;
import java.util.Scanner;

public class TestRegister {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("请输入用户名：");
        String username = sc.next();

        System.out.print("请输入密码：");
        String password = sc.next();

        System.out.print("请输入昵称：");
        String nickname = sc.next();

        // 顾客直接找业务员，不再直接指挥仓库管理员
        UserService userService = new UserService();
        userService.register(username, password, nickname);
    }
}