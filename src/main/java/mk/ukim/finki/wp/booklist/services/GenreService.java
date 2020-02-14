package mk.ukim.finki.wp.booklist.services;

import mk.ukim.finki.wp.booklist.models.Genre;
import org.springframework.stereotype.Service;

@Service
public interface GenreService {
    Genre get(String id);
}
