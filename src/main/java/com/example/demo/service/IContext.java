package com.example.demo.service;

import com.example.demo.product.Fruits;

import java.math.BigDecimal;

/**
 * 优惠接口
 * @param <T>
 */
public interface IContext<T> {

    BigDecimal realPrice(T info, Fruits fruit);
}
