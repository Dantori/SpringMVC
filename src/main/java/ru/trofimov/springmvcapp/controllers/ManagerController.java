package ru.trofimov.springmvcapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/bos")
public class ManagerController {

    @GetMapping("/info")
    public String info() {
        return "manager_info";
    }
}
