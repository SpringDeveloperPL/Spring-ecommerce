package com.ecommerce.promotion.dao;

import com.ecommerce.promotion.domain.PromotionBox;
import com.ecommerce.promotion.domain.SlideshowImage;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class UploadFileDaoImpl implements UploadFileDao {

    @Autowired
    SessionFactory sessionFactory;

    protected Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }


    @Override
    public void saveFile(SlideshowImage image) {
        Session session = getCurrentSession();
        session.save(image);
    }

    @Override
    public List<SlideshowImage> getAllImages() {
        return getCurrentSession().createCriteria(SlideshowImage.class).list();
    }

    @Override
    public List<SlideshowImage> getOrderedAllImages() {

        Session session = getCurrentSession();
        String hql = "FROM SlideshowImage ORDER BY orderSequence asc";
        Query query = session.createQuery(hql);
        return query.list();
    }

    @Override
    public SlideshowImage getImageById(Long id) {
        Session session = getCurrentSession();
        return session.get(SlideshowImage.class,id);
    }

    @Override
    public void removeImage(SlideshowImage image) {
        Session session = getCurrentSession();
        session.delete(image);
    }

    public void saveOrUploadPromotionBox(PromotionBox promotionBox) {
        Session session = getCurrentSession();
        session.saveOrUpdate(promotionBox);
    }
}
