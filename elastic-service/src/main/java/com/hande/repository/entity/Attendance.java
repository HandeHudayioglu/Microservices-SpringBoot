package com.hande.repository.entity;



import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;


@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class Attendance {

    @Id
    String uId;
    Long id;
    Long userId;
    Long yarismaId;
    Long date;
    TableAdd tableAdd;
}
