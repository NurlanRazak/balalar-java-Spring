package com.example.balalar;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.example.balalar.Contentclick;
import com.example.balalar.data.ContentRepository;

@Component
public class ContentclickByIdConventer implements Converter<String, Contentclick>{

    private ContentRepository contentclickRepo;

    @Autowired
    public ContentclickByIdConventer(ContentRepository contentclickRepo) {this.contentclickRepo = contentclickRepo; }

    @Override
    public Contentclick convert(String id) {
        Optional<Contentclick> optionalContentclick = contentclickRepo.findById(id);
        return optionalContentclick.isPresent()?
                optionalContentclick.get() : null;
    }
}
