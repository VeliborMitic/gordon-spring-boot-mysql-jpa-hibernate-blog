package gordon.controllers;

import gordon.models.one_to_many.Address;
import gordon.models.one_to_many.dao.AddressDAO;
import gordon.models.one_to_many.Person;
import gordon.models.one_to_many.dao.PersonDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("one2many")
public class OneToManyController {

  @RequestMapping("/")
  @ResponseBody
  public String index() {
    return "this is the one to many route index";
  }

  @RequestMapping("/create")
  @ResponseBody
  public String create(){
    try {
      Person person = new Person("gordon",25,null);
      Address address = new Address("shanghai","jiading","jiangqiao");
      person.addAddress(address);
      personDAO.save(person);
    } catch (Exception ex) {
      return "Error creating the user: " + ex.toString();
    }
    return "Person is succesfully created!";
  }

  @RequestMapping("/delete_person")
  @ResponseBody
  public String deletePerson(long id){
    try {
      Person person = personDAO.findOne(id);
      personDAO.delete(person);
    } catch (Exception ex) {
      return "Error creating the user: " + ex.toString();
    }
    return "Person is succesfully removed!";
  }

  @RequestMapping("/delete_address")
  @ResponseBody
  public String deleteAddress(long id){
    try {
      Address address = new Address(id);
      addressDAO.delete(address);
    } catch (Exception ex) {
      return "Error creating the user: " + ex.toString();
    }
    return "Address is succesfully removed!";
  }

  @Autowired
  private PersonDAO personDAO;

  @Autowired
  private AddressDAO addressDAO;

}
