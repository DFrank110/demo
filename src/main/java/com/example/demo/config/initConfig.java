package com.example.demo.config;

import com.example.demo.product.Fruits;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
@Slf4j
public class initConfig implements ApplicationContextAware {

    public static HashMap<String,Fruits> FruitsMap = new HashMap<String,Fruits>(8);
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        Map<String,Fruits> map = applicationContext.getBeansOfType(Fruits.class);
        map.forEach((String key ,Fruits fruit) ->{
            log.info("key:"+key,",value = "+fruit.getClass());
        });
    }
}
