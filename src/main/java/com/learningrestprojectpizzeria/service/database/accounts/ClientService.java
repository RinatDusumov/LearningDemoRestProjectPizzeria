package com.learningrestprojectpizzeria.service.database.accounts;

import com.learningrestprojectpizzeria.model.dto.Customer;
import com.learningrestprojectpizzeria.model.entity.Clients;

import java.util.List;

public interface ClientService {

    public List<Customer> getAReportOnAllClients();

    public List<Clients> getAllClients();
    public void saveClient (Clients client);
    public Clients getClientById (int id);
    public void deleteClientById (int id);
}