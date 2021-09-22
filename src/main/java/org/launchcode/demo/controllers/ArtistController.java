package org.launchcode.demo.controllers;

import org.launchcode.demo.models.Artist;
import org.launchcode.demo.models.data.ArtistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@Controller
@RequestMapping(value="artists")
public class ArtistController {

    @Autowired
    private ArtistRepository artistRepository ;

    @RequestMapping(method = RequestMethod.GET)
    public String displayArtists(Model model){
        model.addAttribute("title","Artists page");
        model.addAttribute("artists",artistRepository.findAll());
        return "artists/index";
    }

    @RequestMapping(method = RequestMethod.GET, value = "add")
    public String addArtistForm(Model model){
        model.addAttribute(new Artist());
        return "artists/add";
    }

    @RequestMapping(method = RequestMethod.POST, value = "add")
    public String addArtist(@ModelAttribute @Valid Artist newArtist, Errors errors, Model model){
        //model.addAttribute("title",newArtist.getBirthdate());
        model.addAttribute("artist",newArtist);

        if(errors.hasErrors()){
            System.out.println(errors.getAllErrors());
            //System.out.println(newArtist.getBirthdate());
            return "artists/add";
        }
        artistRepository.save(newArtist);
        return "redirect:";
    }

    @RequestMapping(method = RequestMethod.GET, value = "view/{artistId}")
    public String displayArtist(@PathVariable int artistId, Model model){
        model.addAttribute("title","View Artist");
        Optional optArtist = artistRepository.findById(artistId);

        if(optArtist.isPresent()){
            Artist artist = (Artist) optArtist.get();
            model.addAttribute("artist",artist);
            return "artists/view";
        }
        else {
            return "redirect:../";
        }
    }


}
