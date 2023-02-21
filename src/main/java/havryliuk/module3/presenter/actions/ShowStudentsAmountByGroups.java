package havryliuk.module3.presenter.actions;

import havryliuk.module3.presenter.Action;
import havryliuk.module3.presenter.UserInput;
import havryliuk.module3.service.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Iterator;
import java.util.Map;

public class ShowStudentsAmountByGroups implements Action {
    private static final Logger LOG = LoggerFactory.getLogger(ShowStudentsAmountByGroups.class);

    @Override
    public void execute(Service service) {
        final Map<String, Long> studentsAmountByGroups = service.getStudentCountsByGroups();
        if (studentsAmountByGroups.size() > 1) {
            LOG.info("\nThere are following students amount in the groups: \n{}",
                    formatStudentsAmountByGroups(studentsAmountByGroups));
        } else if (studentsAmountByGroups.size() == 1) {
            Map.Entry<String,Long> entry = studentsAmountByGroups.entrySet().iterator().next();
            LOG.info("\nThere are(is) {} student(s) in the {} group.", entry.getValue(), entry.getKey());
        } else {
            LOG.info("\nThere is no any student in groups yet.");
        }
        UserInput.subMenu();
    }

    private String formatStudentsAmountByGroups (Map<String, Long> studentsAmountByGroups){
        final Iterator<Map.Entry<String, Long>> iterator = studentsAmountByGroups.entrySet().iterator();
        final StringBuilder builder = new StringBuilder();
        while (iterator.hasNext()) {
            Map.Entry<String,Long> entry = iterator.next();
            builder.append("Group ")
                    .append(entry.getKey())
                    .append(" has ")
                    .append(entry.getValue())
                    .append(" student(s)\n");
        }
        return builder.toString();
    }
}
