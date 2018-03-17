package com.ecommerce.promotion.domain;

import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;

@Entity
@org.hibernate.annotations.Proxy(lazy = false)
@Table(name = "PROMOTION_BOX")
public class PromotionBox {

    @Id
    private long promotionBoxID;

    @Column
    private long uniqueBoxID;

    @Column(name="imageName", nullable=true, length=255)
    private String imageName;

    @Column(name="heading", nullable=true, length=255)
    private String heading;

    @Column(name="description", nullable=true, length=255)
    private String description;

    @Column(name="url", nullable=true, length=255)
    private String url;

    @Transient
    private MultipartFile imageFile;

    public long getPromotionBoxID() {
        return promotionBoxID;
    }

    public void setPromotionBoxID(long promotionBoxID) {
        this.promotionBoxID = promotionBoxID;
    }

    public long getUniqueBoxID() {
        return uniqueBoxID;
    }

    public void setUniqueBoxID(long uniqueBoxID) {
        this.uniqueBoxID = uniqueBoxID;
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

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public MultipartFile getImageFile() {
        return imageFile;
    }

    public void setImageFile(MultipartFile imageFile) {
        this.imageFile = imageFile;
    }
}
