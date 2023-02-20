package havryliuk.module3.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@AllArgsConstructor
public class GradeDTO {
    private String id;
    private String name;
    private double averageGrade;
}
