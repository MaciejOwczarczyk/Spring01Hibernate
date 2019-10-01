package pl.coderslab.Person;

import org.springframework.stereotype.Repository;
import pl.coderslab.common.GenericDao;

import javax.transaction.Transactional;

@Repository
@Transactional
public class PersonDao extends GenericDao<Person> {

    public PersonDao() {
        super(Person.class);
    }
}
