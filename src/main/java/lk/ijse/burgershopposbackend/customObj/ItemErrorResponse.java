package lk.ijse.burgershopposbackend.customObj;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
@NoArgsConstructor
@AllArgsConstructor
@Data
public class ItemErrorResponse implements Serializable, ItemResponse{
    private int errorCode;
    private String errorMessage;
}
