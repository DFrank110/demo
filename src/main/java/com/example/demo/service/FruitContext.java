package com.example.demo.service;

import com.example.demo.product.Fruits;

import java.math.BigDecimal;

/**
 * 上下文类
 */
public class FruitContext<T>{
    private IContext context;

    public FruitContext (IContext<T> context) {
       this.context = context;
    }

    public BigDecimal out(T info, Fruits fruit) {
       return this.context.realPrice(info, fruit);
    }

}
