package com.learningrestprojectpizzeria.service.database.accounts;

import com.learningrestprojectpizzeria.model.dto.reporting.Customer;
import com.learningrestprojectpizzeria.model.entity.Clients;
import com.learningrestprojectpizzeria.model.entity.MenuPositions;
import com.learningrestprojectpizzeria.model.entity.Orders;
import com.learningrestprojectpizzeria.repository.ClientDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@Service
public class ClientServiceImpl implements ClientService {
    @Autowired
    private ClientDAO clientRepository;

    private final List<Customer> allCustomer = new LinkedList<>();

    private String fullNameCustomer = null;
    private String phoneNumber = null;
    private double income = 0;
    private int totalQuanity = 0;


    @Override
    public List<Customer> findClientByFullName(String fullName) {
        List<Clients> allClients = getAllClients();
        for(Clients client : allClients) {
            fullNameCustomer = client.getFirstName().concat(client.getSurname());
            phoneNumber = client.getPhoneNumber();
            for (Orders order : client.getAllOrders()) {
                income = incomeCalculation(income, order.getQuantity(), order.getMenuPosition());
                totalQuanity = countingTheTotal(totalQuanity, order.getQuantity());
            }
        }
        double averageCheck = calculationOfTheAverageCheck(income, totalQuanity);
        allCustomer.add(new Customer(fullNameCustomer, phoneNumber , income, averageCheck));
        return allCustomer;
    }

    public double incomeCalculation(double income, Integer quantity, List<MenuPositions> positions) {
        for(MenuPositions position : positions) {
            income = position.getPrice() * quantity;
        }
        return income;
    }
    
    public double calculationOfTheAverageCheck(double income, int totalQuantity) {
        return income / (double) totalQuantity;
    }

    public int countingTheTotal(int totalQuantity, int quantity) {
        return totalQuantity += quantity;
    }
    
    @Override
    public List<Clients> getAllClients() {
        return clientRepository.findAll();
    }

    @Override
    public void saveClient(Clients client) {
        clientRepository.save(client);
    }

    @Override
    public Clients getClientById(int id) {
        Clients client = null;
        Optional<Clients> optional = clientRepository.findById(id);
        if(optional.isPresent()) {
            client = optional.get();
        }
        return client;
    }

    @Override
    public void deleteClientById(int id) {
        Optional<Clients> optional = clientRepository.findById(id);
        if(optional.isPresent()) {
            clientRepository.deleteById(id);
        }

    }
}