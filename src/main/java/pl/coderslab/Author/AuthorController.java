package pl.coderslab.Author;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/author")
public class AuthorController {

    private final AuthorDao authorDao;

    public AuthorController(AuthorDao authorDao) {
        this.authorDao = authorDao;
    }

    @RequestMapping("/save")
    @ResponseBody
    public String save() {
        Author author = new Author();
        author.setFirstName("firstName");
        author.setLastName("lastName");
        authorDao.save(author);
        return "dodano autora: " + author.toString();
    }

    @RequestMapping("/find/{id}")
    @ResponseBody
    public String find(@PathVariable Long id) {
        Author author = authorDao.find(id);
        if (author != null) {
            return "autor " + author.toString();
        }
        return "brak takiego autora";
    }

    @RequestMapping("/delete/{id}")
    @ResponseBody
    public String delete(@PathVariable Long id) {
        Author author = authorDao.find(id);
        if (author != null) {
            authorDao.delete(id);
            return "usunięto autora";
        }
        return "nie ma takiego autora";
    }

    @RequestMapping("/update/{id}")
    @ResponseBody
    public String update(@PathVariable Long id) {
        Author author = authorDao.find(id);
        if (author != null) {
            author.setLastName("newlast");
            author.setFirstName("newfirst");
            authorDao.update(author);
            return "zaktualizowano autora: " + author.toString();
        }
        return "nie ma takiego autora";
    }

    @RequestMapping("/all")
    @ResponseBody
    public String all() {
        return authorDao.findAll().toString();
    }
}
