package havryliuk.module3.presenter.actions;

import havryliuk.module3.DTO.StudentDTO;
import havryliuk.module3.presenter.Action;
import havryliuk.module3.presenter.UserInput;
import havryliuk.module3.service.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class FindStudentsWithAvgGradeAbove implements Action {
    private static final Logger LOG = LoggerFactory.getLogger(FindStudentsWithAvgGradeAbove.class);

    @Override
    public void execute(Service service) {
        LOG.info("\nEnter the grade:");
        double grade = UserInput.readDouble();
        List<StudentDTO> students = service.getStudentsWithAvgGradeAbove(grade);
        if (students.size() > 1) {
            LOG.info("\nFound the following students with score above {}: \n{}", grade, students);
            UserInput.subMenu();
        } else if (students.size() == 1) {
            LOG.info("\nFound the student by your request: \n{}", students.get(0));
            UserInput.subMenu();
        } else {
            LOG.info("\nNo one student has such grade or above.");
            UserInput.subMenu(new FindStudentsWithAvgGradeAbove(), service);
        }
    }
}
