package com.tatu.sistema.interno.tatu_sistema_interno.user;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.GetMapping;





@RestController
@CrossOrigin("*")
@RequestMapping("/customers")
public class CustomersUsersController {

    private final CustomersUsersService customerUsersService;

    public CustomersUsersController(CustomersUsersService customerUsersService){
        this.customerUsersService = customerUsersService;        
    }

    @GetMapping("show/{phone}")
    public ResponseEntity <CustomersUsersDTO> findByPhone (@PathVariable String phone) {
        CustomersUsersDTO users = customerUsersService.findByPhone(phone);
        return new ResponseEntity<>(users, HttpStatus.OK);
    }
    

    @GetMapping("show/all")
    public ResponseEntity<List<CustomersUsersDTO>> findListByRoleCustomer() {
        List<CustomersUsersDTO> users = customerUsersService.findListByRoleCustomer();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }
    

    @PutMapping("loyal-status/{phone}")
    public ResponseEntity<CustomersUsersDTO> updateStatusCostumer (@PathVariable String phone, @RequestBody Boolean loyalCostumer) {
        
        CustomersUsersDTO updateStatusCostumer = customerUsersService.updateStatusCostumer(phone, loyalCostumer);
        
        return new ResponseEntity<>(updateStatusCostumer, HttpStatus.OK);
    }
}
