package com.hande.repository.entity;

import com.hande.repository.enums.Roles;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Document(indexName = "auth")
public class Auth {
    @Id
    String uId;
    Long id;
    String userName;
    String password;
    Roles role;

}
