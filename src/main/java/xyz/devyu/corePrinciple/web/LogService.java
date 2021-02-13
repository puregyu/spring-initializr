package xyz.devyu.corePrinciple.web;

import org.springframework.beans.factory.ObjectProvider;
import org.springframework.stereotype.Service;
import xyz.devyu.corePrinciple.common.MyLogger;

@Service
public class LogService {

    private final ObjectProvider<MyLogger> myLogger;

    public LogService(ObjectProvider<MyLogger> myLogger) {
        this.myLogger = myLogger;
    }


    public void logic() {
        System.out.println("this is service layer");
    }
}
