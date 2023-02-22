import havryliuk.module3.presenter.Actions;
import havryliuk.module3.presenter.UserInput;
import havryliuk.module3.presenter.actions.FindMentorsByNameOrSurname;
import havryliuk.module3.service.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {
    private static final Logger LOG = LoggerFactory.getLogger(FindMentorsByNameOrSurname.class);

    public static void main(String[] args) {
        LOG.debug("Program is started.");
        Service service = new Service();
        final Actions[] actions = Actions.values();
        final String[] actionNames = Actions.mapAction();

        //noinspection InfiniteLoopStatement
        while (true) {
            final int userChoiceNumber = UserInput.menu(actionNames);
            actions[userChoiceNumber].execute(service);
        }

    }
}
