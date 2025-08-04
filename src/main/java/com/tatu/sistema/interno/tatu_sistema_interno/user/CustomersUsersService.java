package com.tatu.sistema.interno.tatu_sistema_interno.user;

import java.util.List;

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

    public  List<CustomersUsersDTO> findListByRoleCustomer (){
        List <Users> customersUsers = usersRepository.findListByRole(UserRole.CUSTOMER);

        return customersUsers.stream().map(users -> new CustomersUsersDTO(users.getId(), users.getLogin(), users.getPhone(), users.getLoyalCustomer())).toList();
    }
    
}
