package com.example.balalar;
import com.example.balalar.data.PodcastRepository;
import com.example.balalar.data.PodcastService;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class PodcastController {

    @Autowired
    private PodcastRepository podcastRepository;

    @Autowired
    PodcastService podcastService;


    @GetMapping("/podcast")
    public List<Podcast> getIds(){
        return podcastService.findAll();
    }

    @GetMapping("/podcast/{id}")
    public Optional<Podcast> getId(@PathVariable Long id){
        return podcastRepository.findById(id);
    }
    @DeleteMapping("/podcast/{id}")
    public boolean deletePodcast(@PathVariable Long id){
        System.out.println(id);
        podcastRepository.deleteById(id);
        return true;
    }
    @PostMapping("/podcast")
    public Podcast createPodcast(@RequestBody Podcast podcast){
        return podcastRepository.save(podcast);
    }

    @PutMapping("/podcast")
    public Podcast updatePodcast(@RequestBody Podcast podcast){
        return podcastRepository.save(podcast);
    }





}
