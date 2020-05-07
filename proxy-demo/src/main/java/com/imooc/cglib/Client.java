package com.imooc.cglib;

import com.imooc.pattern.RealSubject;
import com.imooc.pattern.Subject;
import net.sf.cglib.proxy.Enhancer;

/**
 * Created by cat on 2017-02-27.
 */
public class Client {

    public static void main(String[] args){
        Enhancer enhancer = new Enhancer();
        //生成指定类对象的子类，也就是重写类中的业务函数
        enhancer.setSuperclass(RealSubject.class);
        //这里是回调函数，加入Interceptor()函数
        enhancer.setCallback(new DemoMethodInterceptor());
        //创建这个子类对象
        Subject subject = (Subject) enhancer.create();
        subject.hello();
    }
}
