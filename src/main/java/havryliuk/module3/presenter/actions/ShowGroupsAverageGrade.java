package havryliuk.module3.presenter.actions;

import havryliuk.module3.dto.GradeDTO;
import havryliuk.module3.presenter.Action;
import havryliuk.module3.presenter.UserInput;
import havryliuk.module3.service.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class ShowGroupsAverageGrade implements Action {
    private static final Logger LOG = LoggerFactory.getLogger(ShowGroupsAverageGrade.class);

    @Override
    public void execute(Service service) {
        final List<GradeDTO> groupsAverageGrade = service.getGroupsAverageGrade();
        if (groupsAverageGrade.size() > 1) {
            LOG.info("\nThere are following average grades of groups: \n{}", groupsAverageGrade);
        } else {
            LOG.info("\nThere is no any groups yet.");
        }
        UserInput.subMenu();
    }
}
