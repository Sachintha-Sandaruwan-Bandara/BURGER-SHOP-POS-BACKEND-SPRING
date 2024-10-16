package lk.ijse.burgershopposbackend.dto;


import lk.ijse.burgershopposbackend.customObj.CustomerResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class CustomerDTO implements SuperDTO, CustomerResponse {
    private String customerId;
    private String name;
    private String address;
    private double salary;
    private String profilePic;
}
