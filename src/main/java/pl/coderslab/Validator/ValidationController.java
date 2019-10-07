package pl.coderslab.Validator;


import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.coderslab.Author.Author;
import pl.coderslab.Author.AuthorDao;
import pl.coderslab.Book.Book;
import pl.coderslab.Book.BookDao;
import pl.coderslab.Publisher.Publisher;

@Controller
public class ValidationController {

    private final Validator validator;

    public ValidationController(Validator validator) {
        this.validator = validator;
    }

    @RequestMapping("/validate")
    public String validateTest(Model model) {
        Publisher publisher1 = new Publisher();
        publisher1.setName("");
        publisher1.setNip("826298383399393");
        publisher1.setRegon("93");

//        Set<ConstraintViolation<Publisher>> violations = validator.validate(publisher1);

        List<FieldError> fieldErrors = validator.validate(publisher1).stream()
                .map(this::mapErrors)
                .collect(Collectors.toList());

//        if (!violations.isEmpty()) {
//            for (ConstraintViolation<Publisher> constraintViolation : violations) {
//                return constraintViolation.getPropertyPath() + " " + constraintViolation.getMessage();
//            }
//
//        }

        model.addAttribute("errors", fieldErrors);
        return "validate";
    }

    private FieldError mapErrors(ConstraintViolation<Publisher> violation) {
        return new FieldError(violation.getPropertyPath().toString(), violation.getMessage());
    }

}