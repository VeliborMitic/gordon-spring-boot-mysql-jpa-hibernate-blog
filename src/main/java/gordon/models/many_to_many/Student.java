package gordon.models.many_to_many;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by gordon on 8/17/15.
 */
@Entity
@Table(name = "students")
public class Student {
    public Student() {
    }

    public Student(String name) {
        this.name = name;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "student_id")
    private Long id;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "teachers_students",joinColumns = @JoinColumn(name = "student_id"),inverseJoinColumns = @JoinColumn(name = "teacher_id"))
    private List<Teacher> teachers;

    @Column(name = "student_name")
    private String name;

    public Student(List<Teacher> teachers, String name) {
        this.teachers = teachers;
        this.name = name;
    }

    public void addTeacher(Teacher teacher){
        if(teacher==null) return;
        if(this.teachers==null) teachers = new ArrayList<>();
        teachers.add(teacher);
    }

    public List<Teacher> getTeachers() {
        return teachers;
    }

    public void setTeachers(List<Teacher> teachers) {
        this.teachers = teachers;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

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
