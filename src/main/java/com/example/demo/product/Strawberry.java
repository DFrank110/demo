package com.example.demo.product;

import com.example.demo.service.IStrategy;

import java.math.BigDecimal;

/**
 * 草莓
 */
public class Strawberry extends Fruits implements IStrategy {

    @Override
    public BigDecimal realPrice(BigDecimal consumePrice) {
        return consumePrice.multiply(BigDecimal.valueOf(0.8));
    }
}
