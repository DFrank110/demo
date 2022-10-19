package com.example.demo.product;

import com.example.demo.service.IStrategy;

import java.math.BigDecimal;

public class Apple extends Fruits implements IStrategy {

    @Override
    public BigDecimal realPrice(BigDecimal consumePrice) {
        return consumePrice;
    }
}
