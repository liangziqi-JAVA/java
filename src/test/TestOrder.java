package test;

import service.OrderService;

public class TestOrder {
    public static void main(String[] args) {
        OrderService orderService = new OrderService();
        // 张三(id=1) 买 2 本 Java编程思想(id=1, 单价45.0)，总价 90.0
        orderService.createOrder(1, 90.0, 1, 45.0, 2);
    }
}