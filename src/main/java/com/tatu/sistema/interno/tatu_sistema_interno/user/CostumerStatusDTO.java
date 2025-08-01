package com.tatu.sistema.interno.tatu_sistema_interno.user;

public record CostumerStatusDTO(String id, Boolean loyalCostumer) {
    public CostumerStatusDTO(Users users){
        this(users.getId(), users.getLoyalCostumer());
    }
}
