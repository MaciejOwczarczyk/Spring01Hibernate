package pl.coderslab.Student;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/student")
public class StudentController {

    @GetMapping("/add")
    public String save(Model model) {
        model.addAttribute("student", new Student());
        return "student";
    }

    @PostMapping("/add")
    public String proccess(@ModelAttribute Student student, Model model) {
        model.addAttribute("student", student);
        return "processStudent";
    }

    @ModelAttribute("gender")
    public List<String> gender() {
        return Arrays.asList("Male", "Female");
    }

    @ModelAttribute("countries")
    public List<String> countries() {
        return Arrays.asList("Poland", "Russia", "Germany", "Latvia");
    }

    @ModelAttribute("skills")
    public List<String> programmingSkills() {
        return Arrays.asList("php", "java", "js", "python");
    }

    @ModelAttribute("hobbies")
    public List<String> hobbies() {
        return Arrays.asList("sport", "gym", "book", "music");
    }
}
