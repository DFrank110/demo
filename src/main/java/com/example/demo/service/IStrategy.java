package com.example.demo.service;

import java.math.BigDecimal;

/**
 * 策略模式
 */
public interface IStrategy {
    //计算实际价格方法
    public BigDecimal realPrice(BigDecimal consumePrice);
}
