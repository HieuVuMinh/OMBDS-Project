package fly.vuong.Inventory.controller;

import fly.vuong.Inventory.entities.BuildingApartment;
import fly.vuong.Inventory.services.buildingAparment.BuildingApartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/building-apartment")
public class BuildingApartmentController {

    @Autowired
    BuildingApartmentService buildingApartmentService;

    @GetMapping
    public List<BuildingApartment> buildingApartments() {
        return buildingApartmentService.getAll();
    }

    @GetMapping("/building/{id}/apartment")
    public List<BuildingApartment> findApartmentByBuildingId(@PathVariable String id) {
        return buildingApartmentService.findApartmentByBuildingId(UUID.fromString(id));
    }
}
