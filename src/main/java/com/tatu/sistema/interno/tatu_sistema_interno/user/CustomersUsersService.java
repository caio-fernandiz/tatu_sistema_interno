package com.tatu.sistema.interno.tatu_sistema_interno.user;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CustomersUsersService {

    @Autowired
    private final UsersRepository usersRepository;

    public CustomersUsersService(UsersRepository usersRepository){
        this.usersRepository = usersRepository;
    }

    public CustomersUsersDTO findByPhone(String phone) {
        
        Optional <Users> user = usersRepository.findByPhone(phone);

        return user.filter(users -> users.getRole() == UserRole.CUSTOMER).map(users -> new CustomersUsersDTO( users.getLogin(), users.getPhone(), users.getLoyalCustomer())).orElseThrow(() -> new RuntimeException("Não encontrado / Não é um cliente"));
    }

    public List<CustomersUsersDTO> findListByRoleCustomer (){
        List <Users> customersUsers = usersRepository.findListByRole(UserRole.CUSTOMER);

        return customersUsers.stream().map(CustomersUsersDTO::new).toList();
    }

    public CustomersUsersDTO updateStatusCostumer(String phone, Boolean loyalCustomer){
        Users users = usersRepository.findByPhone(phone).orElseThrow(() -> new RuntimeException("Cliente não encontrado"));
        users.setLoyalCustomer(loyalCustomer);
        return new CustomersUsersDTO(usersRepository.save(users));
    }
    
}
