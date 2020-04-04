package mk.ukim.finki.wp.booklist.repositories;

import mk.ukim.finki.wp.booklist.models.Genre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JpaGenreRepository extends JpaRepository<Genre, String> {

}
