package lk.ijse.burgershopposbackend.controller;

import lk.ijse.burgershopposbackend.customObj.CustomerResponse;
import lk.ijse.burgershopposbackend.dto.CustomerDTO;
import lk.ijse.burgershopposbackend.exception.CustomerNotFoundException;
import lk.ijse.burgershopposbackend.exception.DataPersistFailedException;
import lk.ijse.burgershopposbackend.service.CustomerService;
import lk.ijse.burgershopposbackend.util.AppUtil;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/*
    @author 
      
 (                           )   (        (                            )   (                 (               
 )\ )     (         (     ( /(   )\ )     )\ )       (      (       ( /(   )\ )      (       )\ )     (      
(()/(     )\        )\    )\()) (()/(    (()/(     ( )\     )\      )\()) (()/(      )\     (()/(     )\     
 /(_)) ((((_)(    (((_)  ((_)\   /(_))    /(_))    )((_) ((((_)(   ((_)\   /(_))  ((((_)(    /(_)) ((((_)(   
(_))    )\ _ )\   )\___   _((_) (_))     (_))     ((_)_   )\ _ )\   _((_) (_))_    )\ _ )\  (_))    )\ _ )\  
/ __|   (_)_\(_) ((/ __| | || | |_ _|    / __|     | _ )  (_)_\(_) | \| |  |   \   (_)_\(_) | _ \   (_)_\(_) 
\__ \    / _ \    | (__  | __ |  | |     \__ \     | _ \   / _ \   | .` |  | |) |   / _ \   |   /    / _ \   
|___/   /_/ \_\    \___| |_||_| |___|    |___/     |___/  /_/ \_\  |_|\_|  |___/   /_/ \_\  |_|_\   /_/ \_\  
  
 @created 10/12/2024 - 6:31 PM 
*/
@RestController
@RequestMapping("api/v1/customers")
@RequiredArgsConstructor
public class CustomerController {

    @Autowired
    private final CustomerService customerService;

    @GetMapping(value = "/health")
    public String healthCheck() {
        return "customer part is running";
    }

    //  save customer
    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<Void> saveCustomer(

            @RequestParam("name") String name,
            @RequestParam("address") String address,
            @RequestParam("salary") double salary,
            @RequestParam("profilePic") MultipartFile profilePic) {
        try {

            //Handle profile pic
            byte[] imageBytes = profilePic.getBytes();
            String base64ProfilePic = AppUtil.toBase64ProfilePic(imageBytes);
//build customer object
            CustomerDTO buildCustomerDTO = new CustomerDTO();
            buildCustomerDTO.setName(name);
            buildCustomerDTO.setAddress(address);
            buildCustomerDTO.setSalary(salary);
            buildCustomerDTO.setProfilePic(base64ProfilePic);

            //send to the service layer
            customerService.saveCustomer(buildCustomerDTO);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (
                DataPersistFailedException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }


    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCustomer(@PathVariable("id") String id) {

        try {
            customerService.deleteCustomer(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (CustomerNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public CustomerResponse getSelectedCustomer(@PathVariable("id") String id) {
        return customerService.getSelectedCustomer(id);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<CustomerDTO> getAllUsers() {
        return customerService.getAllCustomers();
    }

    @PatchMapping(value = "/{id}", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<Void> updateCustomer(
            @PathVariable("id") String id,
            @RequestParam("name") String name,
            @RequestParam("address") String address,
            @RequestParam("salary") double salary,
            @RequestParam("profilePic") MultipartFile updateProfilePic) {
        try {
//Handle profile pic
            byte[] imageBytes = updateProfilePic.getBytes();
            String base64ProfilePic = AppUtil.toBase64ProfilePic(imageBytes);
//build user object
            CustomerDTO updateCustomerDTO = new CustomerDTO();
            updateCustomerDTO.setCustomerId(id);
            updateCustomerDTO.setName(name);
            updateCustomerDTO.setAddress(address);
            updateCustomerDTO.setSalary(salary);
            updateCustomerDTO.setProfilePic(base64ProfilePic);
            customerService.updateCustomer(updateCustomerDTO);

            return new ResponseEntity<>(HttpStatus.NO_CONTENT);

        } catch (CustomerNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }


    }
}
