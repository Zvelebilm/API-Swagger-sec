package com.example.apiswaggersec_demo.controller;

import com.example.apiswaggersec_demo.service.ApiService;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.Console;
import java.net.URISyntaxException;

@Controller
@AllArgsConstructor
@Slf4j
public class WebController {
    private final ApiService apiService;
    @GetMapping("/")
    public String index() {
        return "index";
    }
    @PostMapping("/find")
    public String movie(String title) {
        log.warn("title" + title);
       // apiService.findMovie(title);

        //todo try find movie localy ,if not try find movie from api
        return "redirect:/";
    }

}
