package pl.coderslab.Publisher;

import org.springframework.stereotype.Repository;
import pl.coderslab.common.GenericDao;

@Repository
public class PublisherDao extends GenericDao<Publisher> {

    public PublisherDao() {
        super(Publisher.class);
    }
}
