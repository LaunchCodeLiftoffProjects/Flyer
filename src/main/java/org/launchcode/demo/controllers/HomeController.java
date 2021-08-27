package org.launchcode.demo.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@Controller
public class HomeController {

    @RequestMapping(value = "home", method = {RequestMethod.GET, RequestMethod.POST})
    public String index(Model model) {
        model.addAttribute("title","Tours");
        return "index";
    }

}
