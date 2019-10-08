package pl.coderslab.Book;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.Author.Author;
import pl.coderslab.Author.AuthorDao;
import pl.coderslab.Publisher.Publisher;
import pl.coderslab.Publisher.PublisherDao;

import java.util.List;

@Controller
@RequestMapping("/proposition")
public class PropositionController {

    private final BookDao bookDao;
    private final PublisherDao publisherDao;
    private final AuthorDao authorDao;

    public PropositionController(BookDao bookDao, PublisherDao publisherDao, AuthorDao authorDao) {
        this.bookDao = bookDao;
        this.publisherDao = publisherDao;
        this.authorDao = authorDao;
    }

    @GetMapping("/showAll")
    public String showAll(Model model) {
        List<Book> books = bookDao.findPropositions();
        model.addAttribute("books", books);
        return "showAllPropostionBooks";
    }

    @GetMapping("/add")
    public String add(Model model) {
        Book book = new Book();
        book.setProposition(true);
        model.addAttribute("book", book);
        return "addBook";
    }

    @PostMapping("/add")
    public String add(@ModelAttribute @Validated({PropositionValidationGroup.class}) Book book, BindingResult result) {
        if (!book.isProposition()) {
            return "forward:/book/add";
        }
        if (result.hasErrors()) {
            return "addBook";
        }
        book.setPublisher(null);
        bookDao.save(book);
        return "redirect:showAll";
    }

    @GetMapping("/confirmDelete/{id}")
    public String confirmDelete(@PathVariable Long id, Model model) {
        model.addAttribute("bookId", id);
        return "confirmDeleteProposition";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        bookDao.delete(id);
        return "redirect:../showAll";
    }

    @GetMapping("/edit/{id}")
    public String editBook(@PathVariable Long id, Model model) {
        Book book = bookDao.findWithAuthors(id);
        model.addAttribute("book", book);
        return "addBook";
    }

    @PostMapping("/edit/{id}")
    public String editBook(@PathVariable Long id, @ModelAttribute @Validated({PropositionValidationGroup.class}) Book book, BindingResult result) {
        if (!book.isProposition()) {
            return "forward:/book/edit/" + id;
        }
        if (result.hasErrors()) {
            return "addBook";
        }
        book.setPublisher(null);
        bookDao.update(book);
        return "redirect:../showAll";
    }

    @ModelAttribute("publishers")
    public List<Publisher> publishers() {
        return publisherDao.findAll();
    }

    @ModelAttribute("authors")
    public List<Author> authors() {
        return authorDao.findAll();
    }
}
