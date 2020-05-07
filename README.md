#基本介绍
###Pointcut expression (切面表达式)
 
主要有三个方面组成：
1. designators(指示器)
    1. 匹配方法 execution()
    2. 匹配注释 
        1. @target()
        2. @args()
        3. @within()
        4. @annotation()
    3. 匹配包、类型 withi()
    4. 匹配对象 
        1. this()
        2. bean()
        3. target()
    5. 匹配参数 args()
2. wildcards （通配符）
    1. " * " 匹配任意数量的字符
    2. " .. "
    3. " + " 匹配指定类及其子类
3. operators (运算符)
    1. " && " 与操作
    2. "|| " 或操作
    3. " ! "  非操作
   
###使用简介
####within（）
匹配某个类
---
```$xslt
 @Pointcut("within(com.imooc.service.ProductService)")
    public void matchType(){}

    @Before("matchType()")
    public void before(){
        System.out.println("");
        System.out.println("###before");
    }
```
匹配某个包下面所有类
---
```$xslt
 @Pointcut("within(com.imooc.service.*)")
    public void matchType(){}

    @Before("matchType()")
    public void before(){
        System.out.println("");
        System.out.println("###before");
    }
```
####this(),target(),bean()
拦截指定的类或者接口

*this()与target()可以拦截指定的类与实现指定接口内的方法*

1：
---
```
   @Pointcut("this(com.imooc.log.Loggable)")
   public void matchCondition(){}

    @Before("matchCondition()")
    public void before(){
        System.out.println("");
        System.out.println("matchCondition ###before");
    }
```
2：
---
```
    @Pointcut("target(com.imooc.log.Loggable)")
    public void matchCondition(){}

    @Before("matchCondition()")
    public void before(){
        System.out.println("");
        System.out.println("matchCondition ###before");
    }
```
3： bean()只能拦截指定类，不能拦截接口的实现类，支持模糊匹配
---
```
    @Pointcut("bean(*Service)")
    public void matchCondition(){}

    @Before("matchCondition()")
    public void before(){
        System.out.println("");
        System.out.println("matchCondition ###before");
    }
```
#### 参数匹配 args()
匹配单个参数或多个参数
*支持运算符*

1: 单个参数的智慧匹配单个参数，不会匹配包含的多参数方法。
---
```  @Pointcut("args(Long)")
       public void matchArgs(){}
   
       @Before("matchArgs()")
       public void before(){
           System.out.println("");
           System.out.println("matchArgs ###before");
       }
```
2: 多个参数的只会按顺序匹配多个参数，不会匹配包含的单参数方法。
---
```  @Pointcut("args(Long,String)")
       public void matchArgs(){}
   
       @Before("matchArgs()")
       public void before(){
           System.out.println("");
           System.out.println("matchArgs ###before");
       }
```
3: 使用运算符&&匹配指定目录下所有首个参数为Long的方法。
---
```$xslt
  @Pointcut("args(Long) && within(com.imooc.service.*)")
    public void matchArgs(){}

    @Before("matchArgs()")
    public void before(){
        System.out.println("");
        System.out.println("matchArgs ###before");
    }
```
#### 注解匹配annotation()，@within()，@target(),@args()
匹配单个参数或多个参数
*支持运算符*

1：annotation（）,使用到指定注解的方法被拦截
---
```$xslt
    @Pointcut("@annotation(com.imooc.anno.AdminOnly) ")
    public void matchAnno(){}

    @Before("matchAnno()")
    public void before() {
        System.out.println("");
        System.out.println("matchAnno###before");
    }

    @AdminOnly
    public void log() {
        System.out.println("LogService log from LogService");
    }
```
2：@within()，@target(),使用到指定注解的类被拦截，可以被继承
---
```$xslt
    @Pointcut("@within(com.imooc.anno.NeedSecured) && within(com.imooc..*)")
        public void matchAnno() {
        }

   // @Pointcut("@target(com.imooc.anno.NeedSecured) && within(com.imooc..*)")
   //     public void matchAnno() {
   //     }

    @Before("matchAnno()")
    public void before() {
        System.out.println("");
        System.out.println("matchAnno###before");
    }

```
3：@args(),在需要被拦截的model上使用该注解，使用该model作为传参的方法会被拦截。
---
```$xslt
    @Pointcut("@args(com.imooc.anno.NeedSecured) && within(com.imooc..*)")
        public void matchAnno(){}

    @Before("matchAnno()")
    public void before() {
        System.out.println("");
        System.out.println("matchAnno###before");
    }

    @NeedSecured
    public class Product {
    }
    public void annoArg(Product product){
        System.out.println("LogService execute log service annoArg");
    }

```
#### 5种Advice注解
1:@Before 前置通知

2:@After(finally) 后置通知，方法执行完成之后(成功失败都会执行)

3:@AfterReturning  返回通知，成功执行之后

4:@AfterTrowing 异常通知，抛出异常之后

5:@Around 环绕通知

###织入的时机 
1: 编译期（AspectJ）
2: 类加载时（AspectJ 5+）
3: 运行时（Spring AOP）
 详情见proxy-demo目录内README.md