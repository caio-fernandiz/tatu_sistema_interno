package com.tatu.sistema.interno.tatu_sistema_interno.user;

import org.springframework.stereotype.Service;

@Service
public class CustomersUsersService {

    private final UsersRepository usersRepository;

    public CustomersUsersService(UsersRepository usersRepository){
        this.usersRepository = usersRepository;
    }

    public CustomersUsersDTO updateStatusCostumer(String phone, Boolean loyalCustomer){
        Users users = usersRepository.findByPhone(phone).orElseThrow(() -> new RuntimeException("Cliente não encontrado"));
        users.setLoyalCustomer(loyalCustomer);
        return new CustomersUsersDTO(usersRepository.save(users));
    }

    public CustomersUsersDTO findByCostumers(UserRole role){

   

        return null;
    }
    
}
