package org.launchcode.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "artist")
public class ArtistController {

    @RequestMapping("")
    public String add(Model model) {

        return "artist";
    }

}
