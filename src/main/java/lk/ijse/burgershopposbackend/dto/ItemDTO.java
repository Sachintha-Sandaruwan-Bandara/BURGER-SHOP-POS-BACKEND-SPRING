package lk.ijse.burgershopposbackend.dto;

import lk.ijse.burgershopposbackend.customObj.ItemResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ItemDTO implements SuperDTO, ItemResponse {
    private String itemCode;
    private String name;
    private int qty;
    private double unitPrice;

    private String image;

}
