package com.kuzmin.dbh2.dbase.controllers;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class MainController {

    //Главная страница
    @GetMapping("/")
    public String greeting(Model model) {
        model.addAttribute("title", "Главная страница");
        return "home";
    }
}