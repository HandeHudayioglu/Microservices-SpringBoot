package com.hande.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class NewUserCreateDto {

                                                                                                                                                                                           //yeni üyelik açmış birisinin auth id bilgisinin tutulduğu alan
    Long authId;
    String userName;
    String email;
}
