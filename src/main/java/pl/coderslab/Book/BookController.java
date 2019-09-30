package pl.coderslab.Book;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.coderslab.Author.Author;
import pl.coderslab.Author.AuthorDao;
import pl.coderslab.Publisher.Publisher;
import pl.coderslab.Publisher.PublisherDao;

import java.math.BigDecimal;
import java.util.Arrays;

@RequestMapping("/book")
@Controller
public class BookController {

    private final BookDao bookDao;
    private final PublisherDao publisherDao;
    private final AuthorDao authorDao;

    public BookController(BookDao bookDao, PublisherDao publisherDao, AuthorDao authorDao) {
        this.bookDao = bookDao;
        this.publisherDao = publisherDao;
        this.authorDao = authorDao;
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
        if (book != null) {
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

    @RequestMapping("/delete/{id}")
    @ResponseBody
    public String delete(@PathVariable Long id) {
        Book book = bookDao.find(id);
        if (book != null) {
            bookDao.delete(id);
            return "usunięto książkę o id: " + book.getId();
        }
        return "nie ma takiej książki";
    }

    @RequestMapping("/all")
    @ResponseBody
    public String all() {
        return bookDao.findAll().toString();
    }
}
