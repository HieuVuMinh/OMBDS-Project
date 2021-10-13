package fly.vuong.Inventory.entities;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "apartment_apartment_amenity")
public class ApartmentApartmentAmenity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private UUID apartmentId;
    private UUID apartmentAmenityId;
}
