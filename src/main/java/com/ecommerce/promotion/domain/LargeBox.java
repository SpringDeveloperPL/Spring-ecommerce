package com.ecommerce.promotion.domain;

import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;

@Entity
@org.hibernate.annotations.Proxy(lazy = false)
@Table(name = "LARGE_BOX")
public class LargeBox {

    @Id
    @Column
    private Long largeBoxID;

    @Column
    private String imageName;

    @Column
    private String heading;

    @Column
    private String description;

    @Transient
    private MultipartFile imageFile;


    public Long getLargeBoxID() {
        return largeBoxID;
    }

    public void setLargeBoxID(Long largeBoxID) {
        this.largeBoxID = largeBoxID;
    }

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }

    public String getHeading() {
        return heading;
    }

    public void setHeading(String heading) {
        this.heading = heading;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public MultipartFile getImageFile() {
        return imageFile;
    }

    public void setImageFile(MultipartFile imageFile) {
        this.imageFile = imageFile;
    }
}