package fly.vuong.Inventory.controller;

import fly.vuong.Inventory.entities.AreaBuilding;
import fly.vuong.Inventory.services.areaBuilding.AreaBuildingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/area-building")
public class AreaBuildingController {

    @Autowired
    AreaBuildingService areaBuildingService;

    @GetMapping
    public List<AreaBuilding> getAll() {
        List<AreaBuilding> areaBuildings;
        areaBuildings = areaBuildingService.getAll();
        return areaBuildings;
    }

    @GetMapping("/area/{id}/building")
    public List<AreaBuilding> findAllByAreaId(@PathVariable String id) {
        List<AreaBuilding> areaBuildings;
        areaBuildings = areaBuildingService.findAllByAreaId(UUID.fromString(id));
        return areaBuildings;
    }

    @GetMapping("/building/{id}")
    public AreaBuilding findByBuildingId(@PathVariable String id) {
        return areaBuildingService.findByBuildingId(UUID.fromString(id));
    }

    @PostMapping
    public AreaBuilding addBuildingToArea(@RequestBody AreaBuilding areaBuilding) {
        return areaBuildingService.addBuildingToArea(areaBuilding);
    }

}
