package org.launchcode.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("add")
public class ConcertController {

    @RequestMapping("")
    public String add(Model model) {

        return "add";
    }

//    private static List<String> add = new ArrayList<>();
//
//    @GetMapping
//    public String displayAllConcerts(Model model) {
//        model.addAttribute("title", "All Concerts");
//        model.addAttribute("add", add);
//        return "add/index";
//    }

}
