package com.example.demo.product;

import com.example.demo.service.IContext;

import java.math.BigDecimal;
import java.util.Map;

/**
 * 满减
 */
public class FullDecrement extends Fruits implements IContext<Map<String, String>> {

    /**
     * 1.判断满足x元后-n元，否则不减
     * @param info 满减、折扣...
     * @param fruits
     * @return
     */
    @Override
    public BigDecimal realPrice(Map<String, String> info, Fruits fruits) {
        String x = info.get("x");
        String n = info.get("n");
        BigDecimal consumePrice = fruits.getPrice();
        // 小于商品金额条件的，直接返回商品原价
        if (consumePrice.compareTo(new BigDecimal(x)) < 0) {
            return consumePrice;
        }
        // 减去优惠金额判断
        BigDecimal discountAmount = consumePrice.subtract(new BigDecimal(n));
        return discountAmount;
    }
}
