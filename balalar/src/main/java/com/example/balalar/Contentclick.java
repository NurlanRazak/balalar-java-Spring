package com.example.balalar;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@NoArgsConstructor(access=AccessLevel.PRIVATE, force=true)
@Entity
public class Contentclick {
    @Id
    private final String id;
    private final String name;
    private final Type type;



    public static enum Type {
        ENTERTAIMENT, BEGINNER, MIDDLE, YOUNG, ADULT
    }
}
