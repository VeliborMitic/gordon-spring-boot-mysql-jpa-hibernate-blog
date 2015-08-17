package gordon.controllers;

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
    return "this is the one to many route index";
  }

  @RequestMapping("/create")
  @ResponseBody
  public String create(){
    try {

    } catch (Exception ex) {
      return "Error creating the user: " + ex.toString();
    }
    return "Person is succesfully created!";
  }

  @RequestMapping("/delete_person")
  @ResponseBody
  public String deletePerson(long id){
    try {

    } catch (Exception ex) {
      return "Error creating the user: " + ex.toString();
    }
    return "Person is succesfully removed!";
  }

  @RequestMapping("/delete_address")
  @ResponseBody
  public String deleteAddress(long id){
    try {

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
