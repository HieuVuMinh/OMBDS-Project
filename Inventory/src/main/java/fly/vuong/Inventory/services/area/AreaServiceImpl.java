package fly.vuong.Inventory.services.area;

import fly.vuong.Inventory.entities.Area;
import fly.vuong.Inventory.entities.Building;
import fly.vuong.Inventory.entities.dto.AreaDto;
import fly.vuong.Inventory.repositories.AreaRepository;
import fly.vuong.Inventory.request.AddAreaRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class AreaServiceImpl implements AreaService {

    @Autowired
    AreaRepository repository;

    @Override
    public Area createArea(AddAreaRequest request) {
        // convert request to entity
        Area area = new Area();
        area.setAreaId(UUID.randomUUID());
        area.setName(request.getName());
        area.setDescription(request.getDescription());
        return repository.save(area);
    }

    @Override
    public List<AreaDto> findAll() {
        List<AreaDto> areaDtoList = new ArrayList<>();
        repository.findAll().forEach(area -> areaDtoList.add(convertFromArea(area)));
        return areaDtoList;
    }

    @Override
    public AreaDto findById(UUID id) {
        return null;
    }

    @Override
    public boolean addBuildingToArea(Building building) {

        return false;
    }

    public AreaDto convertFromArea(Area area) {
        AreaDto areaDto = new AreaDto();
        areaDto.setId(area.getAreaId());
        areaDto.setName(area.getName());
        areaDto.setDescription(area.getDescription());
        return areaDto;
    }
}
