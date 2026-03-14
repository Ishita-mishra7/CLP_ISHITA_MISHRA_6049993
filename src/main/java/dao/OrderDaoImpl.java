package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import entity.Order;
import util.JPAUtil;

public class OrderDaoImpl implements OrderDao {

    @Override
    public void addOrder(Order order) {

        EntityManager em = JPAUtil.getFactory().createEntityManager();

        em.getTransaction().begin();

        em.persist(order);

        em.getTransaction().commit();

        em.close();

        System.out.println("Order Added Successfully");
    }

    @Override
    public Order viewOrderById(int id) {

        EntityManager em = JPAUtil.getFactory().createEntityManager();

        Order o = em.find(Order.class, id);

        em.close();

        return o;
    }

    @Override
    public List<Order> viewOrdersByCustomerName(String name) {

        EntityManager em = JPAUtil.getFactory().createEntityManager();

        Query q = em.createQuery(
                "select o from Order o where o.customer.customerName=:name");

        q.setParameter("name", name);

        List<Order> list = q.getResultList();

        em.close();

        return list;
    }
}