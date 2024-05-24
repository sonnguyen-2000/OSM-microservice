package com.codegym.cglmsorderservice.domain.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public enum Payment {
    CASH,
    CREDIT_CARD,
    BANK_TRANSFER,
    E_WALLET,
    COD;
}
