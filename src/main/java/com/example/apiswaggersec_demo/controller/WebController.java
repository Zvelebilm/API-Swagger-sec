package com.example.apiswaggersec_demo.controller;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.io.Console;

@Controller
@AllArgsConstructor
@Slf4j
public class WebController {
    @GetMapping("/")
    public String index() {
        return "index";
    }
    @GetMapping("/movie/find/{title}")
    public String movie(@PathVariable String title, Model model) {
        log.warn("title" + title);
        //todo try find movie localy ,if not try find movie from api
        return "index";
    }

}
