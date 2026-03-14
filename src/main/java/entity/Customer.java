package entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="abes_customer")
public class Customer {

    @Id
    private int customerId;

    private String customerName;

    @OneToMany(mappedBy="customer", cascade=CascadeType.ALL)
    private List<Order> orders;

    public Customer(){}

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }
}