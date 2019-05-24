package com.example.balalar;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Data
@Entity
@Table(name="News")
public class News implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    private Date placedAt;

    private String title;

    public Long getId() {
        return id;
    }

    @Column(columnDefinition = "TEXT")
    private String sumtext;

    @Column(columnDefinition = "TEXT")
    private String bigtext;


    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public News() {
    }

    public News(Date placedAt, String title, String sumtext, String bigtext) {
        this.placedAt = placedAt;
        this.title = title;
        this.sumtext = sumtext;
        this.bigtext = bigtext;


    }

    @Override
    public String toString() {
        return "Podcast{" +
                "id=" + id +
                ", placedAt=" + placedAt +
                ", title='" + title + '\'' +
                ", sumtext='" + sumtext + '\'' +
                ", bigtext='" + bigtext + '\'' +
                '}';
    }

    public Date getPlacedAt() {
        return placedAt;
    }

    public void setPlacedAt(Date placedAt) {
        this.placedAt = placedAt;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSumtext() {
        return sumtext;
    }

    public void setSumtext(String sumtext) {
        this.sumtext = sumtext;
    }

    public String getBigtext() {
        return bigtext;
    }

    public void setBigtext(String bigtext) {
        this.bigtext = bigtext;
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
