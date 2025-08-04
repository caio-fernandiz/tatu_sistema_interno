package com.tatu.sistema.interno.tatu_sistema_interno.user;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
@CrossOrigin("*")
@RequestMapping("/costumers")
public class CosturmersUsersController {

    private final CostumerUsersService costumerUsersService;

    public CosturmersUsersController(CostumerUsersService costumerUsersService){
        this.costumerUsersService = costumerUsersService;        
    }


    @PutMapping("loyal-status/{phone}")
    public ResponseEntity<CostumersUsersDTO> updateStatusCostumer (@PathVariable String phone, @RequestBody Boolean loyalCostumer) {
        
        CostumersUsersDTO updateStatusCostumer = costumerUsersService.updateStatusCostumer(phone, loyalCostumer);
        
        return new ResponseEntity<>(updateStatusCostumer, HttpStatus.OK);
    }
}
