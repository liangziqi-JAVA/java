package service;

import dao.ProductDao;
import model.Product;
import java.util.ArrayList;

public class ProductService {
    // 业务员找仓库管理员拿货
    private ProductDao productDao = new ProductDao();

    // 获取所有商品（以后可以做过滤：比如只查在售的）
    public ArrayList<Product> getAllProducts() {
        try {
            return productDao.findAll();
        } catch (Exception e) {
            System.out.println("查询商品失败：" + e.getMessage());
            return new ArrayList<>(); // 出错就返回空袋子
        }
    }
}