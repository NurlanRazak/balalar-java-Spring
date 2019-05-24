package com.example.balalar;


import com.example.balalar.data.INewsService;
import com.example.balalar.data.NewsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NewsService implements INewsService {

    @Autowired
    private NewsRepository newsRepository;

    @Override
    public List<News> findAll(){

        List<News> newsList = (List<News>) newsRepository.findAll();

        return newsList;

    }

}
