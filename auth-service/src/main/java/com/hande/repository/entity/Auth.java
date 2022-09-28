package com.hande.repository.entity;

import com.hande.repository.enums.Roles;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Table(name="auth")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Auth {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String userName;
    String password;
    @Enumerated(EnumType.STRING)
    Roles role;

}
