package havryliuk.module3.repository;

import havryliuk.module3.entity.UniversityEntity;
import havryliuk.module3.util.HibernateFactoryUtil;

import javax.persistence.EntityManager;

class EntitySaver {
     static void save(UniversityEntity entity){
        EntityManager entityManager = HibernateFactoryUtil.getEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(entity);
        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
