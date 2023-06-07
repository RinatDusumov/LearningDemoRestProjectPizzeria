package com.learningrestprojectpizzeria.dao.sales;

import com.learningrestprojectpizzeria.controllers.sales.WeeklyReportsController;
import com.learningrestprojectpizzeria.models.salesEntity.Orders;
import com.learningrestprojectpizzeria.models.salesEntity.WeeklyReports;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class OrdersDAOImpl implements OrdersDAO {
    @Autowired
    private EntityManager entityManager;

    @Override
    public List<Orders> getAllOrders() {
        Query query = entityManager.createQuery("from Orders");
        return query.getResultList();
    }

    @Override
    public void saveOrder(Orders orders) {
        Orders newOrder = entityManager.merge(orders);
        orders.setId(newOrder.getId());
    }

    @Override
    public List<Orders> getOrders(int id) {
        Query query = entityManager.createQuery("from Orders where id =:ordersId");
        query.setParameter("ordersId", id);
        return query.getResultList();
    }

    @Override
    public void deleteOrder(int id) {
        Query query = entityManager.createQuery("delete from Orders " +
                "where id =:ordersId");
        query.setParameter("ordersId", id);
        query.executeUpdate();
    }

    @Override
    public Double getTheFullAmountOfTheOrder(int id) {
        Query query = entityManager.createQuery(
                "select sum(Menu.price * Orders.quantity)" +
                        "from Orders where Orders.id =:ordersId");
        query.setParameter("ordersId", id);
        return (double) query.getFirstResult();
    }

    @Override
    public List<WeeklyReports> gettingDataForReport() {
        Query query = entityManager.createQuery(
                "select " +
                        "Menu.category as Category, " +
                        "Menu.dishName as Dish_name, " +
                        "Menu.price as Price, " +
                        "sum(Menu.price * Orders.quantity) as Profit " +
                        "from Orders group by Menu.category");
        return query.getResultList();
    }
}