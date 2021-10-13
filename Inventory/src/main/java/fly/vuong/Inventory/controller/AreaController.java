package fly.vuong.Inventory.controller;

import fly.vuong.Inventory.entities.Area;
import fly.vuong.Inventory.entities.dto.AreaDto;
import fly.vuong.Inventory.request.AddAreaRequest;
import fly.vuong.Inventory.services.area.AreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping({"/area"})
public class AreaController {

    @Autowired
    AreaService service;

    @GetMapping({""})
    public List<AreaDto> getAll() {
        return service.findAll();
    }

    @PostMapping({""})
    public Area addArea(@RequestBody AddAreaRequest request) {
        Area area = service.createArea(request);
        return area;
    }
}
