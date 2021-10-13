package fly.vuong.Inventory.entities;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "area_area_amenity")
public class AreaAreaAmenity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private UUID areaId;
    private UUID areaAmenityId;
}
