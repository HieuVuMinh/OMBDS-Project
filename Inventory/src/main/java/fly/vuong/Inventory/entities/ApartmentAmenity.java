package fly.vuong.Inventory.entities;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.UUID;

@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class ApartmentAmenity {
    @Id
    private UUID apartmentAmenityId;
    private String name;
}
