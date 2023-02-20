package havryliuk.module3.presenter;

import havryliuk.module3.presenter.actions.*;
import havryliuk.module3.service.Service;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;

@Getter
@AllArgsConstructor
public enum Actions {
    FIND_GROUP_BY_PART_OF_NAME("Find student's group", new FindGroupByPartOfName()),
    SHOW_GROUPS_AVERAGE_GRADES("Show group's average grades", new ShowGroupsAverageGrade()),
    SHOW_STUDENTS_AMOUNT_BY_GROUPS("Show students amount by groups", new ShowStudentsAmountByGroups()),
    GET_MENTORS_BY_NAME_OR_SURNAME("Find mentors by name or surname", new FindMentorsByNameOrSurname()),
    GET_STUDENTS_WITH_AVG_GRADE_ABOVE("Find students with average grade above defined value",
            new FindStudentsWithAvgGradeAbove()),
    GET_WORST_GRADED_SUBJECT("Find the worst graded subject", new ShowWorstGradedSubject()),
    GET_BEST_GRADED_SUBJECT("Find the best graded subject", new ShowBestGradedSubject()),
    CREATE_NEW_STUDENT("Create new student", new CreateNewStudent()),
    EXIT("End the program", new EndProgram());

    private final String name;
    private final Action action;

    public void execute(Service service) {
        action.execute(service);
    }

    public static String[] mapAction() {
        return Arrays.stream(Actions.values())
                .map(Actions::getName)
                .toArray(String[]::new);
    }
}

