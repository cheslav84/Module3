package havryliuk.module3.repository;

import havryliuk.module3.model.Group;
import havryliuk.module3.util.HibernateFactoryUtil;

import javax.persistence.EntityManager;
import java.util.List;

public class GroupRepository {

    public List<Group> getAll() {
        EntityManager entityManager = HibernateFactoryUtil.getEntityManager();
        return entityManager.createQuery("FROM class", Group.class)
                .getResultList();
    }
}
