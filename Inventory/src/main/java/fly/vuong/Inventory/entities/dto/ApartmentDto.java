package fly.vuong.Inventory.entities.dto;

import fly.vuong.Inventory.entities.Building;
import lombok.Data;

import java.util.UUID;

@Data
public class ApartmentDto {
    private UUID id;
    private Building building;
    private double price;
    private double superficies;
    private int bedRoom;
    private String address;
    private int ownerId;

}
