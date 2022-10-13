package com.hande.graphql.model;

import lombok.Data;

@Data
public class UserProfileInput {

    Long authId;
    String userName;
    String firstName;
    String lastName;
    String email;
}
