package com.example.balalar.data;
import org.springframework.data.repository.CrudRepository;
import com.example.balalar.Podcast;
import org.springframework.stereotype.Repository;
@Repository
public interface PodcastRepository extends CrudRepository<Podcast, Long>{
}





