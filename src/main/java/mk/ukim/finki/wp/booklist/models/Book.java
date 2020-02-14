package mk.ukim.finki.wp.booklist.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

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

    @JsonBackReference
    @ManyToOne
    private Author author;

    private double review;

    private int numberPages;

    @Column(length = 2000)
    private String description;

    private String comment;

    private boolean read;

    private boolean favourite;

    @JsonIgnore
    @ManyToMany(mappedBy = "books")
    private List<Genre> genres;
}
