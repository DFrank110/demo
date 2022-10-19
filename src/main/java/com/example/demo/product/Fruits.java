package com.example.demo.product;

import java.math.BigDecimal;

/**
 * 水果基类
 */
public abstract class Fruits {

    //价格
    private BigDecimal price;
    //重量
    private BigDecimal weight;
    //打折
    private BigDecimal rate = new BigDecimal(1);
    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getWeight() {
        return weight;
    }

    public void setWeight(BigDecimal weight) {
        this.weight = weight;
    }

    public BigDecimal getRate() {
        return rate;
    }

    public void setRate(BigDecimal rate) {
        this.rate = rate;
    }

    @Override
    public String toString() {
        return "Fruits{" +
                "price=" + price +
                ", weight=" + weight +
                ", rate=" + rate +
                '}';
    }
}
