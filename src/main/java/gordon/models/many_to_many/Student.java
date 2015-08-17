package gordon.models.many_to_many;

import javax.persistence.*;

/**
 * Created by gordon on 8/17/15.
 */
@Entity
@Table(name = "students")
public class Student {
    public Student() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    public Student(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
