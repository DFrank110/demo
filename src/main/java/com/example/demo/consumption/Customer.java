package com.example.demo.consumption;

import com.example.demo.product.Fruits;
import org.springframework.util.CollectionUtils;

import java.math.BigDecimal;
import java.util.List;

/**
 * 客户
 */
public class Customer {

    public BigDecimal pay(List<Fruits> fruits){
        if(CollectionUtils.isEmpty(fruits)){

            return BigDecimal.ZERO;
        }
        BigDecimal sum = BigDecimal.ZERO;
        for (Fruits fruit: fruits) {
            sum = sum.add(fruit.getPrice().multiply(fruit.getWeight()).multiply(fruit.getRate()));
        }
        return sum;
    }

    public BigDecimal paySum(List<BigDecimal> fruits){
        if(CollectionUtils.isEmpty(fruits)){
            return BigDecimal.ZERO;
        }
        BigDecimal sum = BigDecimal.ZERO;
        for (BigDecimal price: fruits) {
            sum = sum.add(price);
        }
        return sum;
    }
}
