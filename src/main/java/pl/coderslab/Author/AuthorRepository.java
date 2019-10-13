package pl.coderslab.Author;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AuthorRepository extends JpaRepository<Author, Long> {

    Author findByEmail(String email);
    Author findByPesel(String pesel);
    List<Author> findByLastName(String lastName);

    @Query("select u from Author u where u.email like ?1%")
    List<Author> findByEmailStartsWith(String email);

    @Query("select u from Author u where u.pesel like ?1%")
    List<Author> findByPeselStartsWith(String pesel);

}
