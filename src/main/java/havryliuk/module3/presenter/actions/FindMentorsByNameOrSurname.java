package havryliuk.module3.presenter.actions;

import havryliuk.module3.entity.Mentor;
import havryliuk.module3.presenter.Action;
import havryliuk.module3.presenter.UserInput;
import havryliuk.module3.service.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class FindMentorsByNameOrSurname implements Action {
    private static final Logger LOG = LoggerFactory.getLogger(FindMentorsByNameOrSurname.class);

    @Override
    public void execute(Service service) {
        LOG.info("\nEnter the name or surname of mentor to find:");
        final String mentorName = UserInput.readString();
        final List<Mentor> mentors = service.getMentorsByNameOrSurname(mentorName);
        if (mentors.size() > 1) {
            LOG.info("\nFound the following mentors: \n{}", mentors);
            UserInput.subMenu();
        } else if (mentors.size() == 1) {
            LOG.info("\nFound the mentor by your request: \n{}", mentors.get(0));
            UserInput.subMenu();
        } else {
            LOG.info("\nThere is no mentor with such name or surname.");
            UserInput.subMenu(new FindMentorsByNameOrSurname(), service);
        }
    }
}
