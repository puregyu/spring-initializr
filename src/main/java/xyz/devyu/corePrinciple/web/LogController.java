package xyz.devyu.corePrinciple.web;

import org.springframework.beans.factory.ObjectProvider;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import xyz.devyu.corePrinciple.common.MyLogger;

import javax.servlet.http.HttpServletRequest;

@RestController
public class LogController {
    private final LogService logService;
    private final ObjectProvider<MyLogger> myLogger;

    public LogController(LogService logService, ObjectProvider<MyLogger> myLogger) {
        this.logService = logService;
        this.myLogger = myLogger;
    }


    @RequestMapping("log-demo")
    public String log(HttpServletRequest request) {
        String requestURL = request.getRequestURL().toString();
        myLogger.getObject().setRequestUrl(requestURL);

        myLogger.getObject().log("this is controller layer");

        logService.logic();
        return "OK";
    }
}
