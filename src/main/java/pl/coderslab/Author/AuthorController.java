package pl.coderslab.Author;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.Book.Book;
import pl.coderslab.Book.BookDao;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/author")
public class AuthorController {

    private final AuthorDao authorDao;
    private final BookDao bookDao;

    public AuthorController(AuthorDao authorDao, BookDao bookDao) {
        this.authorDao = authorDao;
        this.bookDao = bookDao;
    }


    @GetMapping("/add")
    public String add(Model model) {
        model.addAttribute("author", new Author());
        return "addAuthor";
    }

    @PostMapping("/add")
    public String processAuthor(@ModelAttribute @Valid Author author, BindingResult result) {
        if (result.hasErrors()) {
            return "addAuthor";
        }
        authorDao.save(author);
        return "redirect:showAll";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Long id, Model model) {
        Author author = authorDao.find(id);
        model.addAttribute("author", author);
        return "addAuthor";
    }

    @PostMapping("/edit/{id}")
    public String editProcess(@ModelAttribute @Valid Author author, BindingResult result) {
        if (result.hasErrors()) {
            return "addAuthor";
        }
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
        List<Book> books = bookDao.findAll();
        for (Book book: books) {
            List<Author> authorList = book.getAuthors();
            boolean check = authorList.stream().
                    map(Author::getId).
                    anyMatch(o -> o.equals(authorDao.find(id).getId()));
            if (check) {
                return "deleteAuthorWarning";
            }
        }
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
