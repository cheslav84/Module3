package havryliuk.module3.repository;

import havryliuk.module3.dto.StudentDTO;

import havryliuk.module3.entity.Mentor;
import havryliuk.module3.entity.Person;
import havryliuk.module3.entity.Student;
import havryliuk.module3.util.HibernateFactoryUtil;

import javax.persistence.EntityManager;
import javax.persistence.criteria.*;
import java.util.List;

public class PersonRepository {

    public void save(Person person) {
        EntitySaver.save(person);
    }

    public List<Student> getAllStudents() {
        EntityManager entityManager = HibernateFactoryUtil.getEntityManager();
        return entityManager.createQuery("FROM Student", Student.class)
                .getResultList();
    }


    public List<Mentor> getByNameOrSurname(String nameOrSurname) {
        final EntityManager entityManager = HibernateFactoryUtil.getEntityManager();
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Mentor> criteriaQuery = criteriaBuilder.createQuery(Mentor.class);
        Root<Mentor> mentor = criteriaQuery.from(Mentor.class);
        criteriaQuery.select(mentor);
        Predicate name = criteriaBuilder.equal(mentor.get("name"), nameOrSurname);
        Predicate surname = criteriaBuilder.equal(mentor.get("surname"), nameOrSurname);
        criteriaQuery.where(criteriaBuilder.or(name, surname));
        return entityManager.createQuery(criteriaQuery).getResultList();
    }

    public List<StudentDTO> getWithAvgGradeAbove(double value) {
        final EntityManager entityManager = HibernateFactoryUtil.getEntityManager();
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<StudentDTO> criteriaQuery = criteriaBuilder.createQuery(StudentDTO.class);
        Root<Student> student = criteriaQuery.from(Student.class);
        Join<Object, Object> grades = student.join("grades", JoinType.INNER);
        Expression<Double> avgGrade = criteriaBuilder.avg(grades.get("value"));

        criteriaQuery.multiselect(
                student.get("id"),
                student.get("name"),
                student.get("surname"),
                student.get("age"),
                student.get("entryDate"),
                avgGrade
        );
        criteriaQuery.groupBy(
                student.get("id"),
                student.get("name"),
                student.get("surname"),
                student.get("age"),
                student.get("entryDate")
        );
        criteriaQuery.having(criteriaBuilder.greaterThan(avgGrade, value));
        return entityManager.createQuery(criteriaQuery).getResultList();
    }

}
