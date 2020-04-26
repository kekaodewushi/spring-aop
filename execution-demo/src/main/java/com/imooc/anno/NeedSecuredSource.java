package com.imooc.anno;

import java.lang.annotation.*;

/**
 * Created by zyy on 2020-04-22.
 */
@Retention(RetentionPolicy.SOURCE)
@Target(ElementType.TYPE)
@Inherited
public @interface NeedSecuredSource {
}
