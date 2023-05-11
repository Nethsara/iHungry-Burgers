package me.siyum.ihungry.tm;

public class OrdersTM {
    String oid;
    String custID;
    int qty;

    String status;

    public OrdersTM(String oid, String custID, int qty, String status) {
        this.oid = oid;
        this.custID = custID;
        this.qty = qty;
        this.status = status;
    }

    public String getOid() {
        return oid;
    }

    public void setOid(String oid) {
        this.oid = oid;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
