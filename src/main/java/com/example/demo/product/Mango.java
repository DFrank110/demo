package com.example.demo.product;

import com.example.demo.service.IStrategy;

import java.math.BigDecimal;

/**
 * 满过
 */
public class Mango extends Fruits implements IStrategy {
    @Override
    public BigDecimal realPrice(BigDecimal consumePrice) {
        return consumePrice;
    }
}
