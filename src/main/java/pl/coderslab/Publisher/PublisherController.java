package pl.coderslab.Publisher;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/publisher")
public class PublisherController {

    private final PublisherDao publisherDao;

    public PublisherController(PublisherDao publisherDao) {
        this.publisherDao = publisherDao;
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

    @RequestMapping("/delete/{id}")
    @ResponseBody
    public String delete(@PathVariable Long id) {
        Publisher publisher = publisherDao.find(id);
        if (publisher != null) {
            publisherDao.delete(id);
            return "ususnięto wydawcę !";
        }
        return "nie ma takiego wydawcy";
    }

    @RequestMapping("/all")
    @ResponseBody
    public String all() {
        return publisherDao.findAll().toString();
    }
}
