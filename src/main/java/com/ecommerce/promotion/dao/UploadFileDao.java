package com.ecommerce.promotion.dao;

import com.ecommerce.promotion.domain.SlideshowImage;

import java.util.List;

public interface UploadFileDao {

    /**
     * Store file location into Database
     * @param image
     */
    void saveFile(SlideshowImage image);

    /**
     * Gettig all images from database
     * @return
     */
    List<SlideshowImage> getAllImages();

    /**
     * Getting ordered list of all images for slideshow  by sequence id
     * @return
     */
    List<SlideshowImage> getOrderedAllImages();

    /**
     * Getting Image by Identificator
     * @param id
     * @return
     */
    SlideshowImage getImageById(Long id);

    /**
     * Remove Slideshow image By Identification
     * @param image
     */
    void removeImage(SlideshowImage image);
}
