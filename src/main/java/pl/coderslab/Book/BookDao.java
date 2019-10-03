package pl.coderslab.Book;

import org.hibernate.Hibernate;
import org.springframework.stereotype.Repository;
import pl.coderslab.Author.Author;
import pl.coderslab.common.GenericDao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Repository
@Transactional
public class BookDao extends GenericDao<Book> {

    @PersistenceContext
    EntityManager entityManager;

    public BookDao() {
        super(Book.class);
    }

    @Transactional
    public Book findWithAuthors(Long id) {
        Book book = entityManager.find(Book.class, id);
        Hibernate.initialize(book.getAuthors());
        return book;
    }

    @Transactional
    public List<Book> getRatinglist(BigDecimal rating) {
        Query query = entityManager.createQuery("select b from Book b where b.rating = :rating");
        query.setParameter("rating", rating);
        return query.getResultList();
    }

    @Transactional
    public List<Author> getAuthorsForBook(Long bookId) {
        Query query = entityManager.createQuery("select a.firstName, a.lastName from Author a, Book  c where c.id =: id");
        query.setParameter("id", bookId);
        return query.getResultList();

    }

//    @Transactional
//    public List<Book> getAllWithAuthors() {
//        Query query = entityManager.createQuery("select b from " + Book.class + " b");
//        List<Book> books = query.getResultList();
//        Hibernate.initialize(books.stream().map(n -> n.getAuthors()).toArray());
//        return books;
//    }


}
