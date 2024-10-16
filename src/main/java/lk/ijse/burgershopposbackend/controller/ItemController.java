package lk.ijse.burgershopposbackend.controller;

import lk.ijse.burgershopposbackend.customObj.CustomerResponse;
import lk.ijse.burgershopposbackend.customObj.ItemResponse;
import lk.ijse.burgershopposbackend.dto.CustomerDTO;
import lk.ijse.burgershopposbackend.dto.ItemDTO;
import lk.ijse.burgershopposbackend.exception.CustomerNotFoundException;
import lk.ijse.burgershopposbackend.exception.DataPersistFailedException;
import lk.ijse.burgershopposbackend.service.CustomerService;
import lk.ijse.burgershopposbackend.service.ItemService;
import lk.ijse.burgershopposbackend.util.AppUtil;
import lombok.RequiredArgsConstructor;
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
  
 @created 10/16/2024 - 2:47 PM 
*/
@RestController
@RequestMapping("api/v1/items")
@RequiredArgsConstructor
public class ItemController {

    @Autowired
    private final ItemService itemService;

    @GetMapping(value = "/health")
    public String healthCheck() {
        return "item part is running";
    }

    //  save item
    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<Void> saveCustomer(

            @RequestParam("name") String name,
            @RequestParam("qty") int qty,
            @RequestParam("unitPrice") double unitPrice,
            @RequestParam("image") MultipartFile image) {
        try {

            //Handle item image
            byte[] imageBytes = image.getBytes();
            String base64Image = AppUtil.toBase64ProfilePic(imageBytes);
//build item object
            ItemDTO buildItemDto = new ItemDTO();
            buildItemDto.setName(name);
            buildItemDto.setQty(qty);
            buildItemDto.setUnitPrice(unitPrice);
            buildItemDto.setImage(base64Image);


            //send to the service layer
            itemService.saveItem(buildItemDto);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (
                DataPersistFailedException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }


    }

    @DeleteMapping("/{code}")
    public ResponseEntity<Void> deleteItem(@PathVariable("code") String code) {

        try {
            itemService.deleteItem(code);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (CustomerNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(value = "/{code}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ItemResponse getSelectedCustomer(@PathVariable("code") String code) {
        return itemService.getSelectedItem(code);
    }
    @GetMapping(value = "allItems", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<ItemDTO> getAllItems() {
        return itemService.getAllItems();
    }

    @PatchMapping(value = "/{code}", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<Void> updateItem(
            @PathVariable("code") String code,
            @RequestParam("name") String name,
            @RequestParam("qty") int qty,
            @RequestParam("unitPrice") double unitPrice,
            @RequestParam("image") MultipartFile updateImage) {
        try {
//Handle image
            byte[] imageBytes = updateImage.getBytes();
            String base64Image = AppUtil.toBase64ProfilePic(imageBytes);
//build item object

            ItemDTO updatedItemDto = new ItemDTO();
            updatedItemDto.setItemCode(code);
            updatedItemDto.setName(name);
            updatedItemDto.setQty(qty);
            updatedItemDto.setUnitPrice(unitPrice);
            updatedItemDto.setImage(base64Image);
            itemService.updateItem(updatedItemDto);

            return new ResponseEntity<>(HttpStatus.NO_CONTENT);

        } catch (CustomerNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }


    }

}
