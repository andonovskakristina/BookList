package mk.ukim.finki.wp.booklist.web;

import mk.ukim.finki.wp.booklist.models.Author;
import mk.ukim.finki.wp.booklist.models.Book;
import mk.ukim.finki.wp.booklist.models.Genre;
import mk.ukim.finki.wp.booklist.models.exceptions.ApiException;
import mk.ukim.finki.wp.booklist.services.AuthorService;
import mk.ukim.finki.wp.booklist.services.BookService;
import mk.ukim.finki.wp.booklist.services.GenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.util.MimeTypeUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.StyledEditorKit;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping(path = "/api/books", produces = MimeTypeUtils.APPLICATION_JSON_VALUE)
@Validated
public class BookApiController {
    @Autowired
    private BookService bookService;
    @Autowired
    private AuthorService authorService;
    @Autowired
    private GenreService genreService;

    @PostMapping()
    public Book createNewBook(@RequestParam(value="ISBN") String ISBN,
                              @RequestParam(value="title") String title,
                              @RequestParam(value="publicationDate") String publicationDate,
                              @RequestParam(value="author") int authorId,
                              @RequestParam(value="review") double review,
                              @RequestParam(value="numberPages") int numberPages,
                              @RequestParam(value="description") String description,
                              @RequestParam(value="genres") String[] genreIds,
                              @RequestParam(value="imageUrl") String imageUrl){

        List<Genre> genres = new ArrayList<>();
        for(int i = 0; i < genreIds.length; i++) {
            genres.add(genreService.get(genreIds[i]));
        }

        Book result = bookService.create(new Book(ISBN, title, LocalDate.parse(publicationDate, DateTimeFormatter.ofPattern("yyyy-MM-dd")), authorService.get(authorId), review, numberPages, description, "", false, false, imageUrl, genres));
        return result;
    }

    @PatchMapping("/{id}/markAsRead")
    public Book markAsRead(@PathVariable String id) {
        return bookService.markAsRead(id);
    }

    @PatchMapping("/{id}/updateFavourites")
    public Book updateFavourites(@PathVariable String id) {
        return bookService.updateFavourites(id);
    }

    @PatchMapping("/{id}/addAComment")
    public Book addAComment(@PathVariable String id,
                            @RequestParam(value = "comment") String comment) {
        return bookService.addAComment(id, comment);
    }

    @PatchMapping("/{id}")
    public Book editBook(@PathVariable String id,
                         @RequestParam(value="title") String title,
                         @RequestParam(value="publicationDate") String publicationDate,
                         @RequestParam(value="author") int authorId,
                         @RequestParam(value="review") double review,
                         @RequestParam(value="numberPages") int numberPages,
                         @RequestParam(value="description") String description,
                         @RequestParam(value="genres") List<Genre> genres,
                         @RequestParam(value="imageUrl") String imageUrl){

        Book old = bookService.get(id);
        Book result = bookService.edit(id, new Book(id, title, LocalDate.parse(publicationDate, DateTimeFormatter.ofPattern("yyyy-MM-dd")), authorService.get(authorId), review, numberPages, description, old.getComment(), old.isRead(), old.isFavourite(), imageUrl, genres));
        return result;
    }

    @DeleteMapping("/{id}")
    public void deleteBook(@PathVariable String id){
        bookService.delete(id);
    }

    @GetMapping("/{id}")
    public Book getBook(@PathVariable String id){
        return bookService.get(id);
    }

    @GetMapping("/allBooks")
    public List<Book> getAllBooks(){
        return bookService.getAllBooks();
    }

    @GetMapping()
    public Page<Book> getAllBooks(@RequestParam(value = "authorIds",
                                            required = false) int[] authorIds,
                                  @RequestParam(value = "genres",
                                          required = false) String[] genres,
                                  @RequestParam(value = "search",
                                          required = false) String search,
                                  @RequestParam(value = "numberPagesFrom",
                                          required = false,
                                          defaultValue = "0") int numberPagesFrom,
                                  @RequestParam(value = "numberPagesTo",
                                          required = false,
                                          defaultValue = "0") int numberPagesTo,
                                  @RequestParam(value = "read",
                                          required = false, defaultValue = "false")
                                              boolean read,
                                  @RequestParam(value = "favourite",
                                          required = false, defaultValue = "false")
                                              boolean favourite,
                                  @PageableDefault(page = 0, size = 3, sort = {"title"}) Pageable pageable){
        return bookService.getAllBooksByPageAndFilters(authorIds, genres, search, numberPagesFrom, numberPagesTo, read, favourite, pageable);

    }

    @GetMapping("/minMaxNumberPages")
    public int[] getMinMaxNumberPages(){
        return bookService.getMinMaxNumberPages();
    }
}
