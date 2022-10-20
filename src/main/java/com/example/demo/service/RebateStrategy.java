package com.example.demo.service;

import com.example.demo.product.Fruits;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
@Service
public class RebateStrategy implements IContext {

    static {

    }

    /**
     * 满100减10元，满200减20
     * @param info
     * @param fruits
     * @return
     */
    @Override
    public BigDecimal realPrice(Object info, Fruits fruits) {
        BigDecimal consumePrice = fruits.getPrice();
        if (consumePrice.compareTo(new BigDecimal(100)) > -1) {
            return consumePrice.subtract((consumePrice.divide(new BigDecimal("100")).setScale(0, BigDecimal.ROUND_DOWN).multiply(new BigDecimal("10"))));
        } else {
            return consumePrice;
        }
    }
}
