package fly.vuong.Inventory.repositories;

import fly.vuong.Inventory.entities.BuildingApartment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface BuildingApartmentRepository extends JpaRepository<BuildingApartment, Long> {
    List<BuildingApartment> findAll();

    List<BuildingApartment> findByBuildingId(UUID buildingId);

    Optional<BuildingApartment> findByApartmentId(UUID apartmentId);

}
