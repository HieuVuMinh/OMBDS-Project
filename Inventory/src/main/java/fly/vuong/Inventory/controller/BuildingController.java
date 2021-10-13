package fly.vuong.Inventory.controller;

import fly.vuong.Inventory.entities.dto.BuildingDto;
import fly.vuong.Inventory.request.AddBuildingRequest;
import fly.vuong.Inventory.services.building.BuildingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping({"/building"})
public class BuildingController {
    @Autowired
    BuildingService service;

    @GetMapping({""})
    public List<BuildingDto> getAll() {
        return service.findAll();
    }

    @GetMapping({"/{id}"})
    public BuildingDto findById(@PathVariable UUID id) {
        return service.findById(id);
    }

    @GetMapping({"/"})
    public List<BuildingDto> findByName(@RequestParam String name) {
        return service.findByName(name);
    }

    @PostMapping({""})
    public BuildingDto addBuilding(@RequestBody AddBuildingRequest request) {
        return service.createBuilding(request);
    }

}
