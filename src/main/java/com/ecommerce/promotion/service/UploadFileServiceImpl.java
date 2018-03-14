package com.ecommerce.promotion.service;

import com.ecommerce.promotion.dao.UploadFileDao;
import com.ecommerce.promotion.domain.SlideshowForm;
import com.ecommerce.promotion.domain.SlideshowImage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.List;

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
}
