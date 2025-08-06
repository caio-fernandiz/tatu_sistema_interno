package com.tatu.sistema.interno.tatu_sistema_interno.user;

public record CustomersUsersDTO( String login, String phone, Boolean loyalCostumer) {
    public CustomersUsersDTO(Users users){
        this(users.getLogin(), users.getPhone(), users.getLoyalCustomer());
    }
}
