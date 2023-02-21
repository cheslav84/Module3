package havryliuk.module3.entity;

import havryliuk.module3.util.DateUtil;
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
@Entity
public class Student extends Person {

    @Column(name = "entry_date")
    private Date entryDate;

    @ManyToOne
    @JoinColumn(name = "class_id")
    private Group group;

    @OnDelete(action = OnDeleteAction.CASCADE)
    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Grade> grades;

    public Student() {
        super();
    }

    @Override
    public String toString() {
        return "Student's name: " + super.getName()
                + "; surname: " + super.getSurname()
                + "; age: " +  super.getAge()
                + "; date of entry: " + DateUtil.formatDate(entryDate)
                + "; group: " + group.getName()
                + "\n";
    }



}
