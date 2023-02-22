package havryliuk.module3.presenter.actions;

import havryliuk.module3.dto.GradeDTO;
import havryliuk.module3.presenter.Action;
import havryliuk.module3.presenter.UserInput;
import havryliuk.module3.service.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Optional;

public class ShowWorstGradedSubject implements Action {
    private static final Logger LOG = LoggerFactory.getLogger(ShowWorstGradedSubject.class);

    @Override
    public void execute(Service service) {
        final Optional<GradeDTO> grade = service.getWorstGradedSubject();
        grade.ifPresentOrElse(g -> LOG.info("\nThe worst graded subject with grade: \n{}",g),
                () -> LOG.info("\nNo one subject has been found."));
        UserInput.subMenu();
    }
}
