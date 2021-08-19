package org.launchcode.demo.controllers;

import org.launchcode.demo.models.Concert;
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

    @GetMapping("add")
    public String displayAddJobForm(Model model) {
        model.addAttribute("title", "Add Concert");
        model.addAttribute(new Concert());
//        model.addAttribute("concerts", concertRepository.findAll());


        return "add";
    }

}
