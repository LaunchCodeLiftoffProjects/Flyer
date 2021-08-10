package org.launchcode.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("concerts")
public class ConcertController {

    private static List<String> concerts = new ArrayList<>();

    @GetMapping
    public String displayAllConcerts(Model model) {
        model.addAttribute("title", "All Concerts");
        model.addAttribute("concerts", concerts);
        return "concerts/index";
    }

}
