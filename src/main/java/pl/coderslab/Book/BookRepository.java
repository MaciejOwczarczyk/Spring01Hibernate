package pl.coderslab.Book;

import org.graalvm.compiler.lir.LIR;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long>, BookRepoRating {

    List<Book> findByTitle(String title);

    List<Book> findByCategoryName(String categoryName);

    List<Book> findByCategoryId(Long categoryId);

    List<Book> findByAuthorsFirstName(String firstName);

    List<Book> findByPublisherName(String publisherName);

    List<Book> findByRating(BigDecimal rating);

    Book getFirstByCategoryNameOrderByTitleDesc(String categoryName);

    @Query("select u from Book u where u.title = ?1")
    List<Book> findAllByTitle(String title);

    @Query("select u from Book  u where u.category = ?1")
    List<Book> findAllByCategory(String category);

    @Query("select u from Book u where u.rating between ?1 and ?2")
    List<Book> findBetweenRating(BigDecimal min, BigDecimal max);

    @Query("select u from Book u where u.publisher.name = ?1")
    List<Book> findBooksByPublisherName(String publisherName);

    @Query( value = "select * from Book2.books join Book2.Category on books.category_id = Category.id where Category.name = ?1 order by books.title desc limit 1", nativeQuery = true)
    List<Book> findFirstByCategoryNameOrderByTitleDesc(String category);




}
