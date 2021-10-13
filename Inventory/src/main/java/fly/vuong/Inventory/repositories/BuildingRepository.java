package fly.vuong.Inventory.repositories;

import fly.vuong.Inventory.entities.Building;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface BuildingRepository extends JpaRepository<Building, UUID> {
    List<Building> findAll();

    Optional<Building> findById(UUID id);

    List<Building> findByNameContains(String name);
}
