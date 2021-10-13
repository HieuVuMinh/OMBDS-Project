package fly.vuong.Inventory.entities;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "apartment_furniture")
public class ApartmentFurniture {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private UUID apartmentId;
    private UUID furnitureId;
}
