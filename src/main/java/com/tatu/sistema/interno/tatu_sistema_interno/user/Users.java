package com.tatu.sistema.interno.tatu_sistema_interno.user;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Table(name = "users")
@Entity(name = "users")
@AllArgsConstructor
@NoArgsConstructor
@Data
@EqualsAndHashCode(of = "id")
public class Users implements UserDetails{

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private Long id;
    private String login;
    private String password;
    private UserRole role;
    private Boolean loyalCostumer;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        if(this.role == UserRole.EMPLOYEE) return List.of(new SimpleGrantedAuthority("ROLE_EMPLOYEE"), new SimpleGrantedAuthority("ROLE_COSTUMER"));
        else return List.of(new SimpleGrantedAuthority("ROLE_COSTUMERlogin"));
    }

    @Override
    public String getUsername() {
        return login;
    }
}
