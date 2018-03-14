package com.ecommerce.promotion.domain;

import org.springframework.web.multipart.MultipartFile;

public class SlideshowForm {

    public MultipartFile getFile() {
        return file;
    }

    public void setFile(MultipartFile file) {
        this.file = file;
    }

    private MultipartFile file;

    public SlideshowImage getImageProperties() {
        return imageProperties;
    }

    public void setImageProperties(SlideshowImage imageProperties) {
        this.imageProperties = imageProperties;
    }

    private SlideshowImage imageProperties;

}
