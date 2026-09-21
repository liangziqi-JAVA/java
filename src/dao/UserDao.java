package dao;

import model.User;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserDao {

    // 1. 获取连接
    public Connection getConnection() throws Exception {
        return DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/campus_trade?useSSL=false&serverTimezone=UTC",
                "root",
                "lzq1314521"
        );
    }

    // 2. 查询用户（登录）
    public User findByUsername(String username) throws Exception {
        Connection conn = getConnection();
        String sql = "SELECT * FROM t_user WHERE username = ?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, username);
        ResultSet rs = ps.executeQuery();

        User user = null;
        if (rs.next()) {
            int id = rs.getInt("id");
            String nickname = rs.getString("nickname");
            user = new User(id, nickname);
        }

        rs.close();
        ps.close();
        conn.close();
        return user;
    }

    // 校验登录（查数据库里有没有匹配的用户名和密码）
    public boolean checkLogin(String username, String password) throws Exception {
        Connection conn = getConnection();
        // 把用户名和密码一起作为条件去查
        String sql = "SELECT * FROM t_user WHERE username = ? AND password = ?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, username);
        ps.setString(2, password);
        ResultSet rs = ps.executeQuery();

        // 如果查到了（rs.next()为true），说明账号密码正确
        boolean result = rs.next();

        rs.close();
        ps.close();
        conn.close();
        return result;
    }

    // 3. 注册用户（带防弹衣版）
    public void insertUser(String username, String password, String nickname) {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = getConnection();
            String sql = "INSERT INTO t_user(username, password, nickname) VALUES(?, ?, ?)";
            ps = conn.prepareStatement(sql);
            ps.setString(1, username);
            ps.setString(2, password);
            ps.setString(3, nickname);

            int rows = ps.executeUpdate();
            System.out.println("注册成功！数据库里新增了 " + rows + " 条记录。");

        } catch (Exception e) {
            System.out.println("注册失败！");
            if (e.getMessage().contains("Duplicate entry")) {
                System.out.println("用户名 '" + username + "' 已经被注册过了，请换一个吧！");
            } else {
                System.out.println("系统错误，请联系管理员。错误原因：" + e.getMessage());
            }
        } finally {
            try {
                if (ps != null) ps.close();
                if (conn != null) conn.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    // 4. 修改昵称
    public void updateNickname(String username, String newNickname) throws Exception {
        Connection conn = getConnection();
        String sql = "UPDATE t_user SET nickname = ? WHERE username = ?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, newNickname);
        ps.setString(2, username);
        int rows = ps.executeUpdate();
        System.out.println("修改成功！影响了 " + rows + " 行数据。");
        ps.close();
        conn.close();
    }

    // 5. 删除用户
    public void deleteUser(String username) throws Exception {
        Connection conn = getConnection();
        String sql = "DELETE FROM t_user WHERE username = ?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, username);
        int rows = ps.executeUpdate();
        System.out.println("删除成功！影响了 " + rows + " 行数据。");
        ps.close();
        conn.close();
    }
}