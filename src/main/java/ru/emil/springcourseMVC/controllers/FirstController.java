package ru.emil.springcourseMVC.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/first")
public class FirstController {
    @GetMapping("/hello")
    public String helloPage(@RequestParam(value = "a", required = false) int a,
                            @RequestParam(value = "b", required = false) int b,
                            @RequestParam(value = "o", required = false) String operation,
                            Model model){
        int result = 0;
        if(operation.equals("sum")){
            result = a+b;
        }
        if(operation.equals("multi")){
            result = a*b;
        }
        if(operation.equals("minus")){
            result = a-b;
        }
        if(operation.equals("div")){
            result = a/b;
        }
        model.addAttribute("message",  "result: " + result);
        return "first/hello";
    }
    @GetMapping("/goodbye")
    public String goodbyePage(){
        return "first/goodbye";
    }
}
