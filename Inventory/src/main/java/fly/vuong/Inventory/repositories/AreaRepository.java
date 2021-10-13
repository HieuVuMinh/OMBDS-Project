package fly.vuong.Inventory.repositories;

import fly.vuong.Inventory.entities.Area;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface AreaRepository extends JpaRepository<Area, UUID> {
    List<Area> findAll();

    Optional<Area> findById(UUID id);

    List<Area> findByName(String name);
}
