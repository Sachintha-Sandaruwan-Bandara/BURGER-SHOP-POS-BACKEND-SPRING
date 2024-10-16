package lk.ijse.burgershopposbackend.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table
public class CustomerEntity implements SuperEntity{
    @Id
    private String customerId;
    private String name;
    private String address;
    private double salary;
    @Column(columnDefinition = "LONGTEXT")
    private String profilePic;
}
