package com.example.balalar;

import com.example.balalar.model.Userfront;
import lombok.Data;
import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name="Podcast")
public class Podcast implements Serializable{
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    private Date placedAt;

    private String name;

    public Long getId() {
        return id;
    }

    private String title;

    private String linkvideo;


    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Podcast() {
    }

    public Podcast(Date placedAt, String name, String title, String linkvideo) {
        this.placedAt = placedAt;
        this.name = name;
        this.title = title;
        this.linkvideo = linkvideo;


    }

    @Override
    public String toString() {
        return "Podcast{" +
                "id=" + id +
                ", placedAt=" + placedAt +
                ", name='" + name + '\'' +
                ", title='" + title + '\'' +
                ", linkvideo='" + linkvideo + '\'' +
                '}';
    }

    public Date getPlacedAt() {
        return placedAt;
    }

    public void setPlacedAt(Date placedAt) {
        this.placedAt = placedAt;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLinkvideo() {
        return linkvideo;
    }

    public void setLinkvideo(String linkvideo) {
        this.linkvideo = linkvideo;
    }




    /*
  //tag::allButDetailProperties[]
  ...

  //end::allButDetailProperties[]
   */

    //tag::allButDetailProperties[]
//    @ManyToOne(targetEntity= Userfront.class)
//    private List<Userfront> userfronts = new ArrayList<>();
//
//
//    public void addDesign(Userfront design) {
//        this.userfronts.add(design);
//    }


    @PrePersist
    void placedAt() {
        this.placedAt = new Date();
    }


}