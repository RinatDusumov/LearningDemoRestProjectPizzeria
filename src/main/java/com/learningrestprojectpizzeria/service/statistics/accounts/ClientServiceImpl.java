package com.learningrestprojectpizzeria.service.statistics.accounts;

import com.learningrestprojectpizzeria.model.entity.Clients;
import com.learningrestprojectpizzeria.repository.ClientDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientServiceImpl implements ClientService {
    @Autowired
    private ClientDAO clientRepository;
    
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