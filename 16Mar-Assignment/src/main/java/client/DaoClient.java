package client;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

import dao.OrderDao;
import dao.OrderDaoImpl;
import entity.Customer;
import entity.Order;

public class DaoClient {

    static OrderDao dao = new OrderDaoImpl();
    static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {

        String opt = null;

        do {

            System.out.println("1-ADD ORDER");
            System.out.println("2-VIEW ORDER BY ID");
            System.out.println("3-VIEW ORDERS BY CUSTOMER NAME");

            int mtype = scan.nextInt();

            processMenu(mtype);

            System.out.println("Press y to continue");
            opt = scan.next().trim();

        } while (opt.equalsIgnoreCase("y"));
    }

    public static void processMenu(int mtype) {

        switch (mtype) {

        case 1:
            addOrder();
            break;

        case 2:
            viewOrderByOrderID();
            break;

        case 3:
            viewOrdersByCustName();
            break;

        default:
            System.out.println("Invalid option");
        }
    }

    public static void addOrder() {

        System.out.println("Enter Customer ID");
        int cid = scan.nextInt();

        System.out.println("Enter Customer Name");
        String cname = scan.next();

        System.out.println("Enter Order Amount");
        double amt = scan.nextDouble();

        Customer c = new Customer();
        c.setCustomerId(cid);
        c.setCustomerName(cname);

        Order o = new Order();
        o.setOrderAmt(amt);
        o.setOrderDate(new Date());
        o.setCustomer(c);

        dao.addOrder(o);
    }

    public static void viewOrderByOrderID() {

        System.out.println("Enter Order ID");
        int id = scan.nextInt();

        Order o = dao.viewOrderById(id);

        if (o != null) {

            System.out.println("Order ID: " + o.getOrderId());
            System.out.println("Order Amount: " + o.getOrderAmt());
            System.out.println("Order Date: " + o.getOrderDate());
            System.out.println("Customer Name: " + o.getCustomer().getCustomerName());

        } else {

            System.out.println("Order not found");
        }
    }

    public static void viewOrdersByCustName() {

        System.out.println("Enter Customer Name");
        String name = scan.next();

        List<Order> list = dao.viewOrdersByCustomerName(name);

        for (Order o : list) {

            System.out.println("Order ID: " + o.getOrderId());
            System.out.println("Amount: " + o.getOrderAmt());
            System.out.println("Date: " + o.getOrderDate());
        }
    }
}