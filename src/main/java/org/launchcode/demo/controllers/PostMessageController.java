package org.launchcode.demo.controllers;


import org.launchcode.demo.models.PostMessage;
import org.launchcode.demo.models.data.ArtistRepository;
import org.launchcode.demo.models.data.PostMessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import javax.validation.Valid;

@Controller
@RequestMapping(value = "postMessage")
public class PostMessageController {

    @Autowired
    private PostMessageRepository postMessageRepository;

    @Autowired
    private ArtistRepository artistRepository;

    @RequestMapping(method = RequestMethod.GET)
    public String displayPostForm(Model model){
        model.addAttribute("title","create post message form");
        model.addAttribute("artists",artistRepository.findAll());
        model.addAttribute ( new PostMessage());
        return "postMessage";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String addPost(Model model, PostMessage newPostMessage,Errors errors){
        model.addAttribute("title","create a post");
        if(errors.hasErrors())
        {
            System.out.println(errors.getAllErrors());
            System.out.println(newPostMessage);
            return "postMessage";
        }
        postMessageRepository.save(newPostMessage);
        model.addAttribute("artist",newPostMessage.getArtist());
        return "artists/view";
    }

    }
