package com.learningrestprojectpizzeria.controllers.statistics;

import at.favre.lib.crypto.bcrypt.BCrypt;
import com.learningrestprojectpizzeria.model.entity.Clients;
import com.learningrestprojectpizzeria.service.statistics.accounts.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class Client {
    @Autowired
    private ClientService clientService;

    @GetMapping("/manage/clients")
    public List<Clients> getAllClients() {

        return clientService.getAllClients();
    }

    @GetMapping("/manage/client/{id}")
    public Clients getClient(@PathVariable int id) {

        return clientService.getClientById(id);
    }

    @PostMapping("/manage/clients")
    public Clients addNewClient (@RequestBody Clients client) {
        client.getLogin().setPassword("{bcrypt}" + BCrypt.withDefaults().hashToString(12,
                client.getLogin().getPassword().toCharArray()));
        clientService.saveClient(client);
        return client;
    }

    @PutMapping("/manage/clients")
    public Clients updateClient (@RequestBody Clients client) {
        clientService.saveClient(client);
        return client;
    }

    @DeleteMapping("/manage/clients/{id}")
    public String deleteClient (@PathVariable int id) {
        clientService.deleteClientById(id);
        return "ClientService with ID = " + id + " was deleted.";
    }
}