package org.launchcode.demo.controllers;

import org.launchcode.demo.models.data.ArtistRepository;
import org.launchcode.demo.models.data.ConcertRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "list")
public class ListController {


    @GetMapping //or @RequestMapping?
    public String displayAllEvents(Model model) {
        model.addAttribute("title", "All Concerts");
        model.addAttribute("concerts", concertRepository.findAll());
        model.addAttribute("artists", artistRepository.findAll());
        return "list";
    }

    @Autowired
    private ConcertRepository concertRepository;

    @Autowired
    private ArtistRepository artistRepository;


    }
