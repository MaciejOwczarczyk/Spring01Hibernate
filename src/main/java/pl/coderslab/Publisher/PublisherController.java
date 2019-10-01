package pl.coderslab.Publisher;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/publisher")
public class PublisherController {

    private final PublisherDao publisherDao;

    public PublisherController(PublisherDao publisherDao) {
        this.publisherDao = publisherDao;
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
    public String addProcess(@ModelAttribute Publisher publisher) {
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
    public String editProcess(@ModelAttribute Publisher publisher, @PathVariable Long id) {
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
