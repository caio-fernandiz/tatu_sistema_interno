package com.tatu.sistema.interno.tatu_sistema_interno.user;

public enum UserRole {

    EMPLOYEE("employee"),
    CUSTOMER("customer");

    private String role;

    UserRole(String role){
        this.role = role;
    }

    public String getRole(){
        return role;
    }
}
