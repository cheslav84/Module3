package havryliuk.module3.presenter.actions;

import havryliuk.module3.entity.Student;
import havryliuk.module3.presenter.Action;
import havryliuk.module3.presenter.UserInput;
import havryliuk.module3.service.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class ShowAllStudents implements Action {
    private static final Logger LOG = LoggerFactory.getLogger(ShowAllStudents.class);

    @Override
    public void execute(Service service) {
        final List<Student> students = service.getAllStudents();
        if (students.size() > 1) {
            LOG.info("\nFound the following students \n{}", students);
        } else if (students.size() == 1) {
            LOG.info("\nFound the student by your request: \n{}", students.get(0));
        } else {
            LOG.info("\nNo one student has been found.");
        }
        UserInput.subMenu();
    }





}
