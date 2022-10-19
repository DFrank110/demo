package com.example.demo.service;

import org.springframework.stereotype.Service;

import java.math.BigDecimal;
@Service
public class RebateStrategy implements IStrategy {

    static {

    }

    @Override
    public BigDecimal realPrice(BigDecimal consumePrice) {
        if (consumePrice.compareTo(new BigDecimal(100)) > -1) {
            return consumePrice.subtract((consumePrice.divide(new BigDecimal("100")).setScale(0, BigDecimal.ROUND_DOWN).multiply(new BigDecimal("10"))));
        } else {
            return consumePrice;
        }
    }


}
