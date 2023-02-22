package havryliuk.module3.dto;

import havryliuk.module3.util.DateUtil;
import lombok.*;

import java.util.Date;
import java.util.Formatter;

@Getter
@AllArgsConstructor
public class StudentDTO {
    private String id;
    private String name;
    private String surname;
    private int age;
    private Date entryDate;
    private double averageGrade;

    @Override
    public String toString() {
        return "Student's name: " + name
                + "; surname: " + surname
                + "; age: " + age
                + "; date of entry: " + DateUtil.formatDate(entryDate)
                + "; average grade: " + new Formatter().format("%.2f", averageGrade)
                + "\n";
    }
}
