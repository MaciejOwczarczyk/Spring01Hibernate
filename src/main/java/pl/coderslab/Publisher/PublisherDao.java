package pl.coderslab.Publisher;

import org.springframework.stereotype.Repository;
import pl.coderslab.common.GenericDao;

import javax.transaction.Transactional;

@Repository
@Transactional
public class PublisherDao extends GenericDao<Publisher> {

    public PublisherDao() {
        super(Publisher.class);
    }
}
