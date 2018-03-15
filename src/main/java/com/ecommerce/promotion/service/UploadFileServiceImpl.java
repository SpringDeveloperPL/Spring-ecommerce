package com.ecommerce.promotion.service;

import com.ecommerce.promotion.dao.UploadFileDao;
import com.ecommerce.promotion.domain.PromotionBoxForm;
import com.ecommerce.promotion.domain.SlideshowForm;
import com.ecommerce.promotion.domain.SlideshowImage;
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
            uploadAnyFileIntoServer(request,promotionBoxForm.getBox1().getImageFile(),getUniqueFileName());
            uploadAnyFileIntoServer(request,promotionBoxForm.getBox2().getImageFile(),getUniqueFileName());
            uploadAnyFileIntoServer(request,promotionBoxForm.getBox3().getImageFile(),getUniqueFileName());
            uploadFileDao.saveOrUploadPromotionBox(promotionBoxForm.getBox1());
            uploadFileDao.saveOrUploadPromotionBox(promotionBoxForm.getBox2());
            uploadFileDao.saveOrUploadPromotionBox(promotionBoxForm.getBox3());

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



}
