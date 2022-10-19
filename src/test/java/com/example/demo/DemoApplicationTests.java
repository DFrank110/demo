package com.example.demo;

import com.example.demo.consumption.Customer;
import com.example.demo.exception.CustomException;
import com.example.demo.product.Apple;
import com.example.demo.product.Fruits;
import com.example.demo.product.Mango;
import com.example.demo.product.Strawberry;
import com.example.demo.service.FruitContext;
import com.example.demo.service.RebateStrategy;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@SpringBootTest
class DemoApplicationTests {

    List<Fruits> list = new ArrayList<>();
    private static Fruits apple;
    private static Fruits strawberry;
    private static Fruits mango ;
     static {
         apple = new Apple();
         apple.setPrice(new BigDecimal("8"));
         strawberry = new Strawberry();
         strawberry.setPrice(new BigDecimal("13"));
         mango = new Mango();
         mango.setPrice(new BigDecimal("20"));
     }
    @Test
    void contextLoads() throws CustomException{
        Scanner input = new Scanner(System.in);
        System.out.println("请输入购物类型：数字1 2 3 4 分别对应面试1 2 3 4题");
        BigDecimal inputParam = input.nextBigDecimal();// 读取输入的整数
        String m = "^[1|2|3|4]$";
        boolean flag = inputParam.toString().matches(m);
        if (!flag) {
            throw new CustomException("输入的方案不对");
        }
        if (inputParam.toPlainString().equals("1")) {
            System.out.println("【苹果 8 元/斤，草莓 13 元/斤】");
            customerA();
        } else if (inputParam.toPlainString().equals("2")) {
            System.out.println("【苹果 8 元/斤，草莓 13 元/斤，芒果 20 元/斤】");
            customerB();
        } else if (inputParam.toPlainString().equals("3")) {
            System.out.println("【苹果 8 元/斤，草莓 13 元/斤，芒果 20 元/斤， 草莓限时打 8 折】");
            customerC();
        } else {
            System.out.println("【苹果 8 元/斤，草莓 13 元/斤，芒果 20 元/斤， 草莓限时打 8 折， 满 100 减 10 块】");
            customerD();
        }
    }

    @Test
    void customerA() throws CustomException {
        Scanner input = new Scanner(System.in);
        System.out.println("请输入苹果重量：");
        BigDecimal appleWeight = input.nextBigDecimal();// 读取输入的整数
        System.out.println("请输入草莓重量：");
        BigDecimal strawberryWeight = input.nextBigDecimal();
        String sumStr = appleWeight.add(strawberryWeight).stripTrailingZeros().toPlainString();
        String m = "[0-9]*";
        boolean flag = sumStr.matches(m);
        if (!flag) {
            throw new CustomException("输入的水果总和不是正整数。");
        }
        apple.setWeight(appleWeight);
        strawberry.setWeight(strawberryWeight);
        Customer a  = new Customer();
        List<Fruits> buyList = new ArrayList<>();
        buyList.add(apple);
        buyList.add(strawberry);
        BigDecimal prepaidAmount = a.pay(buyList);
        System.out.println("合计总价：" + prepaidAmount.toPlainString() + " 元");
    }

    @Test
    void customerB() throws CustomException {
        Scanner input = new Scanner(System.in);
        System.out.println("请输入苹果重量：");
        BigDecimal appleWeight = input.nextBigDecimal();// 读取输入的整数
        System.out.println("请输入草莓重量：");
        BigDecimal strawberryWeight = input.nextBigDecimal();
        System.out.println("请输入芒果重量：");
        BigDecimal mangoWeight = input.nextBigDecimal();
        String sumStr = appleWeight.add(strawberryWeight).stripTrailingZeros().toPlainString();
        String m = "[0-9]*";
        boolean flag = sumStr.matches(m);
        if (!flag) {
            throw new CustomException("输入的水果总和不是正整数。");
        }
        apple.setWeight(appleWeight);
        strawberry.setWeight(strawberryWeight);
        mango.setWeight(mangoWeight);
        Customer a  = new Customer();
        List<Fruits> buyList = new ArrayList<>();
        buyList.add(apple);
        buyList.add(strawberry);
        buyList.add(mango);
        BigDecimal prepaidAmount = a.pay(buyList);
        System.out.println("合计总价：" + prepaidAmount.toPlainString() + " 元");
        FruitContext fruitContext = new FruitContext(new Apple());

    }

