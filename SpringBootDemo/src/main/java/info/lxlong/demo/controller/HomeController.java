package info.lxlong.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller("/home")
public class HomeController {
    @GetMapping
    public String index() {
        return "index";
    }


    @GetMapping("/hello")
    public String hello() {
        return "hello";
    }
}
