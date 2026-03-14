package entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="abes_order")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int orderId;

    private double orderAmt;

    @Temporal(TemporalType.DATE)
    private Date orderDate;

    @ManyToOne
    @JoinColumn(name="customer_id")
    private Customer customer;

    public Order() {}

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public double getOrderAmt() {
        return orderAmt;
    }

    public void setOrderAmt(double orderAmt) {
        this.orderAmt = orderAmt;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}