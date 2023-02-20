package havryliuk.module3.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Formatter;

@Getter
@AllArgsConstructor
public class GradeDTO {
    private String id;
    private String name;
    private double averageGrade;

    @Override
    public String toString() {
        return "Subject: " + name
                + "; with average grade = "
                + new Formatter().format("%.2f", averageGrade)
                + "\n";
    }
}
