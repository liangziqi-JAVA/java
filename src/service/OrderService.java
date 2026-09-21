package service;

import dao.OrderDao;
import dao.OrderItemDao;
import model.Order;
import model.OrderItem;


public class OrderService {
    private OrderDao orderDao = new OrderDao();
    private OrderItemDao orderItemDao = new OrderItemDao();
    // 下单业务
    public void createOrder(int buyerId, double totalPrice, int productId, double price, int quantity) {
        try {
            // 1. 生成唯一订单号
            String orderNo = "ORD-" + System.currentTimeMillis();

            // 2. 组装主订单对象，并写库
            Order order = new Order(orderNo, buyerId, totalPrice);
            orderDao.insertOrder(order);

            // 3. 去数据库查出刚刚生成的主订单 id
            int orderId = orderDao.findIdByOrderNo(orderNo);

            // 4. 组装订单明细对象，并写库（这里我们模拟买 quantity 本书）
            OrderItem item = new OrderItem(orderId, productId, price, quantity);
            orderItemDao.insertOrderItem(item);

            System.out.println("下单成功！主订单号：" + orderNo + "，总价：" + totalPrice);

        } catch (Exception e) {
            System.out.println("下单失败：" + e.getMessage());
        }
    }
}