package fly.vuong.Inventory.services.areaBuilding;

import fly.vuong.Inventory.entities.AreaBuilding;
import fly.vuong.Inventory.repositories.AreaBuildingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class AreaBuildingServiceImpl implements AreaBuildingService {

    @Autowired
    AreaBuildingRepository areaBuildingRepository;

    @Override
    public List<AreaBuilding> getAll() {
        return areaBuildingRepository.findAll();
    }

    @Override
    public List<AreaBuilding> findAllByAreaId(UUID id) {
        return areaBuildingRepository.findAllByAreaId(id);
    }

    @Override
    public AreaBuilding findByBuildingId(UUID id) {
        return areaBuildingRepository.findByBuildingId(id).get();
    }

    @Override
    public AreaBuilding addBuildingToArea(AreaBuilding areaBuilding) {
        return areaBuildingRepository.save(areaBuilding);
    }
}
