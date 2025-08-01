package com.tatu.sistema.interno.tatu_sistema_interno.user;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.tatu.sistema.interno.tatu_sistema_interno.appointments.Appointments;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
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
public class Users implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private String login;
    private String password;
    private UserRole role = UserRole.COSTUMER;
    private Boolean loyalCostumer = false;

    public Users(String login, String password){
        this.login = login;
        this.password = password;
    }

    @OneToMany(mappedBy = "user")
    private List<Appointments> appointments;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        if (this.role == UserRole.EMPLOYEE)
            return List.of(new SimpleGrantedAuthority("ROLE_EMPLOYEE"), new SimpleGrantedAuthority("ROLE_COSTUMER"));
        else
            return List.of(new SimpleGrantedAuthority("ROLE_COSTUMER"));
    }

    @Override
    public String getUsername() {
        return login;
    }
}
