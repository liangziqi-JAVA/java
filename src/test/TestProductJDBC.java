package test;

import dao.ProductDao;
import model.Product;

import java.util.ArrayList;

public class TestProductJDBC {
    public static void main(String[] args) throws Exception {
        // 1. 找仓库管理员
        ProductDao productDao = new ProductDao();

        // 2. 拿数据（调用查所有商品的方法）
        ArrayList<Product> productList = productDao.findAll();

        // 3. 打印结果
        System.out.println("一共查出了 " + productList.size() + " 个商品：");
        for (int i = 0; i < productList.size(); i++) {
            Product p = productList.get(i);
            System.out.println("商品ID：" + p.getId() + "，商品名：" + p.getTitle() + "，价格：" + p.getPrice());
        }
    }
}