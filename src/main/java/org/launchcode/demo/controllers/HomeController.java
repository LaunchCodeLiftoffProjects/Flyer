package org.launchcode.demo.controllers;


import org.launchcode.demo.models.Concert;
import org.launchcode.demo.models.data.ConcertRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Optional;

@Controller
public class HomeController {

    @Autowired
    ConcertRepository concertRepository;

    @RequestMapping(value = "home", method = {RequestMethod.GET, RequestMethod.POST})
    public String index(Model model) {
        model.addAttribute("title","Tours");
        return "index";
    }

    @RequestMapping(value ="bandInfo/{concertId}", method = RequestMethod.GET)
    public String displayBandInfo(@PathVariable int concertId, Model model){
        //model.addAttribute("title",concertId);
        Optional optConcert = concertRepository.findById(concertId);
        model.addAttribute("title",optConcert);
        if(optConcert.isPresent()){
            Concert concert = (Concert) optConcert.get();
            model.addAttribute("concert",concert);
            //model.addAttribute("artists",concert.getArtists());

            return "bandInfo";
        }
        else {
            return "redirect..:/";
        }
    }

}
