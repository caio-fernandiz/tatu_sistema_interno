package com.tatu.sistema.interno.tatu_sistema_interno.user;

public record CustomersUsersDTO(String id, String login, String phone, Boolean loyalCostumer) {
    public CustomersUsersDTO(Users users){
        this(users.getId(), users.getLogin(), users.getPhone(), users.getLoyalCustomer());
    }
}
