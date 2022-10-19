package com.example.demo.service;

import java.math.BigDecimal;

/**
 * 上下文类，相当于收银台
 */
public class FruitContext{
    private IStrategy iStrategy;

    public FruitContext (IStrategy iStrategy) {
       this.iStrategy = iStrategy;
    }

    public BigDecimal out(BigDecimal price) {
       return this.iStrategy.realPrice(price);
    }

}
