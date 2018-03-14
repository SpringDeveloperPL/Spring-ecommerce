package com.ecommerce.promotion.service;

import com.ecommerce.promotion.domain.SlideshowForm;
import com.ecommerce.promotion.domain.SlideshowImage;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.List;


public interface UploadFileService {
    /**
     * save in to server directory
     * @param request
     * @param file
     * @param code
     */
    public void uploadFile(HttpServletRequest request, SlideshowForm file, String code);

    /**
     * saving uploaded file location in database
     * @param image
     */
    public void saveFile(SlideshowImage image);

    /**
     * Getting all images from database
     * @return
     */
    public List<SlideshowImage> getAllImages();

    /**
     * Getting ordered by sequenceId images form database
     * @return
     */
    public List<SlideshowImage> getOrderedAllImages();

    /**
     * Remove Selected Slideshow Image
     * @param image
     */
    public void removeImage(SlideshowImage image);

    /**
     * Getting Image by Identificator
     * @param id
     * @return
     */
    SlideshowImage getImageById(Long id);
}
