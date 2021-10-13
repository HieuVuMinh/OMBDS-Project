package fly.vuong.Inventory.controller;

import fly.vuong.Inventory.entities.dto.ApartmentDto;
import fly.vuong.Inventory.request.AddApartmentRequest;
import fly.vuong.Inventory.services.apartment.ApartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping({"/apartment"})
public class ApartmentController {

    @Autowired
    ApartmentService service;

    @GetMapping
    public List<ApartmentDto> getAll() {
        return service.findAll();
    }

    @GetMapping({"/{id}"})
    public ApartmentDto findById(@PathVariable String id) {
        return service.findById(UUID.fromString(id));
    }

    @PostMapping
    public ApartmentDto addApartment(@RequestBody AddApartmentRequest request) {
        return service.createApartment(request);
    }

}
