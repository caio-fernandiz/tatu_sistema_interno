package com.tatu.sistema.interno.tatu_sistema_interno.user;

import org.springframework.stereotype.Service;

@Service
public class UsersCostumerService {

    private final UsersRepository usersRepository;

    public UsersCostumerService(UsersRepository usersRepository){
        this.usersRepository = usersRepository;
    }

    public CostumersUsersDTO updateStatusCostumer(String id, Boolean loyalCostumers){
        Users users = usersRepository.findById(id).orElseThrow(() -> new RuntimeException("Cliente não encontrado"));
        users.setLoyalCostumer(loyalCostumers);
        return new CostumersUsersDTO(usersRepository.save(users));
    }

    
}
