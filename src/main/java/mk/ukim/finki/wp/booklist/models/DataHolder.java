package mk.ukim.finki.wp.booklist.models;

import mk.ukim.finki.wp.booklist.repositories.JpaAuthorRepository;
import mk.ukim.finki.wp.booklist.repositories.JpaBookRepository;
import mk.ukim.finki.wp.booklist.repositories.JpaGenreRepository;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

@Component
public class DataHolder {
    public static final List<Book> books = new LinkedList<>();
    public static final List<Author> authors = new LinkedList<>();
    public static final List<Genre> genres = new LinkedList<>();

    private final JpaBookRepository jpaBookRepository;
    private final JpaAuthorRepository jpaAuthorRepository;
    private final JpaGenreRepository jpaGenreRepository;

    public DataHolder(JpaBookRepository jpaBookRepository,
                      JpaAuthorRepository jpaAuthorRepository,
                      JpaGenreRepository jpaGenreRepository) {
        this.jpaBookRepository = jpaBookRepository;
        this.jpaAuthorRepository = jpaAuthorRepository;
        this.jpaGenreRepository = jpaGenreRepository;
    }

    @PostConstruct
    private void init() {

        genres.add(new Genre("Fantasy", Collections.emptyList()));
        genres.add(new Genre("Fiction", Collections.emptyList()));
        genres.add(new Genre("Young Adult", Collections.emptyList()));
        genres.add(new Genre("Science Fiction", Collections.emptyList()));
        genres.add(new Genre("Classics", Collections.emptyList()));
        genres.add(new Genre("Adventure", Collections.emptyList()));
        genres.add(new Genre("Romance", Collections.emptyList()));
        genres.add(new Genre("Action", Collections.emptyList()));
        genres.add(new Genre("Horror", Collections.emptyList()));
        genres.add(new Genre("Thriller", Collections.emptyList()));
        genres.add(new Genre("Mystery", Collections.emptyList()));
        genres.add(new Genre("Historical", Collections.emptyList()));

        authors.add(new Author(0,"J.K. Rowling", LocalDate.of(1965, 7, 31), "United Kingdom", Collections.emptyList()));

        authors.add(new Author(0, "James Dashner", LocalDate.of(1972, 11, 26), "United States", Collections.emptyList()));

        authors.add(new Author(0, "Veronica Roth", LocalDate.of(1988, 8, 19), "United States", Collections.emptyList()));

        authors.add(new Author(0, "J. R. R. Tolkien", LocalDate.of(1892, 1, 3), "South Africa", Collections.emptyList()));

        books.add(new Book("9780439554930", "Harry Potter and the Sorcerer's Stone", LocalDate.of(2003, 11, 1), authors.get(0), 4.47, 309, "Harry Potter's life is miserable. His parents are dead and he's stuck with his heartless relatives, who force him to live in a tiny closet under the stairs. But his fortune changes when he receives a letter that tells him the truth about himself: he's a wizard. A mysterious visitor rescues him from his relatives and takes him to his new home, Hogwarts School of Witchcraft and Wizardry.\n" +
                "\n" +
                "After a lifetime of bottling up his magical powers, Harry finally feels like a normal kid. But even within the Wizarding community, he is special. He is the boy who lived: the only person to have ever survived a killing curse inflicted by the evil Lord Voldemort, who launched a brutal takeover of the Wizarding world, only to vanish after failing to kill Harry.\n" +
                "\n" +
                "Though Harry's first year at Hogwarts is the best of his life, not everything is perfect. There is a dangerous secret object hidden within the castle walls, and Harry believes it's his responsibility to prevent it from falling into evil hands. But doing so will bring him into contact with forces more terrifying than he ever could have imagined.\n" +
                "\n" +
                "Full of sympathetic characters, wildly imaginative situations, and countless exciting details, the first installment in the series assembles an unforgettable magical world and sets the stage for many high-stakes adventures to come.", "", false, false, genres.stream()
                        .filter(g -> g.getName().equalsIgnoreCase("Fantasy") ||
                                g.getName().equalsIgnoreCase("Fiction") ||
                                g.getName().equalsIgnoreCase("Young Adult"))
                        .collect(Collectors.toList())));

        books.add(new Book("0385737947", "The Maze Runner", LocalDate.of(2009, 10, 6), authors.get(1), 4.02, 384, "If you ain’t scared, you ain’t human.\n" +
                "\n" +
                "When Thomas wakes up in the lift, the only thing he can remember is his name. He’s surrounded by strangers—boys whose memories are also gone.\n" +
                "\n" +
                "Nice to meet ya, shank. Welcome to the Glade.\n" +
                "\n" +
                "Outside the towering stone walls that surround the Glade is a limitless, ever-changing maze. It’s the only way out—and no one’s ever made it through alive.\n" +
                "\n" +
                "Everything is going to change.\n" +
                "\n" +
                "Then a girl arrives. The first girl ever. And the message she delivers is terrifying.\n" +
                "\n" +
                "Remember. Survive. Run.", "", false, false, genres.stream()
                .filter(g -> g.getName().equalsIgnoreCase("Science Fiction") ||
                        g.getName().equalsIgnoreCase("Young Adult"))
                .collect(Collectors.toList())));

        books.add(new Book("0062024027", "Divergent", LocalDate.of(2011, 4, 25), authors.get(2), 4.20, 487, "In Beatrice Prior's dystopian Chicago, society is divided into five factions, each dedicated to the cultivation of a particular virtue--Candor (the honest), Abnegation (the selfless), Dauntless (the brave), Amity (the peaceful), and Erudite (the intelligent). On an appointed day of every year, all sixteen-year-olds must select the faction to which they will devote the rest of their lives. For Beatrice, the decision is between staying with her family and being who she really is--she can't have both. So she makes a choice that surprises everyone, including herself.\n" +
                "\n" +
                "During the highly competitive initiation that follows, Beatrice renames herself Tris and struggles to determine who her friends really are--and where, exactly, a romance with a sometimes fascinating, sometimes infuriating boy fits into the life she's chosen. But Tris also has a secret, one she's kept hidden from everyone because she's been warned it can mean death. And as she discovers a growing conflict that threatens to unravel her seemingly perfect society, she also learns that her secret might help her save those she loves . . . or it might destroy her.", "", false, false, genres.stream()
                .filter(g -> g.getName().equalsIgnoreCase("Fantasy") ||
                        g.getName().equalsIgnoreCase("Fiction") ||
                        g.getName().equalsIgnoreCase("Young Adult") ||
                        g.getName().equalsIgnoreCase("Science Fiction"))
                .collect(Collectors.toList())));

        books.add(new Book("0618346252", "The Fellowship of the Ring", LocalDate.of(1954, 9, 5), authors.get(3), 4.36, 398, "One Ring to rule them all, One Ring to find them, One Ring to bring them all and in the darkeness bind them\n" +
                "\n" +
                "In ancient times the Rings of Power were crafted by the Elven-smiths, and Sauron, The Dark Lord, forged the One Ring, filling it with his own power so that he could rule all others. But the One Ring was taken from him, and though he sought it throughout Middle-earth, it remained lost to him. After many ages it fell into the hands of Bilbo Baggins, as told in The Hobbit.\n" +
                "\n" +
                "In a sleepy village in the Shire, young Frodo Baggins finds himself faced with an immense task, as his elderly cousin Bilbo entrusts the Ring to his care. Frodo must leave his home and make a perilous journey across Middle-earth to the Cracks of Doom, there to destroy the Ring and foil the Dark Lord in his evil purpose.", "", false, false, genres.stream()
                .filter(g -> g.getName().equalsIgnoreCase("Fantasy") ||
                        g.getName().equalsIgnoreCase("Fiction") ||
                        g.getName().equalsIgnoreCase("Classics"))
                .collect(Collectors.toList())));

        books.add(new Book("0618346260", "The Two Towers", LocalDate.of(1954, 11, 11), authors.get(3), 4.44, 322, "The Fellowship was scattered. Some were bracing hopelessly for war against the ancient evil of Sauron. Some were contending with the treachery of the wizard Saruman. Only Frodo and Sam were left to take the accursed Ring of Power to be destroyed in Mordor–the dark Kingdom where Sauron was supreme. Their guide was Gollum, deceitful and lust-filled, slave to the corruption of the Ring. Thus continues the magnificent, bestselling tale of adventure begun in The Fellowship of the Ring, which reaches its soul-stirring climax in The Return of the King.", "", false, false, genres.stream()
                .filter(g -> g.getName().equalsIgnoreCase("Fantasy") ||
                        g.getName().equalsIgnoreCase("Fiction") ||
                        g.getName().equalsIgnoreCase("Classics") ||
                        g.getName().equalsIgnoreCase("Adventure"))
                .collect(Collectors.toList())));

        jpaGenreRepository.saveAll(genres);
        jpaAuthorRepository.saveAll(authors);
        jpaBookRepository.saveAll(books);
    }
}
