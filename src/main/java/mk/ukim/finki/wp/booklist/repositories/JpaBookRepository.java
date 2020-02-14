package mk.ukim.finki.wp.booklist.repositories;

import mk.ukim.finki.wp.booklist.models.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JpaBookRepository extends JpaRepository<Book, String> {
    List<Book> findAllByReadIsTrue();

    List<Book> findAllByFavouriteIsTrue();

    @Query("SELECT b FROM Book b WHERE b.numberPages < :numberPages")
    List<Book> findAllWithLessPagesThan(@Param("numberPages") int numberPages);

    List<Book> findAllByNumberPagesBetween(@Param("numberPages") int from,
                                        @Param("numberPages") int to);

    boolean existsBookByTitle(String title);
    Book getBookByTitle(String title);
}
