package havryliuk.module3.DTO;

import lombok.*;

import java.util.Date;

@Getter
@ToString
@AllArgsConstructor
public class StudentDTO {
    private String id;
    private String name;
    private String surname;
    private int age;
    private Date entryDate;
    private double averageGrade;
}
