package fly.vuong.Inventory.repositories;

import fly.vuong.Inventory.entities.AreaBuilding;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface AreaBuildingRepository extends JpaRepository<AreaBuilding, Long> {
    List<AreaBuilding> findAll();

    List<AreaBuilding> findAllByAreaId(UUID areaId);

    Optional<AreaBuilding> findByBuildingId(UUID buildingId);

}
