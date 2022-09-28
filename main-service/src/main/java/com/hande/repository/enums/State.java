package com.hande.repository.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public enum State {

    PASIF(0),
    WAITING(1),
    APPROVED(2),
    DELETED(3),
    BLOCKED(4);

    private int value;
}
