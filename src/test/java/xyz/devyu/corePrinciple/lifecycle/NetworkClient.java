package xyz.devyu.corePrinciple.lifecycle;

import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Slf4j
public class NetworkClient implements InitializingBean, DisposableBean {

    @Setter
    private String url;

    public NetworkClient() {
        log.info("생성자 호출, url = {}", url);
//        connect();
//        call("생성 메세지 전달");
     }

    // 서비스 시작 시
    public void connect() {
        log.info("connect : {}", url);
    }

    // 서비스 종료 시
    public void disconnect() {
        log.info("disconnect : {}", url);
    }

    public void call(String message) {
        log.info("call : {}, message : {}", url, message);
    }

    /**
     * 과거 방식
     * InitializingBean, DisposableBean 를 구현해서 빈의 생성과 소멸 시 메소드 호출
     *
     */
    // 의존관계 주입이 끝나면 호출되는 메소드
    @Override
    public void afterPropertiesSet() throws Exception {
        connect();
        call("생성 메세지 전달");
    }

    // 빈이 종료될때 호출되는 메소드
    @Override
    public void destroy() throws Exception {
        disconnect();
    }

    /**
     * 현대 방식
     * 애노테이션을 사용하여 빈의 생성과 소멸 시 메소드 호출
     *
     */
    // 의존관계 주입이 끝나면 호출되는 메소드
    public void init() {
        connect();
        call("생성 메세지 전달");
    }

    // 빈이 종료될때 호출되는 메소드
    public void close() {
        disconnect();
    }

    /**
     * 현대 방식 2
     * 애노테이션을 사용하여 빈의 생성과 소멸 시 메소드 호출
     * 가장 권장되는 방식(스프링 진영에서 추천)
     * 외부 라이브러리는 코드를 변경할 수 없기 때문에 그럴 경우에는 현대 방식 1 을 사용하자
     *
     */
    // 의존관계 주입이 끝나면 호출되는 메소드
    @PostConstruct
    public void init2() {
        connect();
        call("생성 메세지 전달");
    }

    // 빈이 종료될때 호출되는 메소드
    @PreDestroy
    public void close2() {
        disconnect();
    }
}
