package com.example.balalar.data;
import org.springframework.data.repository.CrudRepository;
import com.example.balalar.Contentclick;
import org.springframework.stereotype.Repository;

@Repository
public interface ContentRepository
        extends CrudRepository<Contentclick, String>{
    Contentclick findByIdAndName(String id, String name);
}
