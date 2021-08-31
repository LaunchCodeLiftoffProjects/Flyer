package org.launchcode.demo.controllers;

import org.launchcode.demo.models.Concert;
import org.launchcode.demo.models.ConcertData;
import org.launchcode.demo.models.data.ConcertRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;

@Controller
@RequestMapping(value = "list")
public class ListController {

//    @RequestMapping("")
//    public String list(Model model) {
//
//        model.addAttribute("columns", columnChoices);
//
//        return"list";
//    }

    @GetMapping //or @RequestMapping?
    public String displayAllEvents(Model model) {
        model.addAttribute("title", "All Concerts");
        model.addAttribute("concerts", concertRepository.findAll());
        return "list";
    }

    @Autowired
    private ConcertRepository concertRepository;

    static HashMap<String, String> columnChoices = new HashMap<>();

    @PostMapping("search")
    public String displaySearchResults(Model model, @RequestParam String searchType, @RequestParam String searchTerm) {
        Iterable<Concert> concerts;
        if (searchTerm.toLowerCase().equals("all") || searchTerm.equals("")) {
            concerts = concertRepository.findAll();
        } else {
            concerts = ConcertData.findByColumnAndValue(searchType, searchTerm, concertRepository.findAll());
        }
        model.addAttribute("columns", columnChoices);
        model.addAttribute("title", "Concerts with " + columnChoices.get(searchType) + ": " + searchTerm);
        model.addAttribute("concerts", concerts);

            return "search";
        }
    }
