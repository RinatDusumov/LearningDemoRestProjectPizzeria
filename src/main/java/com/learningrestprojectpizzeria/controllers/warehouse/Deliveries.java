package com.learningrestprojectpizzeria.controllers.warehouse;

import com.learningrestprojectpizzeria.service.warehouse.DeliveriesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class Deliveries {
    @Autowired
    private DeliveriesService deliveriesService;

    @GetMapping("/manage/deliveries")
    public List<com.learningrestprojectpizzeria.model.entity.Deliveries> getAllDeliveries() {
        return deliveriesService.getAllDeliveries();
    }

    @GetMapping("/manage/deliveries/{id}")
    public com.learningrestprojectpizzeria.model.entity.Deliveries getAccount(@PathVariable int id) {
        return deliveriesService.getDeliveriesById(id);
    }

    @PostMapping("/manage/deliveries")
    public com.learningrestprojectpizzeria.model.entity.Deliveries addNewDeliveries (@RequestBody com.learningrestprojectpizzeria.model.entity.Deliveries deliveries) {
        deliveriesService.saveDeliveries(deliveries);
        return deliveries;
    }

    @PutMapping("/manage/deliveries")
    public com.learningrestprojectpizzeria.model.entity.Deliveries updateDeliveries (@RequestBody com.learningrestprojectpizzeria.model.entity.Deliveries deliveries) {
        deliveriesService.saveDeliveries(deliveries);
        return deliveries;
    }

    @DeleteMapping("/manage/deliveries/{id}")
    public String deleteDeliveries (@PathVariable int id) {
        deliveriesService.deleteDeliveriesById(id);
        return "Deliver with ID = " + id + " was deleted.";
    }
}
