package gordon.models.many_to_many;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by gordon on 8/17/15.
 */
@Entity
@Table(name = "teachers")
public class Teacher {
    public Teacher() {
    }

    public Teacher(String name) {
        this.name = name;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "teacher_id")
    private Long id;

    @Column(name = "teacher_name")
    private String name;

    public void addStudent(Student student) {
        if (student == null) return;
        if (this.students == null) students = new ArrayList<>();
        students.add(student);
    }

    @ManyToMany(mappedBy = "teachers", cascade = CascadeType.ALL)
    private List<Student> students;

    public Teacher(String name, List<Student> students) {
        this.name = name;
        this.students = students;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

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
