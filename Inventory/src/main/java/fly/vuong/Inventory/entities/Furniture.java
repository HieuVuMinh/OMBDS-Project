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
@Table(name = "furniture")
public class Furniture {

    @Id
    private UUID furnitureId;
    private String name;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Furniture furniture = (Furniture) o;
        return furnitureId != null && Objects.equals(furnitureId, furniture.furnitureId);
    }

    @Override
    public int hashCode() {
        return 0;
    }
}
