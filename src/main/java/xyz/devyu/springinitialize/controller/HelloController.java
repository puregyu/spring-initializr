package xyz.devyu.springinitialize.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

    @GetMapping("hello")
    public String hello(Model model) {
        model.addAttribute("data", "hello");
        return "index";
    }

    // html 렌더링 형식
    @GetMapping("hello-mvc")
    public String helloMvc(@RequestParam(value = "name") String name, Model model) {
        model.addAttribute("name", name);
        return "hello-templete";
    }

    // API 형식
    @GetMapping("hello-string")
    @ResponseBody // HTTP BODY부에 데이터를 전달한다는 의미
    public String helloString(@RequestParam("name") String name) {
        return "hello" + name;
    }

    @GetMapping("hello-api")
    @ResponseBody // 객체 반환시 default : json 형식
    // HttpMessageConverter 동작.
    // 문자열 : StringHttpMessageConverter
    // 객체   : MappoingJackson2HttpMessageConverter
    public Hello helloApi(@RequestParam("name") String name) {
        Hello hello = new Hello();
        hello.setName(name);
        return hello;

    }

    class Hello {
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
