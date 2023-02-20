package havryliuk.module3.repository;

import havryliuk.module3.DTO.GradeDTO;
import havryliuk.module3.entity.*;
import havryliuk.module3.util.HibernateFactoryUtil;

import javax.persistence.EntityManager;
import javax.persistence.criteria.*;
import java.util.List;
import java.util.Optional;

public class SubjectRepository {
    private enum SortingType {ASC, DESC};

    public List<Subject> getAll() {
        EntityManager entityManager = HibernateFactoryUtil.getEntityManager();
        return entityManager.createQuery("FROM Subject", Subject.class)
                .getResultList();
    }

    public Optional<GradeDTO> getSubjectWithWorstGrade() {
        return getWithWorstOrBestGrade(SortingType.ASC);
    }

    public Optional<GradeDTO> getSubjectWithBestGrade() {
        return getWithWorstOrBestGrade(SortingType.DESC);
    }

    public Optional<GradeDTO> getWithWorstOrBestGrade(SortingType sortingType) {
        final EntityManager entityManager = HibernateFactoryUtil.getEntityManager();
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<GradeDTO> criteriaQuery = criteriaBuilder.createQuery(GradeDTO.class);
        Root<Grade> grade = criteriaQuery.from(Grade.class);
        Join<Object, Object> subjects = grade.join("subject", JoinType.INNER);
        Expression<Double> avg = criteriaBuilder.avg(grade.get("value"));
        criteriaQuery.multiselect(
                subjects.get("id"),
                subjects.get("name"),
                avg);
        criteriaQuery.groupBy(
                subjects.get("id"),
                subjects.get("name"));

        criteriaQuery.orderBy((sortingType.equals(SortingType.ASC))
                ? criteriaBuilder.asc(subjects.get("name"))
                : criteriaBuilder.desc(subjects.get("name")));

        GradeDTO gradeDTO = entityManager.createQuery(criteriaQuery)
                .setMaxResults(1).getSingleResult();
        return Optional.of(gradeDTO);
    }

}
