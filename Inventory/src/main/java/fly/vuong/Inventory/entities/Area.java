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
@Table(name = "areas")
public class Area {
    @Id
    private UUID areaId;
    private String name;
    private String description;
    private String information;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Area area = (Area) o;
        return areaId != null && Objects.equals(areaId, area.areaId);
    }

    @Override
    public int hashCode() {
        return 0;
    }
}
