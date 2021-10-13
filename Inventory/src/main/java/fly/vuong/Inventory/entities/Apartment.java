package fly.vuong.Inventory.entities;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.Hibernate;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Objects;
import java.util.UUID;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
@Table(name = "apartments")
public class Apartment {
    @Id
    private UUID apartmentId;
    private double price;
    private double superficies;
    private int bedRoom;
    private String address;
    //    private Direction direction;
//    private Map<String, String> information;
    private int ownerId;
    private boolean status;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Apartment apartment = (Apartment) o;
        return apartmentId != null && Objects.equals(apartmentId, apartment.apartmentId);
    }

    @Override
    public int hashCode() {
        return 0;
    }
}
