package dao;

import model.Product;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class ProductDao {

    // 同样，把连接数据库提取成一个方法
    public Connection getConnection() throws Exception {
        return DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/campus_trade?useSSL=false&serverTimezone=UTC",
                "root",
                "lzq1314521"
        );
    }

    // 查出所有商品，返回一个 ArrayList<model.Product>
    public ArrayList<Product> findAll() throws Exception {
        Connection conn = getConnection();
        String sql = "SELECT id, title, price FROM t_product";
        PreparedStatement ps = conn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();

        // 准备一个袋子，装商品
        ArrayList<Product> productList = new ArrayList<>();

        // 循环把数据从 rs 里拿出来，塞进袋子
        while (rs.next()) {
            int id = rs.getInt("id");
            String title = rs.getString("title");
            double price = rs.getDouble("price"); // 价格用 getDouble

            // 造一个 model.Product 对象，丢进袋子
            productList.add(new Product(id, title, price));
        }

        rs.close();
        ps.close();
        conn.close();

        return productList; // 把装好商品的袋子还给调用者
    }
}