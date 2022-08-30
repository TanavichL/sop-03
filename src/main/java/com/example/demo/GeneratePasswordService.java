package com.example.demo;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GeneratePasswordService {
    @RequestMapping(value = "/{name}.generate", method = RequestMethod.GET)
    public  String genpass(@PathVariable("name") String n){
        return "Hi, " + n + "<br>" +
                "Your new password is " + (int)(Math.random() * 1000000000) % 1000000000;
    }
}
