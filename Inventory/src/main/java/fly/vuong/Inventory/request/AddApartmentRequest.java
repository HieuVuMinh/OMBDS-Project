package fly.vuong.Inventory.request;

import fly.vuong.Inventory.entities.Building;
import lombok.Data;

@Data
public class AddApartmentRequest {
    private Building building;
    private double price;
    private double superficies;
    private int bedRoom;
    private String address;
    private int ownerId;
    private boolean status;
}
