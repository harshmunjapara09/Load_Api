package com.Load_Api.Controller;

import com.Load_Api.Model.Load;
import com.Load_Api.Service.LoadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/load")
public class LoadController {

    @Autowired
    LoadService loadService;
    @PostMapping("")
    private String payload(@RequestBody Load load){
        return loadService.payload(load);
    }
   
    @GetMapping("")
    private List<Load> getList(@RequestParam UUID shipperId){
        return loadService.FindByShipperId(shipperId);
    }

    @GetMapping("/{loadId}")
    private Optional<Load> getLoad(@PathVariable Long loadId){
        return loadService.getLoad(loadId);
    }

    @PutMapping("/{loadId}")
    private Load updateLoad(@PathVariable Long loadId,@RequestBody Load updateLoad){
        return loadService.updateLoad(loadId,updateLoad);
    }

    @DeleteMapping("/{loadId}")
    private String deleteLoad(@PathVariable Long loadId){
        return loadService.deleteLoad(loadId);
    }

}
