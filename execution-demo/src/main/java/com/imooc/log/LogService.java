package com.imooc.log;

import com.imooc.anno.AdminOnly;
import com.imooc.bean.Product;
import org.springframework.stereotype.Component;

/**
 * Created by zyy on 2020-04-22.
 */
@Component
public class LogService implements Loggable{
    @Override
    @AdminOnly
    public void log() {
        System.out.println("LogService log from LogService");
    }

    public void annoArg(Product product){
        System.out.println("LogService execute log service annoArg");
    }
}
