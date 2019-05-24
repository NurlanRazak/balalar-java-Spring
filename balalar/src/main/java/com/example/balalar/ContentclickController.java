package com.example.balalar;

import java.util.ArrayList;
import java.util.Arrays;
        import java.util.List;
        import java.util.stream.Collectors;

        import javax.validation.Valid;

import com.example.balalar.data.ContentRepository;
import com.example.balalar.data.ContentSizeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
        import org.springframework.ui.Model;
        import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import lombok.extern.slf4j.Slf4j;
        import com.example.balalar.Content;
        import com.example.balalar.Contentclick;
        import com.example.balalar.Contentclick.Type;
@Slf4j
@Controller
@RequestMapping("/home")
@SessionAttributes("buy")

public class ContentclickController {

    private final ContentRepository contentRepo;

    private ContentSizeRepository contentSizeRepo;


    @Autowired
    public ContentclickController(ContentRepository contentRepo,
                                  ContentSizeRepository contentSizeRepo) {
        this.contentRepo = contentRepo;
        this.contentSizeRepo = contentSizeRepo;
    }

    @ModelAttribute(name="buy")
    public Buy buy() { return new Buy(); }

    @ModelAttribute(name = "home")
    public Content home() { return new Content(); }

    @GetMapping
    public String showDesignForm(Model model) {
        List<Contentclick> contentclicks = new ArrayList<>();
        contentRepo.findAll().forEach(i -> contentclicks.add(i));

        Type[] types = Contentclick.Type.values();
        for (Type type : types) {
            model.addAttribute(type.toString().toLowerCase(),
                    filterByType(contentclicks, type));
        }

        return "home";
    }
    //end::injectingIngredientRepository[]

    //tag::injectingDesignRepository[]
    @PostMapping
    public String processDesign(
            @Valid Content content, Errors errors,
            @ModelAttribute Buy buy) {

        if (errors.hasErrors()) {
            return "home";
        }

        Content saved = contentSizeRepo.save(content);
        buy.addDesign(saved);

        return "redirect:/buys/current";
    }


    private List<Contentclick> filterByType(List<Contentclick> contents, Contentclick.Type type) {
        return contents.stream().filter(x -> x.getType().equals(type)).collect(Collectors.toList());
    }

//end::injectingDesignRepository[]

   /*
    @GetMapping
    public String showDesignForm(Model model) {
        List<Contentclick> contents = new ArrayList<>();
//                Arrays.asList(
//                new Contentclick("ANMT", "Animation", Contentclick.Type.ENTERTAIMENT),
//                new Contentclick("FRTL", "Fairy Tail", Contentclick.Type.ENTERTAIMENT),
//                new Contentclick("ALPH", "Alphabet", Contentclick.Type.BEGINNER),
//                new Contentclick("ESMT", "Easy Math", Contentclick.Type.BEGINNER),
//                new Contentclick("FRLN", "Foreign Language", Contentclick.Type.MIDDLE),
//                new Contentclick("SPRT", "Sport", Contentclick.Type.MIDDLE),
//                new Contentclick("CKNG", "Cooking", Contentclick.Type.YOUNG),
//                new Contentclick("CMNC", "Communication Skills", Contentclick.Type.YOUNG),
//                new Contentclick("MNMG", "Money Management", Contentclick.Type.ADULT),
//                new Contentclick("TMNG", "Time Management", Contentclick.Type.ADULT)
//
//        );
        contentRepo.findAll().forEach(i -> contents.add(i));


        Contentclick.Type[] types = Contentclick.Type.values();
        for(Contentclick.Type type : types) {
            model.addAttribute(type.toString().toLowerCase(),
                    filterByType(contents, type));
        }

        model.addAttribute("home", new Content());
        return "home";
    }



    @PostMapping
    public String processDesign(@Valid Content content, Errors errors) {
// Save the taco design...
// We'll do this in chapter 3
        if(errors.hasErrors()){
            return "home";
        }

        return "redirect:/buys/current";
    }
     */
}