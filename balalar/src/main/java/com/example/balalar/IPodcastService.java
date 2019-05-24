package com.example.balalar;
import com.example.balalar.data.PodcastRepository;
import com.example.balalar.data.PodcastService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IPodcastService implements PodcastService {

    @Autowired
    private PodcastRepository podcastRepository;

    @Override
    public List<Podcast> findAll(){

        List<Podcast> podcastList = (List<Podcast>) podcastRepository.findAll();

        return podcastList;

    }
}
