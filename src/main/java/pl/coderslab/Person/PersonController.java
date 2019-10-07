package pl.coderslab.Person;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.xml.validation.Validator;

@Controller
@RequestMapping("/person")
public class PersonController {

    private final PersonDao personDao;

    public PersonController(PersonDao personDao) {
        this.personDao = personDao;
    }

    @GetMapping("")
    public String exe1(Model model) {
        model.addAttribute("person", new Person());
        return "addPerson";
    }

    @PostMapping("")
    @ResponseBody
    public String exe2(@ModelAttribute Person person) {
        personDao.save(person);
        return "dodano " + person.toString();
    }


    @RequestMapping("/save")
    @ResponseBody
    public String save() {
        Person person = new Person();
        person.setPassword("password");
        person.setEmail("email");
        person.setLogin("login");

        PersonDetails personDetails = new PersonDetails();
        personDetails.setFirstName("first");
        personDetails.setLastName("last");
        personDetails.setStreet("street");
        personDetails.setCity("city");
        personDetails.setStreetNumber("12/23");

        person.setPersonDetails(personDetails);

        personDao.save(person);
        return "utworzono osobę: " + person.toString();
    }

    @RequestMapping("/find/{id}")
    @ResponseBody
    public String find(@PathVariable Long id) {
        Person person = personDao.find(id);
        if (person != null) {
            return "osoba: " + person.toString();
        }
        return "nie ma takiej osoby";
    }

    @RequestMapping("/update/{id}")
    @ResponseBody
    public String update(@PathVariable Long id) {
        Person person = personDao.find(id);
        if (person != null) {
            person.setLogin("newlogin");
            person.setEmail("newEmail");
            person.setPassword("newPassword");
            person.getPersonDetails().setStreetNumber("newStreetNumber");
            person.getPersonDetails().setFirstName("newfirstname");
            personDao.update(person);
            return "zaktualizowano: " + person.toString();
        }
        return "nie ma takiej osoby";
    }

    @RequestMapping("/delete/{id}")
    @ResponseBody
    public String delete(@PathVariable Long id) {
        Person person = personDao.find(id);
        if (person != null) {
            personDao.delete(id);
            return "usunięto osobę";
        }
        return "nie ma takiej osoby";
    }

    @RequestMapping("/all")
    @ResponseBody
    public String all() {
        return personDao.findAll().toString();
    }
}
