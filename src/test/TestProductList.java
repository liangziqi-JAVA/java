package test;

import model.Product;

import java.util.ArrayList;
public class TestProductList {
    public static void main(String[] args){
        ArrayList<Product> productList = new ArrayList<>();
        Product p1 = new Product(1,"java编程思想",45.00);
        Product p2 = new Product(2,"二手自行车",180.00);
        Product p3 = new Product(3,"机械键盘",250.00);
        productList.add(p1);
        productList.add(p2);
        productList.add(p3);
        System.out.println("一共查出了" + productList.size()+ "个商品");
        for (int i = 0; i < productList.size(); i++){
            Product temp = productList.get(i);
            System.out.println("商品名：" + temp.getTitle() + "，价格" + temp.getPrice());
        }
    }
}
