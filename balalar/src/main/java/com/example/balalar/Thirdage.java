package com.example.balalar;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
public class Thirdage {
    private final String age;

    private final String nameofchild;
    private final Type type;

    public Thirdage(String age, String nameofchild, Type type) {
        this.age = age;
        this.nameofchild = nameofchild;
        this.type = type;
    }

    public Type getType() {
        return type;
    }
    public static enum Type {
        ENTERTAIMENT, BEGINNER, MIDDLE
    }
}
