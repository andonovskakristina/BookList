package mk.ukim.finki.wp.booklist.repositories;

import mk.ukim.finki.wp.booklist.models.Author;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface JpaAuthorRepository extends JpaRepository<Author, Integer> {
    @Query("SELECT distinct a FROM Author a JOIN a.books b WHERE b.favourite = true")
    List<Author> getFavouriteAuthors();

    @Query("SELECT DISTINCT a " +
            "FROM Author a " +
            "WHERE (:search IS NULL " +
            "OR a.name LIKE :search)")
    Page<Author> Search(
            @Param("search") String search,
            Pageable pageable);
}
