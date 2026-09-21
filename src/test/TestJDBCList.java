package test;

import model.User;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList; // 导入装东西的袋子

public class TestJDBCList {
    public static void main(String[] args) throws Exception {
        // 1. 拨号连接（密码换成你自己的）
        Connection conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/campus_trade?useSSL=false&serverTimezone=UTC",
                "root",
                "lzq1314521"
        );

        // 2. 下达指令：查询所有用户（注意我们把 id 也查出来）
        String sql = "SELECT id, nickname FROM t_user";
        Statement stmt = conn.createStatement();

        // 3. 接收结果（数据库扔过来的数据）
        ResultSet rs = stmt.executeQuery(sql);

        // 4. 准备一个我们自己的袋子，专门装 model.User
        ArrayList<User> userList = new ArrayList<>();

        // 5. 核心逻辑：只要数据库还有数据，就拿出来，做成 model.User，丢进袋子
        while (rs.next()) {
            int id = rs.getInt("id");                  // 拿 id
            String nickname = rs.getString("nickname"); // 拿昵称

            // 用刚刚拿到的数据，造一个 model.User 对象
            User u = new User(id, nickname);

            // 把这个 model.User 对象放进袋子
            userList.add(u);
        }

        // 6. 查完了，挂断电话
        rs.close();
        stmt.close();
        conn.close();

        // 7. 遍历袋子，打印结果
        System.out.println("一共查出了 " + userList.size() + " 个用户：");
        for (int i = 0; i < userList.size(); i++) {
            User u = userList.get(i);
            System.out.println("用户ID：" + u.getId() + "，用户姓名：" + u.getName());
        }
    }
}