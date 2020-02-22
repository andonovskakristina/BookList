package mk.ukim.finki.wp.booklist.repositories;

import mk.ukim.finki.wp.booklist.models.Author;
import mk.ukim.finki.wp.booklist.models.Book;
import mk.ukim.finki.wp.booklist.models.Genre;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.data.domain.Pageable;

import java.util.List;

@Repository
public interface JpaBookRepository extends JpaRepository<Book, String> {
    Page<Book> findAllByReadIsTrue(Pageable pageable);

    List<Book> findAllByFavouriteIsTrue();

    @Query("SELECT b FROM Book b WHERE b.numberPages < :numberPages")
    List<Book> findAllWithLessPagesThan(@Param("numberPages") int numberPages);

    List<Book> findAllByNumberPagesBetween(@Param("numberPages") int from,
                                        @Param("numberPages") int to);

    boolean existsBookByTitle(String title);
    Book getBookByTitle(String title);

    @Query("SELECT MIN(b.numberPages) FROM Book b")
    int minNumberPages();

    @Query("SELECT MAX(b.numberPages) FROM Book b")
    int maxNumberPages();
/*
    Page<Book> findAllByGenresOrAuthorOrTitleLikeOrAuthorNameLikeAndNumberPagesBetween(
            @Param("genres") List<Genre> genres,
            @Param("authors") List<Author> authors,
            @Param("title") String title,
            @Param("authorName") String authorName,
            @Param("numberPagesFrom") int from,
            @Param("numberPagesTo") int to,
            Pageable pageable);*/

    @Query("SELECT DISTINCT b " +
            "FROM Book b JOIN b.author a JOIN b.genres g " +
            "WHERE (:search IS NULL " +
            "OR b.title LIKE :search " +
            "OR a.name LIKE :search) " +
            "AND a IN :authors " +
            "AND b.numberPages BETWEEN :numberPagesFrom AND :numberPagesTo " +
            "AND ((:genres) IS NULL " +
            "OR g.name IN (:genres)) " +
            "AND (:read = false " +
            "OR b.read = true)")
    Page<Book> Filters(
            @Param("authors") List<Author> authors,
            @Param("genres") List<String> genres,
            @Param("search") String search,
            @Param("numberPagesFrom") int minNumber,
            @Param("numberPagesTo") int maxNumber,
            @Param("read") boolean read,
            Pageable pageable);
}
