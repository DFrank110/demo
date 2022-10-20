package com.example.demo.product;

import com.example.demo.service.IContext;

import java.math.BigDecimal;

public class Apple extends Fruits implements IContext<Double> {

    /**
     * 原价
     * 四舍五入保留2位小数
     * @param info
     * @param fruits
     * @return
     */
    @Override
    public BigDecimal realPrice(Double info, Fruits fruits) {
        return fruits.getPrice().multiply(fruits.getWeight()).setScale(2, BigDecimal.ROUND_HALF_UP);
    }
}
