package xyz.devyu.corePrinciple.scope;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Scope;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class SingletonWuthPrototypeTest1 {

    @Test
    void prototypeFind() {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(PrototypeBean.class);
        PrototypeBean bean = ac.getBean(PrototypeBean.class);
        bean.addCount();
        System.out.println("요청 1 : " + bean.getCount());
        Assertions.assertThat(bean.getCount()).isEqualTo(1);

        PrototypeBean bean2 = ac.getBean(PrototypeBean.class);
        bean2.addCount();
        System.out.println("요청 2 : " + bean2.getCount());
        Assertions.assertThat(bean2.getCount()).isEqualTo(1);
    }

    @Test
    void singletonClientUsePrototype() {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(ClientBean.class, PrototypeBean.class);
        ClientBean bean1 = ac.getBean(ClientBean.class);
        int logic1 = bean1.logic();
        Assertions.assertThat(logic1).isEqualTo(1);


        ClientBean bean2 = ac.getBean(ClientBean.class);
        int logic2 = bean2.logic();
        Assertions.assertThat(logic2).isEqualTo(2);
    }

    @Scope("singleton")
    static class ClientBean {

        private final PrototypeBean prototypeBean; // 생성 시점에 프로토타입 빈이 주입되어 싱글톤 객체가 지니고 있음. 결국 싱글톤으로 동작

        ClientBean(PrototypeBean prototypeBean) {
            this.prototypeBean = prototypeBean;
        }

        public int logic() {
            prototypeBean.addCount();
            return prototypeBean.getCount();
        }
    }

    @Scope("prototype")
    static class PrototypeBean {
        private int count = 0;

        public void addCount() {
            count++;
        }

        public int getCount() {
            return count;
        }

        @PostConstruct
        public void init() {
            System.out.println("init");
        }

        // 프로토타입 스코프의 경우 호출되지 않음
        @PreDestroy
        public void close() {
            System.out.println("close");
        }

    }

}
