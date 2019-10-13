package pl.coderslab.Book;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.math.BigDecimal;

@Transactional
public class BookRepositoryImpl implements BookRepoRating {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public void resetRating(BigDecimal newRating) {
        Query q = entityManager.createQuery("update Book u set u.rating = :newRating");
        q.setParameter("newRating", newRating).executeUpdate();
    }
}
