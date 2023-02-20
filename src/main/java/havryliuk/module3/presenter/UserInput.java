package havryliuk.module3.presenter;

import havryliuk.module3.entity.Group;
import havryliuk.module3.service.Service;
import havryliuk.module3.util.DateUtil;
import lombok.SneakyThrows;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.util.Date;
import java.util.List;

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



    public static Group groupChoosingMenu(List<Group> groups) {
        LOG.info("\nChoose a group for the student:");
        String[] menu = new String[groups.size()];
        for (int i = 0; i < groups.size(); i++) {
            menu[i] = groups.get(i).getName();
        }
        int userChoice = UserInput.menu(menu);
        while (userChoice < 0 | userChoice > groups.size()) {
            LOG.info("\nThe data should be between 0 and {}", groups.size());
            userChoice = UserInput.menu(menu);
        }
        return groups.get(userChoice);
    }

    public static int readUserAge() {
        int age = readInt();
        while (age < 16 | age > 40) {
            LOG.info("\nAge should be among 16 and 40 years:");
            age = readInt();
        }
        return age;
    }

    public static Date readEntryDate() {
        LOG.info("\nEnter a date of entering courses in a format yyyy-MM-dd:");
        Date entryDate = null;
        boolean correctDate;
        do {
            String dateString = UserInput.readString();
            try {
                entryDate = DateUtil.createDate(dateString);
                correctDate = true;
            } catch (ParseException e) {
                LOG.info("\nEnter a correct date in a format yyyy-MM-dd:");
                correctDate = false;
            }
        } while (!correctDate);
        return entryDate;
    }



    public static int getGradeForSubjectMenu(String subject, int maxGrade) {
        int gradeValue;
        do {
            LOG.info("\nEnter the grade for {} from 0 to {}", subject, maxGrade);
            gradeValue = UserInput.readInt();
        } while (gradeValue < 0 || gradeValue > maxGrade);
        return gradeValue;
    }



    public static boolean yesOrNotMenu() {
        String[] yesNotMenu = {"Yes", "Not"};
        int userChoice = UserInput.menu(yesNotMenu);
        while (userChoice != 0 && userChoice != 1) {
            LOG.info("\nPick 0 or 1");
            userChoice = UserInput.menu(yesNotMenu);
        }
        return userChoice == 0;
    }



    public static int readInt() {
        String line;
        do {
            try {
                line = READER.readLine().trim();
            } catch (IOException e) {
                LOG.info("\nData is not correct.");
                throw new RuntimeException(e);
            }
        } while (!StringUtils.isNumeric(line));
        return Integer.parseInt(line);
    }


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
