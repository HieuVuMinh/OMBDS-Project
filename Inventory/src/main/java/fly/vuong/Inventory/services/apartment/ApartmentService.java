package fly.vuong.Inventory.services.apartment;

import fly.vuong.Inventory.entities.Area;
import fly.vuong.Inventory.entities.Building;
import fly.vuong.Inventory.entities.dto.ApartmentDto;
import fly.vuong.Inventory.request.AddApartmentRequest;

import java.util.List;
import java.util.UUID;

public interface ApartmentService {
    ApartmentDto createApartment(AddApartmentRequest request);

    ApartmentDto findById(UUID id);

    List<ApartmentDto> findAll();

    List<ApartmentDto> findByBuildingId(UUID id);

    List<ApartmentDto> findByAreaId(UUID id);

    List<ApartmentDto> findByBuilding(Building building);

    List<ApartmentDto> findByArea(Area area);
}
