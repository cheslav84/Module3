package havryliuk.module3.presenter.actions;

import havryliuk.module3.entity.Group;
import havryliuk.module3.presenter.Action;
import havryliuk.module3.presenter.UserInput;
import havryliuk.module3.service.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class FindGroupByPartOfName implements Action {
    private static final Logger LOG = LoggerFactory.getLogger(FindGroupByPartOfName.class);

    @Override
    public void execute(Service service) {
        LOG.info("\nEnter the name of group (whole name of part of it):");
        final String groupName = UserInput.readString();
        final List<Group> groups = service.getGroupByPartOfName(groupName);
        if (groups.size() > 1) {
            LOG.info("\nFound the following groups: \n{}", groups);
            UserInput.subMenu();
        } else if (groups.size() == 1) {
            LOG.info("\nFound one group by your request: \n{}", groups.get(0));
            UserInput.subMenu();
        } else {
            LOG.info("\nAny of groups doesn't contains such name.");
            UserInput.subMenu(new FindGroupByPartOfName(), service);
        }
    }


}
