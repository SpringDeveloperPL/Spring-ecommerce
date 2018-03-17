package com.ecommerce.promotion.service;

import com.ecommerce.promotion.domain.*;
import org.springframework.http.HttpRequest;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.List;


public interface UploadFileService {
    /**
     * save in to server directory
     *
     * @param request
     * @param file
     * @param code
     */
    public void uploadFile(HttpServletRequest request, SlideshowForm file, String code);

    /**
     * saving uploaded file location in database
     *
     * @param image
     */
    public void saveFile(SlideshowImage image);

    /**
     * Getting all images from database
     *
     * @return
     */
    public List<SlideshowImage> getAllImages();

    /**
     * Getting ordered by sequenceId images form database
     *
     * @return
     */
    public List<SlideshowImage> getOrderedAllImages();

    /**
     * Remove Selected Slideshow Image
     *
     * @param image
     */
    public void removeImage(SlideshowImage image);

    /**
     * Getting Image by Identificator
     *
     * @param id
     * @return
     */
    SlideshowImage getImageById(Long id);

    /**
     * Uploading All Promotion Boxes
     *
     * @param promotionBoxForm
     */
    public void saveAllPromotionBox(PromotionBoxForm promotionBoxForm);

    /**
     * Uplading Any File into server Directory
     *
     * @param request
     * @param file
     * @param fileName
     */
    public void uploadAnyFileIntoServer(HttpServletRequest request, MultipartFile file, String fileName);

    /**
     * Uploading All Promotion Boxes into server Directory
     *
     * @param request
     * @param promotionBoxForm
     */
    public void uploadAllPromotionBoxex(HttpServletRequest request, PromotionBoxForm promotionBoxForm);

    /**
     * Getting Unique file name
     * @return
     */
    public String getUniqueFileName();

    /**
     * Getting Ordered List of All Promotion Boxes
     * @return
     */
    public List<PromotionBox> getListOfAllPromotionBoxesOrderedById();


    /**
     * Getting Ordered List of All Promotion Boxes
     * @return
     */
    public List<LargeBox> getListOfAllLargeBoxesOrderedById();




}
