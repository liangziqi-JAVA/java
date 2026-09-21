package dao;

import model.Order;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class OrderDao {
    // 1. 借用 UserDao 里的数据库连接方法
    private UserDao userDao = new UserDao();

    // 2. 新增订单
    public void insertOrder(Order order) throws Exception {
        Connection conn = userDao.getConnection();
        String sql = "INSERT INTO orders(order_no, buyer_id, total_price, status) VALUES(?, ?, ?, 0)";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, order.getOrderNo());
        ps.setInt(2, order.getBuyerId());
        ps.setDouble(3, order.getTotalPrice());

        ps.executeUpdate();
        ps.close();
        conn.close();
    }

    // 3. 根据订单号查询订单id（解决第二步报错的关键）
    public int findIdByOrderNo(String orderNo) throws Exception {
        Connection conn = userDao.getConnection();
        String sql = "SELECT id FROM orders WHERE order_no = ?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, orderNo);
        ResultSet rs = ps.executeQuery();

        int id = 0;
        if (rs.next()) {
            id = rs.getInt("id");
        }
        rs.close();
        ps.close();
        conn.close();
        return id;
    }
}
