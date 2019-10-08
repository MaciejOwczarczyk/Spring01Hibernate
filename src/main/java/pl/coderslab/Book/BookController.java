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
import javax.validation.Validator;
import java.math.BigDecimal;
import java.util.*;

@RequestMapping("/book")
@Controller
public class BookController {

    private final BookDao bookDao;
    private final PublisherDao publisherDao;
    private final AuthorDao authorDao;

    public BookController(BookDao bookDao, PublisherDao publisherDao, AuthorDao authorDao, Validator validator) {
        this.bookDao = bookDao;
        this.publisherDao = publisherDao;
        this.authorDao = authorDao;
    }

    @GetMapping("/add")
    public String add(Model model) {
        model.addAttribute("book", new Book());
        return "addBook";
    }

    @PostMapping("/add")
    public String processBook(@ModelAttribute @Validated({BookValidationGroup.class}) Book book, BindingResult result) {
        if (book.isProposition()) {
            return "forward:/proposition/add";
        }
        if (result.hasErrors()) {
            return "addBook";
        }

        bookDao.save(book);
        return "redirect:showAll";
    }

    @GetMapping("/showAll")
    public String showAll(Model model) {
        List<Book> books = bookDao.findAllNoneProposition();
        model.addAttribute("books", books);
        return "showAllBooks";
    }

    @GetMapping("/edit/{id}")
    public String editBook(@PathVariable Long id, Model model) {
        Book book = bookDao.findWithAuthors(id);
        model.addAttribute("book", book);
        return "addBook";
    }

    @PostMapping("/edit/{id}")
    public String editBookProcess(@PathVariable Long id, @ModelAttribute @Validated({BookValidationGroup.class}) Book book, BindingResult result, Model model) {
        if (book.isProposition()) {
            return "forward:/proposition/edit/" + id;
        }
        if (result.hasErrors()) {
            return "addBook";
        }
       bookDao.update(book);
       return "redirect:../showAll";
    }

    @GetMapping("/confirmDelete/{id}")
    public String confirmDelete(@PathVariable Long id, Model model) {
        model.addAttribute("bookId", id);
        return "confirmDeleteBook";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        bookDao.delete(id);
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







    @RequestMapping("/save")
    @ResponseBody
    public String save() {
        Book book = new Book();
        book.setDescription("description");
        book.setRating(BigDecimal.valueOf(10));
        book.setTitle("title");

        Publisher publisher = publisherDao.find(1L);
        book.setPublisher(publisher);

        Author author = authorDao.find(1L);
        book.setAuthors(Arrays.asList(author));

        bookDao.save(book);
        return "dodano książkę o id: " + book.getId();
    }

    @RequestMapping("/find/{id}")
    @ResponseBody
    public String find(@PathVariable Long id) {
        Book book = bookDao.findWithAuthors(id);
        if (book != null) { //nie zadziała z findWithAuthors
            return "książka: " + book.toString();
        }
        return "nie ma takiej książki";
    }

    @RequestMapping("/update/{id}")
    @ResponseBody
    public String updateBook(@PathVariable Long id) {
        Book book = bookDao.find(id);
        if (book != null) {
            book.setTitle("newtitle");
            book.setDescription("newdescription");
            book.setRating(BigDecimal.valueOf(12));

            Publisher publisher = publisherDao.find(1L);
            book.setPublisher(publisher);

            Author author = authorDao.find(1L);
            book.setAuthors(Arrays.asList(author));

            bookDao.update(book);
            return "zaktualizowano: " + book.toString();
        }
        return "nie ma takiej książki";
    }



    @RequestMapping("/all")
    @ResponseBody
    public String all() {
        return bookDao.findAll().toString();
    }
}
