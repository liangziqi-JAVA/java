package dao;

import model.OrderItem;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class OrderItemDao {
    private UserDao userDao = new UserDao();

    // 新增订单明细
    public void insertOrderItem(OrderItem item) throws Exception {
        Connection conn = userDao.getConnection();
        String sql = "INSERT INTO order_item(order_id, product_id, price, quantity) VALUES(?, ?, ?, ?)";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, item.getOrderId());
        ps.setInt(2, item.getProductId());
        ps.setDouble(3, item.getPrice());
        ps.setInt(4, item.getQuantity());

        ps.executeUpdate();
        ps.close();
        conn.close();
    }
}