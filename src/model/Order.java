package model;

public class Order {
    private int id;
    private String orderNo;  // 订单号
    private int buyerId;     // 买家ID
    private double totalPrice; // 总价

    public Order(String orderNo, int buyerId, double totalPrice) {
        this.orderNo = orderNo;
        this.buyerId = buyerId;
        this.totalPrice = totalPrice;
    }

    public int getId() { return id; }
    public String getOrderNo() { return orderNo; }
    public int getBuyerId() { return buyerId; }
    public double getTotalPrice() { return totalPrice; }
}


