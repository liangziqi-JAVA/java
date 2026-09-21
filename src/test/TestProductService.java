package test;

import model.Product;
import service.ProductService;
import java.util.ArrayList;

public class TestProductService {
    public static void main(String[] args) {
        // 顾客直接找业务员
        ProductService productService = new ProductService();
        ArrayList<Product> list = productService.getAllProducts();

        System.out.println("=== 商品列表 ===");
        for (Product p : list) {
            System.out.println("编号：" + p.getId() + " | 名称：" + p.getTitle() + " | 价格：" + p.getPrice());
        }
    }
}
