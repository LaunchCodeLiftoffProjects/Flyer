package org.launchcode.demo.controllers;

import org.launchcode.demo.models.Concert;
import org.launchcode.demo.models.data.ArtistRepository;
import org.launchcode.demo.models.data.ConcertRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;


@Controller
@RequestMapping(value = "add")
public class ConcertController {

    @Autowired
    private ConcertRepository concertRepository;

    @Autowired
    private ArtistRepository artistRepository;

    @GetMapping("")
    public String displayAddConcertForm(Model model) {
        model.addAttribute("title", "Add Concert");
        model.addAttribute(new Concert());
        model.addAttribute("concerts", concertRepository.findAll());
        model.addAttribute("artists",  artistRepository.findAll());
//        model.addAttribute("artistConcertDto",)

        return "add";
    }

    @PostMapping("")

    public String processAddConcertForm(@ModelAttribute @Valid Concert newConcert,
                                        Errors errors, Model model) {

        if(errors.hasErrors()) {
            System.out.println(errors.getAllErrors());
            System.out.println("This has Errors");
            return "list";
        }

        concertRepository.save(newConcert);

        model.addAttribute("concerts", concertRepository.findAll());
        model.addAttribute("artists",  artistRepository.findAll());

        return "list";
    }



//    private static List<String> add = new ArrayList<>();

//    @GetMapping
//    public String displayAllConcerts(Model model) {
//        model.addAttribute("title", "All Concerts");
//        model.addAttribute("add", add);
//        return "add/index";

//    }

}
