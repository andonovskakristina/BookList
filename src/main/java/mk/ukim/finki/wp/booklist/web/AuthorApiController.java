package mk.ukim.finki.wp.booklist.web;

import mk.ukim.finki.wp.booklist.models.Author;
import mk.ukim.finki.wp.booklist.models.Book;
import mk.ukim.finki.wp.booklist.services.AuthorService;
import mk.ukim.finki.wp.booklist.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.util.MimeTypeUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping(path = "/api/authors", produces = MimeTypeUtils.APPLICATION_JSON_VALUE)
@Validated
public class AuthorApiController {
    @Autowired
    private AuthorService authorService;

    @Autowired
    private BookService bookService;

    @PostMapping()
    public Author createNewAuthor(@RequestParam(value="name") String name,
                                 @RequestParam(value="birthDate") String birthDate,
                                 @RequestParam(value="birthPlace") String birthPlace,
                                  @RequestParam(value="imageUrl") String imageUrl,
                                  @RequestParam(value="biography") String biography){

        Author author = new Author(0, name,LocalDate.parse(birthDate, DateTimeFormatter.ofPattern("yyyy-MM-dd")), birthPlace, imageUrl, biography, Collections.emptyList());
        return authorService.create(author);
    }

    @PatchMapping("/{id}")
    public void editAuthor(@PathVariable int id,
                           @RequestParam(value="name") String name,
                           @RequestParam(value="birthDate") String birthDate,
                           @RequestParam(value="birthPlace") String birthPlace,
                           @RequestParam(value="imageUrl") String imageUrl,
                           @RequestParam(value="biography") String biography){

        Author author = authorService.get(id);
        author.setName(name);
        author.setBirthDate(LocalDate.parse(birthDate, DateTimeFormatter.ofPattern("yyyy-MM-dd")));
        author.setBirthPlace(birthPlace);
        author.setImageUrl(imageUrl);
        author.setBiography(biography);
        authorService.edit(id, author);
    }

    @DeleteMapping("/{id}")
    public void deleteAuthor(@PathVariable int id){
        authorService.delete(id);
    }

    @GetMapping("/allAuthors")
    public List<Author> getAllAuthors(){
        return authorService.getAllAuthors();
    }

    @GetMapping()
    public Page<Author> getAllAuthors(@RequestParam(value = "search",
                                                    required = false) String search,
                                      @PageableDefault(page = 0, size = 6) Pageable pageable){
        return authorService.getAllAuthorsByPageAndSearch(search, pageable);
    }

    @GetMapping("/{id}")
    public Author getAuthor(@PathVariable int id){
        return authorService.get(id);
    }

    @GetMapping("/favourite")
    public List<Author> getFavouriteAuthors(){
        return authorService.getFavouriteAuthors();
    }
}
