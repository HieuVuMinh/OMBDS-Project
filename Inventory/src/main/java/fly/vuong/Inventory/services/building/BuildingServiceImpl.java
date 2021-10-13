package fly.vuong.Inventory.services.building;

import fly.vuong.Inventory.entities.Building;
import fly.vuong.Inventory.entities.dto.BuildingDto;
import fly.vuong.Inventory.repositories.BuildingRepository;
import fly.vuong.Inventory.request.AddBuildingRequest;
import fly.vuong.Inventory.request.UpdateBuildingRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class BuildingServiceImpl implements BuildingService {

    @Autowired
    BuildingRepository repository;

    @Override
    public BuildingDto createBuilding(AddBuildingRequest request) {
        Building building = new Building();
        building.setBuildingId(UUID.randomUUID());
        building.setName(request.getName());
        repository.save(building);
        return convertFromBuilding(building);
    }

    @Override
    public List<BuildingDto> findAll() {
        return convertFromListEntity(repository.findAll());
    }

    @Override
    public BuildingDto findById(UUID id) {
        return convertFromBuilding(repository.findById(id).get());
    }

    @Override
    public List<BuildingDto> findByName(String name) {
        return convertFromListEntity(repository.findByNameContains(name));
    }

    @Override
    public BuildingDto updateBuilding(UpdateBuildingRequest request) {
        Building building = new Building();
        building.setName(request.getName());
        repository.save(building);
        return null;
    }

    public BuildingDto convertFromBuilding(Building building) {
        BuildingDto buildingDto = new BuildingDto();
        buildingDto.setId(building.getBuildingId());
        buildingDto.setName(building.getName());
        return buildingDto;
    }

    public List<BuildingDto> convertFromListEntity(List<Building> buildingList) {
        List<BuildingDto> buildingDtoList = new ArrayList<>();
        buildingList.forEach(building -> buildingDtoList.add(convertFromBuilding(building)));
        return buildingDtoList;
    }
}
