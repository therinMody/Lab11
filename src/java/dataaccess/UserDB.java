package dataaccess;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import models.Note;
import models.User;


public class UserDB {
    public User get(String email) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        
        try {
            User user = em.find(User.class, email);
            return user;
        } finally {
            em.close();
        }
    }
    
    public User getByUUID(String uuid) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        
        try {
            //this is wrong and where it gets stuck
            User user = (User) em.createQuery("SELECT u FROM User u WHERE u.resetPasswordUuid = :resetPasswordUuid")
                    .setParameter("resetPasswordUuid", uuid).getSingleResult();
            return user;
        } finally {
            em.close();
        }
    }
    
    public void update(User user) throws Exception {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        
        try {
            trans.begin();
            em.merge(user);
            trans.commit();
        } catch (Exception ex) {
            trans.rollback();
        } finally {
            em.close();
        }
    }
}
