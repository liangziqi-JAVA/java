package test;

import model.User;

public class TestUser {
    public static void main(String[] args){
        User u1 = new User(1,"张三");
        u1.setId(2);
        u1.setName("李四");
        System.out.println("编号："+u1.getId()+",姓名："+ u1.getName());
    }
}