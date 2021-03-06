package main.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
@RequiredArgsConstructor
public class DefaultController {

    @GetMapping("/")
    public String index() {
        return "index";
    }
}
