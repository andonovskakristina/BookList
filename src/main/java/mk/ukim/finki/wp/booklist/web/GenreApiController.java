package mk.ukim.finki.wp.booklist.web;

import mk.ukim.finki.wp.booklist.models.Book;
import mk.ukim.finki.wp.booklist.models.Genre;
import mk.ukim.finki.wp.booklist.services.AuthorService;
import mk.ukim.finki.wp.booklist.services.BookService;
import mk.ukim.finki.wp.booklist.services.GenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.MimeTypeUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping(path = "/api/genres", produces = MimeTypeUtils.APPLICATION_JSON_VALUE)
@Validated
public class GenreApiController {
    @Autowired
    private BookService bookService;
    @Autowired
    private AuthorService authorService;
    @Autowired
    private GenreService genreService;

    @GetMapping()
    public List<Genre> getAllGenres(){
        return genreService.getAllGenres();
    }
}
