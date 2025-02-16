package mk.ukim.finki.wp.booklist.services;

import mk.ukim.finki.wp.booklist.models.Author;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AuthorService {
    Author create(Author author);

    Author edit(int id, Author author);

    void delete(int id);

    List<Author> getAllAuthors();

    Author get(int id);

    List<Author> getFavouriteAuthors();

    Page<Author> getAllAuthorsByPageAndSearch(String search, Pageable pageable);
}
