package com.learningrestprojectpizzeria.service.warehouse;

import com.learningrestprojectpizzeria.model.entity.Deliveries;
import com.learningrestprojectpizzeria.repository.DeliveriesDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DeliveriesServiceImpl implements DeliveriesService {
    @Autowired
    private DeliveriesDAO deliveriesRepository;

    @Override
    public List<Deliveries> getAllDeliveries() {

        return deliveriesRepository.findAll();
    }

    @Override
    public void saveDeliveries(Deliveries deliveries) {

        Deliveries newDeliveries = deliveriesRepository.save(deliveries);
    }

    @Override
    public Deliveries getDeliveriesById(int id) {
        Deliveries deliveries = null;
        Optional<Deliveries> optional = deliveriesRepository.findById(id);
        if(optional.isPresent()) {
            deliveries = optional.get();
            // если optional пуст можно выбрасывать исключение
        }
        return deliveries;
    }

    @Override
    public void deleteDeliveriesById(int id) {
        Optional<Deliveries> optional = deliveriesRepository.findById(id);
        if (optional.isPresent()) {
            deliveriesRepository.deleteById(id);
        }
        //TODO если optional пуст можно выбрасывать исключение

    }
}
