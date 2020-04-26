package com.imooc.config;

import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/**
 * //匹配ProductService类里头的所有方法
 * @Pointcut("within(com.imooc.service.ProductService)")
 * //匹配com.imooc包及子包下所有类的方法
 * @Pointcut("within(com.imooc..*)")
 * Created by zyy on 2020-04-22.
 */
@Aspect
@Component
public class PkgTypeAspectConfig {
//    @Pointcut("within(com.imooc.service.ProductService)")
//    public void matchType(){}
//
//    @Before("matchType()")
//    public void before(){
//        System.out.println("");
//        System.out.println("matchType ###before");
//    }
}
