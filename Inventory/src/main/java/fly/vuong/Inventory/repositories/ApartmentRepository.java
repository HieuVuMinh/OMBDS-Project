package fly.vuong.Inventory.repositories;

import fly.vuong.Inventory.entities.Apartment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface ApartmentRepository extends JpaRepository<Apartment, UUID> {
    List<Apartment> findAll();

    Optional<Apartment> findById(UUID id);

    List<Apartment> findByPriceBetween(double min, double max);
//    List<Apartment> findByBuilding_AreaId(UUID areaId);
}
