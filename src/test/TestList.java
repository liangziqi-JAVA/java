package test;

import model.User;

import java.util.ArrayList;
public class TestList {
    public static void main(String[] args){
        ArrayList<User> userList =new ArrayList<>();
        User u1 = new User(1, "张三");
        User u2 = new User(2, "李四");
        userList.add(u1);
        userList.add(u2);
        User u3 = new User(3,"王五");
        userList.add(u3);
        System.out.println("现在袋子里有："+ userList.size() + "个人");
        System.out.println("袋子里一共有：" + userList.size() + "个用户");
        User firstUser = userList.get(0);
        System.out.println("第一个用户的名字是：" + firstUser.getName());
        userList.remove(0);
        System.out.println("踢掉一个人后，带子里还有" + userList.size() + "个人");
        System.out.println("现在拍第一个的人是：" + userList.get(0).getName());
        User secondUser = userList.get(1);
        System.out.println("第二个用户的名字是："+ secondUser.getName());
    }
}
