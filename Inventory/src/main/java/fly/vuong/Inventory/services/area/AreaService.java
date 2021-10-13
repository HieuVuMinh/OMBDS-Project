package fly.vuong.Inventory.services.area;

import fly.vuong.Inventory.entities.Area;
import fly.vuong.Inventory.entities.Building;
import fly.vuong.Inventory.entities.dto.AreaDto;
import fly.vuong.Inventory.request.AddAreaRequest;

import java.util.List;
import java.util.UUID;

public interface AreaService {
    Area createArea(AddAreaRequest request);

    List<AreaDto> findAll();

    AreaDto findById(UUID id);

    boolean addBuildingToArea(Building building);
}
