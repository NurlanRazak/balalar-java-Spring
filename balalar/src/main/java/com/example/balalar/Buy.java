package com.example.balalar;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

import javax.validation.constraints.Digits;
import javax.validation.constraints.Pattern;
import org.hibernate.validator.constraints.CreditCardNumber;
import org.hibernate.validator.constraints.NotBlank;
import lombok.Data;

@Data
@Entity
@Table(name="Content_Buy")
public class Buy implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    private Date placedAt;

    @NotBlank(message="Name is required")
    private String name;

    public Long getId() {
        return id;
    }

    @NotBlank(message="Content is required, please write your whole text right here")
    private String conte;
    @NotBlank(message="Summary is required")
    private String summary;
    @CreditCardNumber(message="Not a valid credit card number")
    private String ccNumber;
    @Pattern(regexp="^(0[1-9]|1[0-2])([\\/])([1-9][0-9])$",
            message="Must be formatted MM/YY")
    private String ccExpiration;
    @Digits(integer=3, fraction=0, message="Invalid CVV")
    private String ccCVV;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Buy() {
    }

    public Buy(Date placedAt, @NotBlank(message = "Name is required") String name, @NotBlank(message = "Content is required, please write your whole text right here") String conte, @NotBlank(message = "Summary is required") String summary, @CreditCardNumber(message = "Not a valid credit card number") String ccNumber, @Pattern(regexp = "^(0[1-9]|1[0-2])([\\/])([1-9][0-9])$",
            message = "Must be formatted MM/YY") String ccExpiration, @Digits(integer = 3, fraction = 0, message = "Invalid CVV") String ccCVV) {
        this.placedAt = placedAt;
        this.name = name;
        this.conte = conte;
        this.summary = summary;
        this.ccNumber = ccNumber;
        this.ccExpiration = ccExpiration;
        this.ccCVV = ccCVV;

    }

    @Override
    public String toString() {
        return "Buy{" +
                "id=" + id +
                ", placedAt=" + placedAt +
                ", name='" + name + '\'' +
                ", conte='" + conte + '\'' +
                ", summary='" + summary + '\'' +
                ", ccNumber='" + ccNumber + '\'' +
                ", ccExpiration='" + ccExpiration + '\'' +
                ", ccCVV='" + ccCVV +
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

    public String getConte() {
        return conte;
    }

    public void setConte(String conte) {
        this.conte = conte;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getCcNumber() {
        return ccNumber;
    }

    public void setCcNumber(String ccNumber) {
        this.ccNumber = ccNumber;
    }

    public String getCcExpiration() {
        return ccExpiration;
    }

    public void setCcExpiration(String ccExpiration) {
        this.ccExpiration = ccExpiration;
    }

    public String getCcCVV() {
        return ccCVV;
    }

    public void setCcCVV(String ccCVV) {
        this.ccCVV = ccCVV;
    }



    /*
  //tag::allButDetailProperties[]
  ...

  //end::allButDetailProperties[]
   */

    //tag::allButDetailProperties[]
    @ManyToMany(targetEntity=Content.class)
    private List<Content> contents = new ArrayList<>();


    public void addDesign(Content design) {
        this.contents.add(design);
    }


    @PrePersist
    void placedAt() {
        this.placedAt = new Date();
    }


}
