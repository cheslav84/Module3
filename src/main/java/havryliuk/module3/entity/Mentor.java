package havryliuk.module3.entity;

import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;


@Getter
@Setter
@SuperBuilder
@AllArgsConstructor
@ToString(callSuper=true)
@Entity
public class Mentor extends Person {

    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "subject_id")
    private Subject subject;

    public Mentor() {
        super();
    }

//    @Builder
//    public Mentor(String id, String name, String surname, int age) {
//        super(id, name, surname, age);
//    }
}
