package pl.coderslab.Author;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/author")
public class AuthorController {

    private final AuthorDao authorDao;

    public AuthorController(AuthorDao authorDao) {
        this.authorDao = authorDao;
    }


    @GetMapping("/add")
    public String add(Model model) {
        model.addAttribute("author", new Author());
        return "authorForm";
    }

    @PostMapping("/add")
    public String processAuthor(@ModelAttribute Author author) {
        authorDao.save(author);
        return "redirect:showAll";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Long id, Model model) {
        Author author = authorDao.find(id);
        model.addAttribute("author", author);
        return "authorForm";
    }

    @PostMapping("/edit/{id}")
    public String editProcess(@ModelAttribute Author author) {
        authorDao.update(author);
        return "redirect:../showAll";
    }

    @GetMapping("/showAll")
    public String showAll(Model model) {
        model.addAttribute("authors", authorDao.findAll());
        return "showAllAuthors";
    }

    @GetMapping("/confirmDelete/{id}")
    public String confirmDelete(@PathVariable Long id, Model model) {
        model.addAttribute("authorId", id);
        return "confirmDeleteAuthor";
    }


    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        authorDao.delete(id);
        return "redirect:../showAll";
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
