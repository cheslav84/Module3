package havryliuk.module3.presenter.actions;

import havryliuk.module3.presenter.Action;
import havryliuk.module3.service.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EndProgram implements Action {
    private static final Logger LOG = LoggerFactory.getLogger(EndProgram.class);

    @Override
    public void execute(Service service) {
        LOG.info("Program is finished");
        System.exit(0);
    }
}
