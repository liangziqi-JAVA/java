package model;

public class OrderItem {
    private int id;
    private int orderId;    // 属于哪个订单
    private int productId;  // 买了哪个商品
    private double price;   // 单价
    private int quantity;   // 买了几个

    public OrderItem(int orderId, int productId, double price, int quantity) {
        this.orderId = orderId;
        this.productId = productId;
        this.price = price;
        this.quantity = quantity;
    }

    public int getId() { return id; }
    public int getOrderId() { return orderId; }
    public int getProductId() { return productId; }
    public double getPrice() { return price; }
    public int getQuantity() { return quantity; }
}