package com.ecommerce.promotion.domain;

import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;

@Entity
@org.hibernate.annotations.Proxy(lazy = false)
@Table(name = "PROMOTION_BOX")
public class PromotionBox {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long promotionBoxID;

    @Column
    private long uniqueBoxID;

    @Column
    private String imageName;

    @Column
    private String heading;

    @Column
    private String description;

    @Column
    private String url;

    @Transient
    private MultipartFile imageFile;

    public long getPromotionBoxID() {
        return promotionBoxID;
    }

    public void setPromotionBoxID(long promotionBoxID) {
        this.promotionBoxID = promotionBoxID;
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

    public long getUniqueBoxID() {
        return uniqueBoxID;
    }

    public void setUniqueBoxID(long uniqueBoxID) {
        this.uniqueBoxID = uniqueBoxID;
    }

    public MultipartFile getImageFile() {
        return imageFile;
    }

    public void setImageFile(MultipartFile imageFile) {
        this.imageFile = imageFile;
    }


}
