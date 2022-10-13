package com.hande.repository.entity;


import com.hande.repository.enums.State;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;



@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Views {


        @Id
        String uId;
        Long id;
        Long userId;
        Long soruId;
        Long date;

        //@Builder.Default
        State state;

        TableAdd tableAdd;

    }

