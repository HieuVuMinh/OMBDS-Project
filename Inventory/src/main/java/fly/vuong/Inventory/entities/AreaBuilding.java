package fly.vuong.Inventory.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "area_building")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AreaBuilding {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private UUID areaId;
    private UUID buildingId;
}
