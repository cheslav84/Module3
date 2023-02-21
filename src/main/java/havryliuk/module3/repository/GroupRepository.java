package havryliuk.module3.repository;

import havryliuk.module3.DTO.GradeDTO;
import havryliuk.module3.entity.Group;
import havryliuk.module3.util.HibernateFactoryUtil;

import javax.persistence.EntityManager;
import javax.persistence.criteria.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupRepository {


    public List<Group> getAll() {
        EntityManager entityManager = HibernateFactoryUtil.getEntityManager();
        return entityManager.createQuery("FROM class", Group.class)
                .getResultList();
    }

    public List<Group> getByPartOfName(String partOfName) {
        String likeCriteria = "%" + partOfName + "%";
        final EntityManager entityManager = HibernateFactoryUtil.getEntityManager();
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Group> criteriaQuery = criteriaBuilder.createQuery(Group.class);
        Root<Group> root = criteriaQuery.from(Group.class);
        criteriaQuery.select(root);
        criteriaQuery.where(criteriaBuilder.like(root.get("name"), likeCriteria));
        return entityManager.createQuery(criteriaQuery)
                .getResultList();
    }


    @SuppressWarnings("unchecked")
    public Map<String, Long> getStudentsAmountByGroups() {
        final EntityManager entityManager = HibernateFactoryUtil.getEntityManager();
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Object[]> criteriaQuery = criteriaBuilder.createQuery(Object[].class);
        Root<Group> group = criteriaQuery.from(Group.class);
        Join<Object, Object> students = group.join("students", JoinType.INNER);
        criteriaQuery.multiselect(group.get("name"), criteriaBuilder.count(students));
        criteriaQuery.groupBy(group);
        List<Object[]> studentCounts = entityManager.createQuery(criteriaQuery).getResultList();
        return (Map<String, Long>) mapResult(studentCounts);
    }


    public List<GradeDTO> getGroupsAverageGrade() {
        final EntityManager entityManager = HibernateFactoryUtil.getEntityManager();
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<GradeDTO> criteriaQuery = criteriaBuilder.createQuery(GradeDTO.class);
        Root<Group> group = criteriaQuery.from(Group.class);
        Join<Object, Object> students = group.join("students", JoinType.INNER);
        Join<Object, Object> grades = students.join("grades", JoinType.INNER);
        Expression<Double> avg = criteriaBuilder.avg(grades.get("value"));
        criteriaQuery.multiselect(group.get("id"), group.get("name"), avg);
        criteriaQuery.groupBy(group.get("id"), group.get("name"));
        return entityManager.createQuery(criteriaQuery).getResultList();
    }

    private Map<String, ? extends Number> mapResult(List<Object[]> resultList) {
        Map<String, Number> map = new HashMap<>();
        for (Object[] obj : resultList) {
            if (obj[0] != null && obj[1] != null) {
                map.put((String) obj[0], (Number) obj[1]);
            }
        }
        return map;
    }


}
