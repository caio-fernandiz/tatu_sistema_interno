package com.tatu.sistema.interno.tatu_sistema_interno.user;

public record CostumersUsersDTO(String id, String login, Boolean loyalCostumer) {
    public CostumersUsersDTO(Users users){
        this(users.getId(), users.getLogin(), users.getLoyalCostumer());
    }
}
