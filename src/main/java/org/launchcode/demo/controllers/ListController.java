package org.launchcode.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "list")
public class ListController {

    @RequestMapping("")
    public String list(Model model) {



        return"list";
    }
}
