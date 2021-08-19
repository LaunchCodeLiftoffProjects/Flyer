package org.launchcode.demo.controllers;

import org.launchcode.demo.models.Concert;
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

@Controller
@RequestMapping("concerts")
public class ConcertController {

    @Autowired
    private ConcertRepository concertRepository;

    @GetMapping("add")
    public String displayAddConcertForm(Model model) {
        model.addAttribute("title", "Add Concert");
        model.addAttribute(new Concert());
        model.addAttribute("concert", concertRepository.findAll());


        return "add";
    }

    @PostMapping("add")
    public String processAddJobForm(@ModelAttribute @Valid Concert newConcert,
                                    Errors errors, Model model) {

//        if (errors.hasErrors()) {
//            return "add";
//        }



        concertRepository.save(newConcert);

        return "redirect:";
    }

}
