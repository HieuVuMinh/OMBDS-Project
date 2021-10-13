package fly.vuong.Inventory.entities.dto;

import lombok.Data;

import java.util.UUID;

@Data
public class AreaDto {
    private UUID id;
    private String name;
    private String description;
}
