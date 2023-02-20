package havryliuk.module3.entity;

import lombok.*;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Getter
@Setter
@SuperBuilder
@AllArgsConstructor
@ToString
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Person implements UniversityEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @ToString.Exclude
    private String id;
    private String name;
    private String surname;
    private int age;

    public Person() {
    }
}
