package havryliuk.module3.service;

import havryliuk.module3.DTO.GradeDTO;
import havryliuk.module3.DTO.StudentDTO;
import havryliuk.module3.entity.Group;
import havryliuk.module3.entity.Mentor;
import havryliuk.module3.entity.Student;
import havryliuk.module3.entity.Subject;
import havryliuk.module3.repository.GroupRepository;
import havryliuk.module3.repository.PersonRepository;
import havryliuk.module3.repository.SubjectRepository;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public class Service {
    private final SubjectRepository subjectRepository = new SubjectRepository();
    private final GroupRepository groupRepository = new GroupRepository();
    private final PersonRepository personRepository = new PersonRepository();


    public List<Group> getGroupByPartOfName(String partOfName) {
        return groupRepository.getByPartOfName(partOfName);
    }

    public Map<String, Long> getStudentCountsByGroups() {
        return groupRepository.getStudentsAmountByGroups();
    }

    public List<GradeDTO> getGroupsAverageGrade() {
        return groupRepository.getGroupsAverageGrade();
    }

    public List<Mentor> getMentorsByNameOrSurname(String nameOrSurname) {
        return personRepository.getByNameOrSurname(nameOrSurname);
    }

    public List<StudentDTO> getStudentsWithAvgGradeAbove(double score) {
        return personRepository.getWithAvgGradeAbove(score);
    }

    public Optional<GradeDTO> getWorstGradedSubject() {
        return subjectRepository.getSubjectWithWorstGrade();
    }

    public Optional<GradeDTO> getBestGradedSubject() {
        return subjectRepository.getSubjectWithBestGrade();
    }

    public List<Group> getAllGroups() {
        return groupRepository.getAll();
    }

    public List<Subject> getAllSubjects() {
        return subjectRepository.getAll();
    }

    public void saveStudent(Student student) {
        personRepository.save(student);
    }

}
