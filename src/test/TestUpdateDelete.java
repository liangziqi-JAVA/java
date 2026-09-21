package test;

import dao.UserDao;

public class TestUpdateDelete {
    public static void main(String[] args) throws Exception{
        UserDao userDao = new UserDao();
        userDao.updateNickname("wangwu","王五五");
        userDao.deleteUser("lisi");
    }
}
