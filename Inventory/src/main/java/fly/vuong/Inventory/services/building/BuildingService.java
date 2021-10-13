package fly.vuong.Inventory.services.building;

import fly.vuong.Inventory.entities.dto.BuildingDto;
import fly.vuong.Inventory.request.AddBuildingRequest;

import java.util.List;
import java.util.UUID;

public interface BuildingService {
    BuildingDto createBuilding(AddBuildingRequest request);

    List<BuildingDto> findAll();

    BuildingDto findById(UUID id);

    List<BuildingDto> findByName(String name);

//    BuildingDto updateBuilding(UpdateBuildingRequest request);

}
