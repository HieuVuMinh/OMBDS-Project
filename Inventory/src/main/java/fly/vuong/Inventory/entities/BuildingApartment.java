package fly.vuong.Inventory.entities;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "building_apartment")
public class BuildingApartment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private UUID buildingId;
    private UUID apartmentId;
}
