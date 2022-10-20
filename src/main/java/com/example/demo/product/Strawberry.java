package com.example.demo.product;

import com.example.demo.service.IContext;

import java.math.BigDecimal;

/**
 * 草莓
 */
public class Strawberry extends Fruits implements IContext<Double> {

    /**
     * 1.使用商品乘以折扣比例，为最后支付草莓的金额
     * 2.保留2位小数，四舍五入
     * @param info 满减、折扣...
     * @param fruits
     * @return
     */
    @Override
    public BigDecimal realPrice(Double info, Fruits fruits) {
        BigDecimal consumePrice = fruits.getPrice().multiply(fruits.getWeight());
        BigDecimal discountAmount = consumePrice.multiply(new BigDecimal(info)).setScale(2, BigDecimal.ROUND_HALF_UP);
        return discountAmount;
    }
}
