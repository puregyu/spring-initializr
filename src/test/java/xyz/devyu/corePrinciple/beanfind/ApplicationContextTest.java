package xyz.devyu.corePrinciple.beanfind;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import xyz.devyu.corePrinciple.AppConfig;

import javax.naming.Name;
import java.util.Arrays;

public class ApplicationContextTest {

    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

    @Test
    @DisplayName("모든 빈 출력하기")
    void findAllBean() {
        String[] beanDefinitionNames = ac.getBeanDefinitionNames();
        Arrays.stream(beanDefinitionNames).forEach(s -> {
            Object bean = ac.getBean(s);
            System.out.println(s + " || " + bean);
        });
    }

    @Test
    @DisplayName("애플리케이션 빈 출력하기")
    void findApplicationBean() {
        String[] beanDefinitionNames = ac.getBeanDefinitionNames();
        Arrays.stream(beanDefinitionNames).forEach(s -> {
            BeanDefinition bean = ac.getBeanDefinition(s);

            // ROLE == 개발자가 직접 등록한 application bean
            if (bean.getRole() == BeanDefinition.ROLE_APPLICATION) {
                System.out.println(s + " || " + bean);
            }
        });
    }
}
