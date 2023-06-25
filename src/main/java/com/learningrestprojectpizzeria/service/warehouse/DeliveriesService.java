package com.learningrestprojectpizzeria.service.warehouse;

import com.learningrestprojectpizzeria.model.entity.Deliveries;

import java.util.List;

public interface DeliveriesService {
    public List<Deliveries> getAllDeliveries();
    public void saveDeliveries (Deliveries deliveries);
    public Deliveries getDeliveriesById (int id);
    public void deleteDeliveriesById (int id);
}
