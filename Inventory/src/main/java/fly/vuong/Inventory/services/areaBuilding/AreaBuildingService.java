package fly.vuong.Inventory.services.areaBuilding;

import fly.vuong.Inventory.entities.AreaBuilding;

import java.util.List;
import java.util.UUID;

public interface AreaBuildingService {
    List<AreaBuilding> getAll();

    List<AreaBuilding> findAllByAreaId(UUID id);

    AreaBuilding findByBuildingId(UUID id);

    AreaBuilding addBuildingToArea(AreaBuilding areaBuilding);
}
