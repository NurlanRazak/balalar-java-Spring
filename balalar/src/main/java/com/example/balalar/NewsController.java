package com.example.balalar;

import com.example.balalar.data.INewsService;
import com.example.balalar.data.NewsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class NewsController {

    @Autowired
    private NewsRepository newsRepository;

    @Autowired
    INewsService newsService;


    @GetMapping("/news")
    public List<News> getIds(){
        return newsService.findAll();
    }

    @GetMapping("/news/{id}")
    public Optional<News> getId(@PathVariable Long id){
        return newsRepository.findById(id);
    }
    @DeleteMapping("/news/{id}")
    public boolean deleteNews(@PathVariable Long id){
        System.out.println(id);
        newsRepository.deleteById(id);
        return true;
    }
    @PostMapping("/news")
    public News createNews(@RequestBody News news){
        return newsRepository.save(news);
    }

    @PutMapping("/news")
    public News updateNews(@RequestBody News news){
        return newsRepository.save(news);
    }

}
