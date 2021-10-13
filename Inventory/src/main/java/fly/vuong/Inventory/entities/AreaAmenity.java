package fly.vuong.Inventory.entities;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.Hibernate;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;
import java.util.UUID;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
public class AreaAmenity {
    @Id
    private UUID areaAmenityId;
    private String name;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        AreaAmenity that = (AreaAmenity) o;
        return areaAmenityId != null && Objects.equals(areaAmenityId, that.areaAmenityId);
    }

    @Override
    public int hashCode() {
        return 0;
    }
}
