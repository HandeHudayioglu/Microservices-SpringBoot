package com.hande.repository.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Table(name = "user_profile")
@Entity
public class UserProfile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    Long authId;
    String userName;
    String firstName;
    String lastName;
    String email;
    String phone;
    String photo;
    @Column(length = 1000)
    String address;
    @Column(length = 5000)
    String about;
    Long created;
    Long updated;
    boolean isActive;

}
