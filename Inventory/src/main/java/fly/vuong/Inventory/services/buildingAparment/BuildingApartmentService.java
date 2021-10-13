package fly.vuong.Inventory.services.buildingAparment;

import fly.vuong.Inventory.entities.BuildingApartment;

import java.util.List;
import java.util.UUID;

public interface BuildingApartmentService {
    List<BuildingApartment> getAll();

    List<BuildingApartment> findApartmentByBuildingId(UUID buildingId);
//    ApartmentDto addApartmentToBuilding();
    BuildingApartment addApartmentToBuilding(BuildingApartment buildingApartment);
}
