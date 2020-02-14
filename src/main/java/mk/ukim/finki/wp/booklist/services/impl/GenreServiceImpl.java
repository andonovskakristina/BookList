package mk.ukim.finki.wp.booklist.services.impl;

import mk.ukim.finki.wp.booklist.models.Book;
import mk.ukim.finki.wp.booklist.models.Genre;
import mk.ukim.finki.wp.booklist.models.exceptions.ApiException;
import mk.ukim.finki.wp.booklist.repositories.JpaGenreRepository;
import mk.ukim.finki.wp.booklist.services.GenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GenreServiceImpl implements GenreService {
    @Autowired
    private JpaGenreRepository genreRepository;

    @Override
    public Genre get(String id) {
        if(!genreRepository.existsById(id))
            throw new ApiException("Genre doesn't exist");
        Optional<Genre> optionalEntity = genreRepository.findById(id);
        return optionalEntity.get();
    }
}
