package com.imooc.service.sub;

import com.imooc.service.ProductService;
import org.springframework.stereotype.Component;

/**
 * Created by zyy on 2020-04-22.
 */
@Component
public class SubService extends ProductService{

    public void demo(){
        System.out.println("execute sub service method");
    }
}
