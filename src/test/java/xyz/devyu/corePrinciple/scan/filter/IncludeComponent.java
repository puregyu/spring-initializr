package xyz.devyu.corePrinciple.scan.filter;

import java.lang.annotation.*;

@Target(ElementType.TYPE) // class level
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface IncludeComponent {
}
