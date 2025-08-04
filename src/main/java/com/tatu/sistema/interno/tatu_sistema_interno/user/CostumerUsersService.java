package com.tatu.sistema.interno.tatu_sistema_interno.user;

import org.springframework.stereotype.Service;

@Service
public class CostumerUsersService {

    private final UsersRepository usersRepository;

    public CostumerUsersService(UsersRepository usersRepository){
        this.usersRepository = usersRepository;
    }

    public CostumersUsersDTO updateStatusCostumer(String phone, Boolean loyalCostumers){
        Users users = usersRepository.findByPhone(phone).orElseThrow(() -> new RuntimeException("Cliente não encontrado"));
        users.setLoyalCostumer(loyalCostumers);
        return new CostumersUsersDTO(usersRepository.save(users));
    }


    
}
