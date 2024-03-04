package com.example.apiswaggersec_demo.controller;

import com.example.apiswaggersec_demo.service.ApiService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

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
       apiService.findMovie(title);

        //todo try find movie locally ,if not try find movie from api
        return "redirect:/";
    }

}
