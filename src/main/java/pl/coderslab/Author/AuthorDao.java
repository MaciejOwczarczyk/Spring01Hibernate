package pl.coderslab.Author;

import org.springframework.stereotype.Repository;
import pl.coderslab.common.GenericDao;

@Repository
public class AuthorDao extends GenericDao<Author> {

    public AuthorDao() {
        super(Author.class);
    }
}
