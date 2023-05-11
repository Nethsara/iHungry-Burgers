package me.siyum.ihungry.model;

public class Order {
    String orderId;
    String custID;
    int qty;
    int status;

    public Order(String orderId, String custID, int qty, int status) {
        this.orderId = orderId;
        this.custID = custID;
        this.qty = qty;
        this.status = status;
    }

    public Order() {
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getCustID() {
        return custID;
    }

    public void setCustID(String custID) {
        this.custID = custID;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId='" + orderId + '\'' +
                ", custID='" + custID + '\'' +
                ", qty=" + qty +
                ", status=" + status +
                '}';
    }
}
