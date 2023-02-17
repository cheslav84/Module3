package havryliuk.module3.model;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Getter
@Setter
@Entity
public class Student extends Person {

    private Date enteringDate;

    @ManyToOne
    @JoinColumn(name = "group_id")
    private Group group;

    @OnDelete(action = OnDeleteAction.CASCADE)
    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<Grade> grades;

}
