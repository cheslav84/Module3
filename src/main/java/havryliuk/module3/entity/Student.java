package havryliuk.module3.entity;

import lombok.*;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Getter
@Setter
@SuperBuilder
@AllArgsConstructor
@ToString(callSuper=true)
@Entity
public class Student extends Person {

    @Column(name = "entry_date")
    private Date entryDate;

    @ManyToOne
    @JoinColumn(name = "class_id")
    private Group group;

    @ToString.Exclude
    @OnDelete(action = OnDeleteAction.CASCADE)
    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Grade> grades;

    public Student() {
        super();
    }

//    @Builder
//    public Student(String id, String name, String surname, int age, Date entryDate, Group group, Set<Grade> grades) {
//        super(id, name, surname, age);
//        this.entryDate = entryDate;
//        this.group = group;
//        this.grades = grades;
//    }


}
