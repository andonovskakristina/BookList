package mk.ukim.finki.wp.booklist.repositories;

import mk.ukim.finki.wp.booklist.models.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface JpaAuthorRepository extends JpaRepository<Author, Integer> {
    @Query("SELECT distinct a FROM Author a JOIN a.books b WHERE b.favourite = true")
    List<Author> getFavouriteAuthors();
}
