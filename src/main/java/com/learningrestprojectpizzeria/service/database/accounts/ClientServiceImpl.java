package com.learningrestprojectpizzeria.service.database.accounts;

import com.learningrestprojectpizzeria.model.dto.Customer;
import com.learningrestprojectpizzeria.model.entity.Clients;
import com.learningrestprojectpizzeria.model.entity.Orders;
import com.learningrestprojectpizzeria.repository.ClientDAO;
import com.learningrestprojectpizzeria.service.database.sales.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@Service
public class ClientServiceImpl implements ClientService {
    @Autowired
    private ClientDAO clientDAO;

    @Autowired
    private OrderService orderService;

    private final List<Customer> allCustomer = new LinkedList<>();



    @Override
    public List<Customer> getAReportOnAllClients() {
        for(Clients client : getAllClients()) {
            double income = 0;
            for (Orders order : client.getAllOrders()) {
                income += orderService.receivingPaymentData(order).getTotalAmount();
            }
            allCustomer.add(new Customer(client.getFirstName().concat(client.getSurname()),
                    client.getPhoneNumber(), income));
        }

        return allCustomer;
    }

    
    @Override
    public List<Clients> getAllClients() {
        return clientDAO.findAll();
    }

    @Override
    public void saveClient(Clients client) {
        clientDAO.save(client);
    }

    @Override
    public Clients getClientById(int id) {
        Clients client = null;
        Optional<Clients> optional = clientDAO.findById(id);
        if(optional.isPresent()) {
            client = optional.get();
        }
        return client;
    }

    @Override
    public void deleteClientById(int id) {
        Optional<Clients> optional = clientDAO.findById(id);
        if(optional.isPresent()) {
            clientDAO.deleteById(id);
        }

    }
}