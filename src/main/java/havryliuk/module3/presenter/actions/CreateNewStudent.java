package havryliuk.module3.presenter.actions;

import havryliuk.module3.entity.Grade;
import havryliuk.module3.entity.Group;
import havryliuk.module3.entity.Student;
import havryliuk.module3.entity.Subject;
import havryliuk.module3.presenter.Action;
import havryliuk.module3.presenter.UserInput;
import havryliuk.module3.service.Service;
import havryliuk.module3.util.DateUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CreateNewStudent implements Action {
    private static final Logger LOG = LoggerFactory.getLogger(CreateNewStudent.class);
    private static final int MAX_GRADE_VALUE = 10;

    @Override
    public void execute(Service service) {
        LOG.info("\nEnter a name of the student:");
        String name = UserInput.readString();
        LOG.info("\nEnter a surname of the student:");
        String surname = UserInput.readString();
        LOG.info("\nEnter an age of the student:");
        int age = UserInput.readUserAge();
        Date entryDate = UserInput.readEntryDate();
        List<Group> groups = service.getAllGroups();
        Group group = UserInput.groupChoosingMenu(groups);
        Set<Grade> grades = new HashSet<>();
        Student student = Student.builder()
                .entryDate(entryDate)
                .name(name)
                .surname(surname)
                .age(age)
                .group(group)
                .grades(grades)
                .build();
        group.getStudents().add(student);
        setGrades(service, grades, student);
        service.saveStudent(student);
    }

    private void setGrades(Service service, Set<Grade> grades, Student student) {
        LOG.info("\nDo you want to set grades for student?");
        List<Subject> subjects;
        if (UserInput.yesOrNotMenu()){
            subjects = service.getAllSubjects();
            for (Subject subject : subjects) {
                setSingleGrade(grades, student, subject);
            }
        }
    }

    private void setSingleGrade(Set<Grade> grades, Student student, Subject subject) {
        LOG.info("\nDo you want to set {} grade?", subject.getName());
        if (UserInput.yesOrNotMenu()){
            int gradeValue = UserInput.getGradeForSubjectMenu(subject.getName(), MAX_GRADE_VALUE);
            Grade grade = Grade.builder()
                    .student(student)
                    .subject(subject)
                    .value(gradeValue)
                    .build();
            grades.add(grade);
        }
    }


}
