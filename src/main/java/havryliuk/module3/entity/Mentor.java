package havryliuk.module3.entity;

import havryliuk.module3.util.DateUtil;
import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import java.util.Formatter;


@Getter
@Setter
@SuperBuilder
@AllArgsConstructor
@Entity
public class Mentor extends Person {

    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "subject_id")
    private Subject subject;

    public Mentor() {
        super();
    }

    @Override
    public String toString() {
        return "Mentor's name: " + super.getName()
                + "; surname: " + super.getSurname()
                + "; age: " + super.getAge()
                + "; taught subject: " + subject.getName()
                + "\n";
    }
}
