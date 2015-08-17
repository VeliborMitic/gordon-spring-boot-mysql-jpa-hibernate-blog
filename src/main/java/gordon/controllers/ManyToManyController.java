package gordon.controllers;

import gordon.models.many_to_many.Student;
import gordon.models.many_to_many.Teacher;
import gordon.models.many_to_many.dao.StudentDAO;
import gordon.models.many_to_many.dao.TeacherDAO;
import gordon.models.one_to_many.Address;
import gordon.models.one_to_many.Person;
import gordon.models.one_to_many.dao.AddressDAO;
import gordon.models.one_to_many.dao.PersonDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("many2many")
public class ManyToManyController {

    @RequestMapping("/")
    @ResponseBody
    public String index() {
        return "this is the many to many route index";
    }

    @RequestMapping("/create")
    @ResponseBody
    public String create() {
        try {
            Teacher teacher = new Teacher("teacher luo");
            Student student = new Student("student luo");
            Student student1 = new Student("student another");
            teacher.addStudent(student);
            teacher.addStudent(student1);
            student.addTeacher(teacher);
            student1.addTeacher(teacher);
            studentDAO.save(student);
            studentDAO.save(student1);
        } catch (Exception ex) {
            return "Error creating the user: " + ex.toString();
        }
        return "Teacher and student are succesfully created!";
    }

    @RequestMapping("/delete_student")
    @ResponseBody
    public String deleteStudent(long id) {
        try {
            Student student = studentDAO.findOne(id);
            studentDAO.delete(student);
        } catch (Exception ex) {
            return "Error creating the user: " + ex.toString();
        }
        return "Person is succesfully removed!";
    }

    @RequestMapping("/add_student")
    @ResponseBody
    public String addStudent(long id,String name) {
        try {
            Teacher teacher = teacherDAO.findOne(id);
            Student student = new Student(name);
            student.addTeacher(teacher);
            teacher.addStudent(student);
            studentDAO.save(student);
        } catch (Exception ex) {
            return "Error creating the user: " + ex.toString();
        }
        return "Person is succesfully removed!";
    }

    @RequestMapping("/add_teacher")
    @ResponseBody
    public String addTeacher(long id,String name) {
        try {
            Student student = studentDAO.findOne(id);
            Teacher teacher = new Teacher(name);
            student.addTeacher(teacher);
            studentDAO.save(student);
        } catch (Exception ex) {
            return "Error creating the user: " + ex.toString();
        }
        return "Person is succesfully removed!";
    }

    @RequestMapping("/delete_teacher")
    @ResponseBody
    public String deleteTeacher(long id) {
        try {
            Teacher teacher = teacherDAO.findOne(id);
            teacherDAO.delete(teacher);
        } catch (Exception ex) {
            return "Error creating the user: " + ex.toString();
        }
        return "Address is succesfully removed!";
    }

    @Autowired
    private StudentDAO studentDAO;

    @Autowired
    private TeacherDAO teacherDAO;

}
