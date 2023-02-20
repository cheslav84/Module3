package havryliuk.module3.service;

import havryliuk.module3.DTO.GradeDTO;
import havryliuk.module3.DTO.StudentDTO;
import havryliuk.module3.entity.Group;
import havryliuk.module3.entity.Mentor;
import havryliuk.module3.repository.GroupRepository;
import havryliuk.module3.repository.PersonRepository;
import havryliuk.module3.repository.SubjectRepository;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public class Service {

    SubjectRepository subjectRepository = new SubjectRepository();
    GroupRepository groupRepository = new GroupRepository();
    PersonRepository personRepository = new PersonRepository();


    public List<Group> getGroupByPartOfName(String partOfName) {
        return groupRepository.getByPartOfName(partOfName);
    }

    public Map<String, Long> getStudentCountsByGroups() {
        return groupRepository.getStudentsAmountByGroups();
    }

    public Map<String, Double> getGroupsAverageGrade() {
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

}
