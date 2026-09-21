package service;

import dao.UserDao;
import model.User;

public class UserService {
    // 1. 业务员需要找仓库管理员拿货
    private UserDao userDao = new UserDao();

    // 2. 注册业务（包含逻辑：先查有没有这个人，没有才让注册）
    public boolean register(String username, String password, String nickname) {
        try {
            // 先去仓库查一下，有没有这个人
            User existUser = userDao.findByUsername(username);

            // 如果查到了，说明名字被占了
            if (existUser != null) {
                System.out.println("业务员提示：用户名 '" + username + "' 已存在，请换一个！");
                return false;
            }

            // 如果没查到，让仓库把数据存进去
            userDao.insertUser(username, password, nickname);
            System.out.println("业务员提示：注册流程完成！");
            return true;

        } catch (Exception e) {
            System.out.println("业务员系统异常：" + e.getMessage());
            return false;
        }
    }
    // 登录业务
    public boolean login(String username, String password) {
        try {
            // 让仓库管理员去查有没有这个账号密码
            return userDao.checkLogin(username, password);
        } catch (Exception e) {
            System.out.println("登录系统异常：" + e.getMessage());
            return false;
        }
    }
}