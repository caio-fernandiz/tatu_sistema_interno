package com.tatu.sistema.interno.tatu_sistema_interno.infra;

import com.tatu.sistema.interno.tatu_sistema_interno.user.UserRole;

public record RegisterDTO(String login, String password, UserRole role) {

}
