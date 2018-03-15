package com.ecommerce.promotion.controller;


import com.ecommerce.product.doimain.Manufacturer;
import com.ecommerce.product.service.ProductService;
import com.ecommerce.promotion.domain.PromotionBox;
import com.ecommerce.promotion.domain.PromotionBoxForm;
import com.ecommerce.promotion.domain.SlideshowForm;
import com.ecommerce.promotion.domain.SlideshowImage;
import com.ecommerce.promotion.service.UploadFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@RequestMapping("/dashboard/promotion/")
@Controller
public class PromotionController {

    @Autowired
    UploadFileService uploadFileService;

    @Autowired
    ProductService productService;

    List<SlideshowImage> orderedImageList = new ArrayList<>();


    @RequestMapping("/slideshow")
    public String managePromotionSlider(Model model){

        int iterator = 0;
        orderedImageList =uploadFileService.getOrderedAllImages();
        //Getting images List for showing for user
        //List is orderder by order sequence


        SlideshowForm slideshowForm = new SlideshowForm();

        //if orderedimages list dons't empty then set object for view
        if(orderedImageList.size()==0) {
            SlideshowImage bloackImage = new SlideshowImage();
            bloackImage.setName("");
            bloackImage.setOrderSequence(1);
            bloackImage.setSlideshowImageID(Long.valueOf(1));
            orderedImageList.add(bloackImage);

        }

        model.addAttribute("imagesList", orderedImageList);
        model.addAttribute("slideshowForm",slideshowForm);
        return "slideshow";
    }


    @RequestMapping(value = "/slideshow",method = RequestMethod.POST)
    public String uploadFiles(Model model,@ModelAttribute SlideshowForm slideshowForm, HttpServletRequest request){

        String fileName = productService.getUniqueFileName();
        uploadFileService.uploadFile(request,slideshowForm,fileName);
        return "redirect:/dashboard/promotion/slideshow";
    }


    @RequestMapping(value = "/slideshow/remove/{id}", method = RequestMethod.GET)
    public String removeManufacturer(Model model,@ModelAttribute SlideshowForm slideshowForm, @PathVariable("id") int id) {
        if (id != 0) {
            SlideshowImage slideshowImage= uploadFileService.getImageById(Long.valueOf(id));
            uploadFileService.removeImage(slideshowImage);
        }
        return "redirect:/dashboard/promotion/slideshow";
    }

    @RequestMapping(value = "/promotion-box",method = RequestMethod.GET)
    public String managePromotionBox(Model model){

        PromotionBoxForm promotionBoxForm = new PromotionBoxForm();
        model.addAttribute("promotionBoxForm",promotionBoxForm);
        return "promotion-box";
    }

    @RequestMapping(value = "/promotion-box",method = RequestMethod.POST)
    public String savePromotionBox(Model model, @RequestAttribute PromotionBoxForm promotionBoxForm, HttpServletRequest request){

        try {
            uploadFileService.uploadAllPromotionBoxex(request,promotionBoxForm);
        }catch (Exception e) {
            e.printStackTrace();
        }

        model.addAttribute("promotionBoxForm",promotionBoxForm);
        return "redirect:/dashboard/promotion/promotion-box";

    }
}

