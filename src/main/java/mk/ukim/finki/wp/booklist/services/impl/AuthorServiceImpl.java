package mk.ukim.finki.wp.booklist.services.impl;

import mk.ukim.finki.wp.booklist.models.Author;
import mk.ukim.finki.wp.booklist.models.exceptions.ApiException;
import mk.ukim.finki.wp.booklist.repositories.JpaAuthorRepository;
import mk.ukim.finki.wp.booklist.services.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AuthorServiceImpl implements AuthorService {
    @Autowired
    private JpaAuthorRepository authorRepository;

    @Override
    public Author create(Author author) {
        checkUniqueId(author.getId());
        return this.authorRepository.save(author);
    }

    @Override
    public Author edit(int id, Author author) {
        if(!authorRepository.existsById(id))
            throw new ApiException("Author doesn't exist");
        Optional<Author> optionalEntity = this.authorRepository.findById(id);
        Author old = optionalEntity.get();
        if(author.getName().equals("") || author.getName() == null ||
                author.getBirthPlace().equals("") || author.getBirthPlace() == null ||
        author.getBiography().equals("") || author.getBiography() == null ||
                author.getImageUrl().equals("") || author.getImageUrl() == null)
            throw new ApiException("Invalid input");
        old.setName(author.getName());
        old.setBirthDate(author.getBirthDate());
        old.setBirthPlace(author.getBirthPlace());
        return this.authorRepository.save(old);
    }

    @Override
    public void delete(int id) {
        authorRepository.deleteById(id);
    }

    @Override
    public List<Author> getAllAuthors() {
        return authorRepository.findAll();
    }

    @Override
    public Author get(int id) {
        if(!authorRepository.existsById(id))
            throw new ApiException("Author doesn't exist");
        Optional<Author> optionalEntity = authorRepository.findById(id);
        return optionalEntity.get();
    }

    @Override
    public List<Author> getFavouriteAuthors() {
        return authorRepository.getFavouriteAuthors();
    }

    @Override
    public Page<Author> getAllAuthorsByPageAndSearch(String search, Pageable pageable) {
        if(search != null && !search.isEmpty()) {
            search = "%" + search + "%";
        }
        else {
            search = null;
        }
        return authorRepository.Search(search, pageable);
    }

    public void checkUniqueId(int id){
        if(authorRepository.existsById(id))
            throw new ApiException("Author already exists");
    }
}
