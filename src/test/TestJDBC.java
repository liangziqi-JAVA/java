package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
public class TestJDBC {
    public static void main(String[] args) throws Exception {
        // 1. 拨号连接（注意：123456 要换成你自己的 MySQL 密码）
        Connection conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/campus_trade?useSSL=false&serverTimezone=UTC",
                "root",
                "lzq1314521"
        );

        // 2. 下达指令（写一句SQL）
        String sql = "SELECT nickname FROM t_user WHERE id = 1";
        Statement stmt = conn.createStatement();

        // 3. 接收结果（ResultSet 就像一个小袋子）
        ResultSet rs = stmt.executeQuery(sql);

        // 4. 看看袋子里有没有东西
        while (rs.next()) {
            String name = rs.getString("nickname");
            System.out.println("从数据库查出来的用户名字是：" + name);
        }

        // 5. 挂断电话
        rs.close();
        stmt.close();
        conn.close();
    }
}