    @Test
    void customerC() throws CustomException {
        Scanner input = new Scanner(System.in);
        System.out.println("请输入苹果重量：");
        BigDecimal appleWeight = input.nextBigDecimal();// 读取输入的整数
        System.out.println("请输入草莓重量：");
        BigDecimal strawberryWeight = input.nextBigDecimal();
        System.out.println("请输入芒果重量：");
        BigDecimal mangoWeight = input.nextBigDecimal();
        String sumStr = appleWeight.add(strawberryWeight).stripTrailingZeros().toPlainString();
        String m = "[0-9]*";
        boolean flag = sumStr.matches(m);
        if (!flag) {
            throw new CustomException("输入的水果总和不是正整数。");
        }
        apple.setWeight(appleWeight);
        strawberry.setWeight(strawberryWeight);
        strawberry.setRate(new BigDecimal("0.8"));
        mango.setWeight(mangoWeight);
        Customer a  = new Customer();
        List<Fruits> buyList = new ArrayList<>();
        buyList.add(apple);
        buyList.add(strawberry);
        buyList.add(mango);
        BigDecimal prepaidAmount = a.pay(buyList);
        System.out.println("合计总价：" + prepaidAmount.toPlainString() + " 元");
    }

    @Test
    void customerD() throws CustomException {
        Scanner input = new Scanner(System.in);
        System.out.println("请输入苹果重量：");
        BigDecimal appleWeight = input.nextBigDecimal();// 读取输入的整数
        System.out.println("请输入草莓重量：");
        BigDecimal strawberryWeight = input.nextBigDecimal();
        System.out.println("请输入芒果重量：");
        BigDecimal mangoWeight = input.nextBigDecimal();
        String sumStr = appleWeight.add(strawberryWeight).stripTrailingZeros().toPlainString();
        String m = "[0-9]*";
        boolean flag = sumStr.matches(m);
        if (!flag) {
            throw new CustomException("输入的水果总和不是正整数。");
        }
        apple.setWeight(appleWeight);
        strawberry.setWeight(strawberryWeight);
        strawberry.setRate(new BigDecimal("0.8"));
        mango.setWeight(mangoWeight);
        Customer a  = new Customer();
        List<Fruits> buyList = new ArrayList<>();
        buyList.add(apple);
        buyList.add(strawberry);
        buyList.add(mango);
        BigDecimal prepaidAmount = a.pay(buyList);
        RebateStrategy rebate = new RebateStrategy();
        BigDecimal actualPayment =  rebate.realPrice(prepaidAmount);
        System.out.println("合计总价：" + actualPayment.toPlainString() + " 元");
    }

    @Test
    void testFruits1() throws CustomException {
        Scanner input = new Scanner(System.in);
        System.out.println("请输入苹果重量：");
        BigDecimal appleWeight = input.nextBigDecimal();// 读取输入的整数
        System.out.println("请输入草莓重量：");
        BigDecimal strawberryWeight = input.nextBigDecimal();
        System.out.println("请输入芒果重量：");
        BigDecimal mangoWeight = input.nextBigDecimal();
        String sumStr = appleWeight.add(strawberryWeight).stripTrailingZeros().toPlainString();
        String m = "[0-9]*";
        boolean flag = sumStr.matches(m);
        if (!flag) {
           throw new CustomException("输入的水果总和不是正整数。");
        }
        apple.setWeight(appleWeight);
        strawberry.setWeight(strawberryWeight);
        Customer c  = new Customer();
        List<Fruits> buyList = new ArrayList<>();
        buyList.add(apple);
        buyList.add(strawberry);
        BigDecimal prepaidAmount = c.pay(buyList);
        RebateStrategy rebate = new RebateStrategy();
        BigDecimal actualPayment =  rebate.realPrice(prepaidAmount);
        System.out.println(actualPayment.toPlainString());
    }
    public static void main(String[] args)throws CustomException {
        DemoApplicationTests test =new DemoApplicationTests();
        while(true) {
            System.out.println("-----------------------------------------------------");
            test.contextLoads();
            System.out.println("-----------------------------------------------------");
        }

    }
}
