package xyz.devyu.corePrinciple.common;

import lombok.Setter;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.UUID;

@Component
@Scope("request")
public class MyLogger {

    private String uuid;
    @Setter
    private String requestUrl;

    public void log(String message) {
        System.out.println("["+uuid+"]" + "["+requestUrl+"]" + "["+message+"]");
    }

    @PostConstruct
    public void init() {
        uuid = UUID.randomUUID().toString();
        System.out.println("["+uuid+"]" + " request scope bean create:" + this);
    }

    @PreDestroy
    public void close() {
        System.out.println("["+uuid+"]" + " request scope bean close:" + this);
    }

}
