package com.example.balalar;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping(value = "/third", method = RequestMethod.GET)

public class ThirdController {
    @GetMapping
    public String showDesignForm(Model model) {




        model.addAttribute("third", new Content());
        return "third";
    }
    private List<Thirdage> filterByType(List<Thirdage> contents, Thirdage.Type type) {
        return contents.stream().filter(x -> x.getType().equals(type)).collect(Collectors.toList());
    }

    @PostMapping
    public String processDesign(@ModelAttribute @Valid String content, Model model, Errors errors) {
// Save the taco design...
// We'll do this in chapter 3
        if(errors.hasErrors()){
            return "home";
        }

        if(content == "5" || content == "4" || content == "6") {
            List<Thirdage> entertaiment = Arrays.asList(
                    new Thirdage("4", "Animation", Thirdage.Type.ENTERTAIMENT),
                    new Thirdage("5", "Fairy Tail", Thirdage.Type.ENTERTAIMENT),
                    new Thirdage("6", "Alphabet", Thirdage.Type.ENTERTAIMENT)

            );
            Thirdage.Type[] types = Thirdage.Type.values();
            for(Thirdage.Type type : types) {
                model.addAttribute(type.toString().toLowerCase(),
                        filterByType(entertaiment, type));
            }

            model.addAttribute("entertaiment", new Content());
           // return "entertaiment";
            return "redirect:/entertaiment";
        }

        if(content == "11" || content == "12" || content == "13") {
            List<Thirdage> middle = Arrays.asList(
                    new Thirdage("11", "Easy Math", Thirdage.Type.MIDDLE),
                    new Thirdage("12", "Foreign Language", Thirdage.Type.MIDDLE),
                    new Thirdage("13", "Sport", Thirdage.Type.MIDDLE)
            );

            Thirdage.Type[] types = Thirdage.Type.values();
            for(Thirdage.Type type : types) {
                model.addAttribute(type.toString().toLowerCase(),
                        filterByType(middle, type));
            }

            model.addAttribute("middle", new Content());
            return "middle";


        }
        if(content == "7" || content == "9" || content == "10") {
            List<Thirdage> young = Arrays.asList(
                    new Thirdage("7", "Easy Math", Thirdage.Type.BEGINNER),
                    new Thirdage("9", "Foreign Language", Thirdage.Type.BEGINNER),
                    new Thirdage("10", "Sport", Thirdage.Type.BEGINNER)
            );
            Thirdage.Type[] types = Thirdage.Type.values();
            for(Thirdage.Type type : types) {
                model.addAttribute(type.toString().toLowerCase(),
                        filterByType(young, type));
            }

            model.addAttribute("third", new Content());
            return "third";
        }

        return "redirect:/buys/current";
       // return "/home";
    }
}
