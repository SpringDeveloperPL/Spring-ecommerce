package com.ecommerce.promotion.domain;

import javax.persistence.*;

@Entity
@org.hibernate.annotations.Proxy(lazy=false)
@Table(name="SLIDESHOW_IMAGE")
public class SlideshowImage {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long slideshowImageID;

    @Column
    private int orderSequence;

    @Column
    private String name;

    public Long getSlideshowImageID() {
        return slideshowImageID;
    }

    public void setSlideshowImageID(Long slideshowImageID) {
        this.slideshowImageID = slideshowImageID;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    @Column
    private Boolean active;


    public int getOrderSequence() {
        return orderSequence;
    }

    public void setOrderSequence(int orderSequence) {
        this.orderSequence = orderSequence;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
