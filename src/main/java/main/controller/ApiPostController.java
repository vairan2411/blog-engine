package main.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("api/post")
public class ApiPostController {

    @GetMapping
    public String  getPosts(){
        return "index";
    }
}
