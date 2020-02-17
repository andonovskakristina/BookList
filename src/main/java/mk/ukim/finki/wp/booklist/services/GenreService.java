package mk.ukim.finki.wp.booklist.services;

import mk.ukim.finki.wp.booklist.models.Genre;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface GenreService {
    Genre get(String id);
    List<Genre> getAllGenres();
}
