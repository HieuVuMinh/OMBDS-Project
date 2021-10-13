package fly.vuong.Inventory.request;

import lombok.Data;

import java.util.UUID;

@Data
public class AddBuildingRequest {
    private String name;
    private UUID areaId;
}
