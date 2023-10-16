package com.Load_Api.Service;

import com.Load_Api.Model.Load;
import com.Load_Api.Repository.LoadRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class LoadService {
    @Autowired
    LoadRepo loadRepo;
    public String payload(Load load) {
        loadRepo.save(load);
        return "loads details added successfully";
    }

    public List<Load> FindByShipperId(UUID shipperId) {
        return loadRepo.findByShipperId(shipperId);
    }

    public Optional<Load> getLoad(Long loadId) {
        return loadRepo.findById(loadId);
    }

    public Load updateLoad(Long loadId,Load updateLoad) {
        Load update = loadRepo.findById(loadId).orElse(null);

        update.setLoadingPoint(updateLoad.getLoadingPoint());
        update.setUnloadingPoint(updateLoad.getUnloadingPoint());
        update.setProductType(updateLoad.getProductType());
        update.setTruckType(updateLoad.getTruckType());
        update.setNoOfTrucks(updateLoad.getNoOfTrucks());
        update.setWeight(updateLoad.getWeight());
        update.setComment(updateLoad.getComment());
        update.setDate(updateLoad.getDate());
        return loadRepo.save(update);
    }

    public String deleteLoad(Long loadId) {
        loadRepo.deleteById(loadId);
        return "Load Deleted Successfully...";
    }
}
