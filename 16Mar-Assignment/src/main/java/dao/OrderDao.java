package dao;

import java.util.List;
import entity.Order;

public interface OrderDao {

    void addOrder(Order order);

    Order viewOrderById(int id);

    List<Order> viewOrdersByCustomerName(String name);

}