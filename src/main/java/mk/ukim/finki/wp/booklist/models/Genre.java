package mk.ukim.finki.wp.booklist.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "genres")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Genre {
    @Id
    @Column(name = "genre_name")
    private String name;

    @ManyToMany(fetch = FetchType.EAGER)
    /*@JoinTable(name = "BOOK_GENRE",
            joinColumns = @JoinColumn(name = "genre_name", referencedColumnName = "genre_name"),
            inverseJoinColumns = @JoinColumn(name = "ISBN", referencedColumnName = "ISBN"))*/
    private List<Book> books;
}
