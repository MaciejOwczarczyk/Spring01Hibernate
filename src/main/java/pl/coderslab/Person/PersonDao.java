package pl.coderslab.Person;

import org.springframework.stereotype.Repository;
import pl.coderslab.common.GenericDao;

@Repository
public class PersonDao extends GenericDao<Person> {

    public PersonDao() {
        super(Person.class);
    }
}
