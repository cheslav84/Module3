package havryliuk.module3.repository;

import havryliuk.module3.model.Subject;
import havryliuk.module3.util.HibernateFactoryUtil;

import javax.persistence.EntityManager;
import java.util.List;

public class SubjectRepository {

    public List<Subject> getAll() {
        EntityManager entityManager = HibernateFactoryUtil.getEntityManager();
        return entityManager.createQuery("FROM Subject", Subject.class)
                .getResultList();
    }
}
