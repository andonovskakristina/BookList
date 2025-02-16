package mk.ukim.finki.wp.booklist.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Entity
@Table(name = "books")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Book {
    @Id
    private String ISBN;

    private String title;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate publicationDate;

    //@JsonIgnore
    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Author author;

    private double review;

    private int numberPages;

    @Column(length = 2000)
    private String description;

    private String comment;

    private boolean read;

    private boolean favourite;

    private String imageUrl;

    @JsonIgnore
    @ManyToMany(fetch = FetchType.LAZY)
    private List<Genre> genres;

    public int getAuthorId() {
        return author.getId();
    }

    public String getAuthorName() {
        return author.getName();
    }

    public String getBookGenres() {
        return genres.stream().map(Genre::getName)
                .collect(Collectors.joining(", "));
    }
}
