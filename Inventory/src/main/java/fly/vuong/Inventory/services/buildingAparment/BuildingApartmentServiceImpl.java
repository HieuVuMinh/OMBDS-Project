package fly.vuong.Inventory.services.buildingAparment;

import fly.vuong.Inventory.entities.BuildingApartment;
import fly.vuong.Inventory.repositories.BuildingApartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class BuildingApartmentServiceImpl implements BuildingApartmentService {

    @Autowired
    BuildingApartmentRepository buildingApartmentRepository;

    @Override
    public List<BuildingApartment> getAll() {
        return buildingApartmentRepository.findAll();
    }

    @Override
    public List<BuildingApartment> findApartmentByBuildingId(UUID buildingId) {
        return buildingApartmentRepository.findByBuildingId(buildingId);
    }

    @Override
    public BuildingApartment addApartmentToBuilding(BuildingApartment buildingApartment) {
        return buildingApartmentRepository.save(buildingApartment);
    }
}
