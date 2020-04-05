package com.learn.controller;


import com.learn.service.DemoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Slf4j
@Controller
public class DemoController {

    // == fields ==
    private final DemoService demoService;

    // == constructors ==
    @Autowired
    public DemoController(DemoService demoService) {
        this.demoService=demoService;
    }

    // == request methods ==
    // http://localhost:8080/Todo-List/hello
    @ResponseBody
    @GetMapping("/hello")
    public String hello(){
        return "Hello!";
    }

    // http://localhost:8080/Todo-List/welcome?user=Alan <- added query parameter with @RequestParam
    // adding attributes to the moel manually (to be used in welcome.jsp)
    @GetMapping("welcome")
    public String welcome(@RequestParam String user, @RequestParam int age, Model model){
        model.addAttribute("helloMessage", demoService.getHelloMessage(user));
        model.addAttribute("age", age);
        log.info("Mode = {}", model);
    // uses prefix & suffix, see WebConfig
        return "welcome";
    }

    // == model attributes ==
    // adding attributes via annotation (to be used in welcome.jsp)
    @ModelAttribute("welcomeMessage")
    public String welcomeMessage(){
        log.info("welcomeMessage() Called");
        return demoService.getWelcomeMessage();
    }



}
