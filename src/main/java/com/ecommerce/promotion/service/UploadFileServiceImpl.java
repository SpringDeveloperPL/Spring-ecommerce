package com.ecommerce.promotion.service;

import com.ecommerce.promotion.dao.UploadFileDao;
import com.ecommerce.promotion.domain.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

@Service
public class UploadFileServiceImpl implements  UploadFileService{

    @Autowired
    UploadFileDao uploadFileDao;

    private static String REAL_PATH = "";

    private  static final Logger logger  = LoggerFactory.getLogger(UploadFileServiceImpl.class);
    @Override
    public void uploadFile(HttpServletRequest request, SlideshowForm file, String code) {
        REAL_PATH = request.getSession().getServletContext().getRealPath("\\WEB-INF\\resources\\images\\")+"/";

        try {
            file.getImageProperties().setName(code);
            file.getFile().transferTo(new File(REAL_PATH+"\\"+code));
            saveFile(file.getImageProperties());

        }catch (IOException ex)
        {
            ex.printStackTrace();
        }
    }

    @Override
    public void saveFile(SlideshowImage image) {
        uploadFileDao.saveFile(image);
    }

    @Override
    public List<SlideshowImage> getAllImages() {

        return uploadFileDao.getAllImages();
    }

    @Override
    public List<SlideshowImage> getOrderedAllImages() {
        return uploadFileDao.getOrderedAllImages();
    }

    @Override
    public void removeImage(SlideshowImage image) {
        uploadFileDao.removeImage(image);
    }

    @Override
    public SlideshowImage getImageById(Long id) {
        return uploadFileDao.getImageById(id);
    }

    @Override
    public void saveAllPromotionBox(PromotionBoxForm promotionBoxForm) {
        try {
            uploadFileDao.saveOrUploadPromotionBox(promotionBoxForm.getBox1());
            uploadFileDao.saveOrUploadPromotionBox(promotionBoxForm.getBox2());
            uploadFileDao.saveOrUploadPromotionBox(promotionBoxForm.getBox3());

        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void uploadAnyFileIntoServer(HttpServletRequest request, MultipartFile file, String fileName) {
        REAL_PATH = request.getSession().getServletContext().getRealPath("\\WEB-INF\\resources\\images\\")+"/";

        try {
            file.transferTo(new File(REAL_PATH+"\\"+fileName));

        }catch (IOException ex)
        {
            ex.printStackTrace();
        }
    }

    @Override
    public void uploadAllPromotionBoxex(HttpServletRequest request, PromotionBoxForm promotionBoxForm) {
        try {
            String box1_imageName ="1.jpg";
            String box2_imageName ="2.jpg";
            String box3_imageName ="3.jpg";

            //Setting unique name for All Promotion BOxes
            promotionBoxForm.getBox1().setImageName(box1_imageName);
            promotionBoxForm.getBox2().setImageName(box2_imageName);
            promotionBoxForm.getBox3().setImageName(box3_imageName);

            //Uploading All Images for Boxe
            if(!new Long(0).equals(promotionBoxForm.getBox1().getImageFile().getSize()))
            uploadAnyFileIntoServer(request,promotionBoxForm.getBox1().getImageFile(),box1_imageName);
            if(!new Long(0).equals(promotionBoxForm.getBox2().getImageFile().getSize()))
            uploadAnyFileIntoServer(request,promotionBoxForm.getBox2().getImageFile(),box2_imageName);
            if(!new Long(0).equals(promotionBoxForm.getBox3().getImageFile().getSize()))
             uploadAnyFileIntoServer(request,promotionBoxForm.getBox3().getImageFile(),box3_imageName);

            //Saving Boxes Prorerties heading/description/url. ect.
            uploadFileDao.saveOrUploadPromotionBox(promotionBoxForm.getBox1());
            uploadFileDao.saveOrUploadPromotionBox(promotionBoxForm.getBox2());
            uploadFileDao.saveOrUploadPromotionBox(promotionBoxForm.getBox3());

        }catch (Exception ex)

        {
            ex.printStackTrace();
        }
    }

    @Override
    public void uploadAllLargeBoxex(HttpServletRequest request, LargeBoxForm largeBoxForm) {
        try {
            String box1_imageName ="1_larg.jpg";
            String box2_imageName ="2_larg.jpg";
            String box3_imageName ="3_larg.jpg";

            //Setting unique name for All Promotion BOxes
            largeBoxForm.getBox1().setImageName(box1_imageName);
            largeBoxForm.getBox2().setImageName(box2_imageName);
            largeBoxForm.getBox3().setImageName(box3_imageName);

            //Uploading All Images for Boxe
            if(!new Long(0).equals(largeBoxForm.getBox1().getImageFile().getSize()))
                uploadAnyFileIntoServer(request,largeBoxForm.getBox1().getImageFile(),box1_imageName);
            if(!new Long(0).equals(largeBoxForm.getBox2().getImageFile().getSize()))
                uploadAnyFileIntoServer(request,largeBoxForm.getBox2().getImageFile(),box2_imageName);
            if(!new Long(0).equals(largeBoxForm.getBox3().getImageFile().getSize()))
                uploadAnyFileIntoServer(request,largeBoxForm.getBox3().getImageFile(),box3_imageName);

            //Saving Boxes Prorerties heading/description/url. ect.
            uploadFileDao.saveOrUploadLargeBox(largeBoxForm.getBox1());
            uploadFileDao.saveOrUploadLargeBox(largeBoxForm.getBox2());
            uploadFileDao.saveOrUploadLargeBox(largeBoxForm.getBox3());

        }catch (Exception ex)

        {
            ex.printStackTrace();
        }
    }

    @Override
    public String getUniqueFileName() {

        UUID uuid = UUID.randomUUID();
        String randomUUIDString = uuid.toString();
        randomUUIDString = randomUUIDString + ".jpg";
        String uniqueFileName = randomUUIDString.replaceAll("-", "");
        return uniqueFileName;
    }

    @Override
    public List<PromotionBox> getListOfAllPromotionBoxesOrderedById() {
        return uploadFileDao.getListOfAllPromotionBoxesOrderedById();
    }

    @Override
    public List<LargeBox> getListOfAllLargeBoxesOrderedById() {
        return uploadFileDao.getListOfAllLargeBoxesOrderedById();
    }


}
