package havryliuk.module3.presenter;

import havryliuk.module3.service.Service;
import lombok.SneakyThrows;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class UserInput {
    private static final Logger LOG = LoggerFactory.getLogger(UserInput.class);

    private static final BufferedReader READER =
            new BufferedReader(new InputStreamReader(System.in));

    @SneakyThrows
    public static int menu(final String[] names) {
        int userChoice = -1;
        do {
            LOG.info("Choose the option: ");
            for (int i = 0; i < names.length; i++) {
                LOG.info("{} {}",i , names[i]);
            }
            final String line = READER.readLine();
            if (!StringUtils.isNumeric(line)) {
                continue;
            }
            userChoice = Integer.parseInt(line);
        } while (userChoice < 0 || userChoice >= names.length);
        return userChoice;
    }


    public static void subMenu(Action action, Service service) {
        String[] menu = {"Try again", "Main menu", "Exit"};
        final int userChoice = UserInput.menu(menu);
        switch (userChoice){
            case 0 -> action.execute(service);
            case 1 -> LOG.debug("\nGoing to main menu.");
            case 2 -> System.exit(0);
        }
    }

    public static void subMenu() {
        String[] menu = {"Main menu", "Exit"};
        final int userChoice = UserInput.menu(menu);
        switch (userChoice){
            case 0 -> LOG.debug("\nGoing to main menu.");
            case 1 -> System.exit(0);
        }
    }

//    public static int readInt() {
//        String line;
//        do {
//            try {
//                line = READER.readLine().trim();
//            } catch (IOException e) {
//                throw new RuntimeException(e);
//            }
//        } while (!StringUtils.isNumeric(line));
//
//        return Integer.parseInt(line);
//    }


    public static double readDouble() {
        String line;
        do {
            try {
                line = READER.readLine().trim();
                line = line.replace(",", ".");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } while (!StringUtils.isNumeric(line));
        return Double.parseDouble(line);
    }

    public static String readString() {
        String line;
        do {
            try {
                line = READER.readLine();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } while (line.isEmpty());
        return line;
    }
}
