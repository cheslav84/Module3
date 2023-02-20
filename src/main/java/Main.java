import havryliuk.module3.DTO.GradeDTO;
import havryliuk.module3.DTO.StudentDTO;
import havryliuk.module3.entity.*;
import havryliuk.module3.presenter.Actions;
import havryliuk.module3.presenter.UserInput;
import havryliuk.module3.repository.GroupRepository;
import havryliuk.module3.repository.PersonRepository;
import havryliuk.module3.repository.SubjectRepository;
import havryliuk.module3.service.Service;
import havryliuk.module3.util.DateCreator;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        SubjectRepository subjectRepository = new SubjectRepository();
        GroupRepository groupRepository = new GroupRepository();
        PersonRepository personRepository = new PersonRepository();
        Service service = new Service();




        String dateString = "2022-02-19";
        Date entryDate = DateCreator.createDate(dateString);
        String name = "Джоннні";
        String surname = "Депп";
        int age = 35;
        Group group = groupRepository.getByName("B-Level").orElseThrow();
//INSERT INTO student (id, entry_date, class_id) VALUES ('a3540720-d99c-4088-a4f1-6898d8e35695', '2022-10-16', 'e6923c19-b0f9-4e2b-a3a7-e67e305e0ffa');
        Set<Grade> grades;
//INSERT INTO grade (id, value, student_id, subject_id) VALUES ('c76d1b7e-9080-439f-aabc-1598ef3b8cc6', '8', 'a3540720-d99c-4088-a4f1-6898d8e35695', '8a0fce0f-f714-4035-9e94-5018ec98ba9c');

        Student student = Student.builder()
                .entryDate(entryDate)
                .name(name)
                .surname(surname)
                .age(age)
                .group(group)
                .build();



        final Actions[] values = Actions.values();
        final String[] names = Actions.mapAction();

        while (true) {
            final int userChoice = UserInput.menu(names);
            values[userChoice].execute(service);
        }

    }
}
