package com.learningrestprojectpizzeria.service.statistics.accounts;

import com.learningrestprojectpizzeria.model.entity.Clients;

import java.util.List;

public interface ClientService {
    public List<Clients> getAllClients();
    public void saveClient (Clients client);
    public Clients getClientById (int id);
    public void deleteClientById (int id);
}