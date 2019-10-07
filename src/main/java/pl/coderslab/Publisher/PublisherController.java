package pl.coderslab.Publisher;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.Book.Book;
import pl.coderslab.Book.BookDao;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/publisher")
public class PublisherController {

    private final PublisherDao publisherDao;
    private final BookDao bookDao;

    public PublisherController(PublisherDao publisherDao, BookDao bookDao) {
        this.publisherDao = publisherDao;
        this.bookDao = bookDao;
    }


    @GetMapping("/showAll")
    public String showAll(Model model) {
        model.addAttribute("pusblishers", publisherDao.findAll());
        return "showAllPublishers";
    }

    @GetMapping("/add")
    public String add(Model model) {
        model.addAttribute("publisher", new Publisher());
        return "addPublisher";
    }

    @PostMapping("/add")
    public String addProcess(@ModelAttribute @Valid Publisher publisher, BindingResult result) {
        if (result.hasErrors()) {
            return "addPublisher";
        }
        publisherDao.save(publisher);
        return "redirect:showAll";
    }


    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Long id, Model model ) {
        Publisher publisher = publisherDao.find(id);
        model.addAttribute("publisher", publisher);
        return "addPublisher";
    }

    @PostMapping("/edit/{id}")
    public String editProcess(@PathVariable Long id, @ModelAttribute @Valid Publisher publisher,BindingResult result) {
        if (result.hasErrors()) {
            return "addPublisher";
        }
        publisherDao.update(publisher);
        return "redirect:../showAll";
    }

    @GetMapping("/confirmDelete/{id}")
    public String delete(@PathVariable Long id, Model model) {
        model.addAttribute("publisherId", id);
        return "confirmDeletePublisher";
    }

    @GetMapping("/delete/{id}")
    public String confirmDelete(@PathVariable Long id) {
        List<Book> books = bookDao.findAll();
        boolean check = books.stream().
                map(Book::getPublisher).
                anyMatch(o -> o.getId().equals(publisherDao.find(id).getId()));
        if (check) {
            return "deletePublisherWarning";
        }
        publisherDao.delete(id);
        return "redirect:../showAll";
    }

    @RequestMapping("/save")
    @ResponseBody
    public String save() {
        Publisher publisher = new Publisher();
        publisher.setName("namePublisher");
        publisherDao.save(publisher);
        return "dodano wydawcę: " + publisher.toString();
    }

    @RequestMapping("/find/{id}")
    @ResponseBody
    public String find(@PathVariable Long id) {
        Publisher publisher = publisherDao.find(id);
        if (publisher != null) {
            return "wydawca: " + publisher.toString();
        }
        return "nie ma takiego wydawcy";
    }

    @RequestMapping("/update/{id}")
    @ResponseBody
    public String update(@PathVariable Long id) {
        Publisher publisher = publisherDao.find(id);
        if (publisher != null) {
            publisher.setName("new name");
            publisherDao.update(publisher);
            return "zaktualizowano wydawcę: " + publisher.toString();
        }
        return "nie ma takiego wydawcy";
    }

    @RequestMapping("/all")
    @ResponseBody
    public String all() {
        return publisherDao.findAll().toString();
    }
}
