import havryliuk.module3.model.Group;
import havryliuk.module3.model.Subject;
import havryliuk.module3.repository.GroupRepository;
import havryliuk.module3.repository.SubjectRepository;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        SubjectRepository subjectRepository = new SubjectRepository();
        List<Subject> subjects = subjectRepository.getAll();

        System.out.println(subjects);

        GroupRepository groupRepository = new GroupRepository();
        List<Group> groups = groupRepository.getAll();

        System.out.println(groups);
    }
}
