package xyz.devyu.corePrinciple.annotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;

import java.lang.annotation.*;

@Target({ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER, ElementType.TYPE, ElementType.ANNOTATION_TYPE}) // class level
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
@Qualifier("mainDiscountPolicy")
public @interface MainDisCountPolicy {
//    // 의존성 자동주입이 Type이 동일해서 중복될 경우, 3가지 방법이 있다.
//    1. @Autowired를 사용하는 방법
//            - 타입이 중복되는 경우, 타입은 동일하지만 파라미터 또는 필드 명을 변경하면 됨.
//    2. @Qualifier를 사용하는 방법
//            - 애노테이션을 이용하여, 별칭을 준다. 사용하는 쪽과 생성되는 쪽 모두 만들어줘야 함.
//            - String 문자열로 별칭을 주기 때문에 실수할 가능성이 생김. 위처럼 애노테이션을 만들어서 사용할 수 있음.
//    3. @Primary를 사용하는 방법
//            - 애노테이션을 이용하여, 우선권을 준다. 생성하는 쪽에만 작업해주면 된다.
}
