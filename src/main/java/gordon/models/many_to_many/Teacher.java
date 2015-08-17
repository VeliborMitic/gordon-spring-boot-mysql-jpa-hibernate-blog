package gordon.models.many_to_many;

import javax.persistence.*;

/**
 * Created by gordon on 8/17/15.
 */
@Entity
@Table(name = "teachers")
public class Teacher {
    public Teacher() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    public Teacher(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
