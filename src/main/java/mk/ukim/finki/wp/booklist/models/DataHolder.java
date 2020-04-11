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
        genres.add(new Genre("Drama", Collections.emptyList()));

        authors.add(new Author(0,"J.K. Rowling", LocalDate.of(1965, 7, 31), "United Kingdom", "https://upload.wikimedia.org/wikipedia/commons/5/5d/J._K._Rowling_2010.jpg", "Although she writes under the pen name J.K. Rowling, pronounced like rolling, her name when her first Harry Potter book was published was simply Joanne Rowling. Anticipating that the target audience of young boys might not want to read a book written by a woman, her publishers demanded that she use two initials, rather than her full name. As she had no middle name, she chose K as the second initial of her pen name, from her paternal grandmother Kathleen Ada Bulgen Rowling. She calls herself Jo and has said, \"No one ever called me 'Joanne' when I was young, unless they were angry.\" Following her marriage, she has sometimes used the name Joanne Murray when conducting personal business. During the Leveson Inquiry she gave evidence under the name of Joanne Kathleen Rowling. In a 2012 interview, Rowling noted that she no longer cared that people pronounced her name incorrectly.\n" +
                "\n" +
                "Rowling was born to Peter James Rowling, a Rolls-Royce aircraft engineer, and Anne Rowling (née Volant), on 31 July 1965 in Yate, Gloucestershire, England, 10 miles (16 km) northeast of Bristol. Her mother Anne was half-French and half-Scottish. Her parents first met on a train departing from King's Cross Station bound for Arbroath in 1964. They married on 14 March 1965. Her mother's maternal grandfather, Dugald Campbell, was born in Lamlash on the Isle of Arran. Her mother's paternal grandfather, Louis Volant, was awarded the Croix de Guerre for exceptional bravery in defending the village of Courcelles-le-Comte during the First World War.", Collections.emptyList()));

        authors.add(new Author(0, "James Dashner", LocalDate.of(1972, 11, 26), "United States", "https://images.gr-assets.com/authors/1473791260p8/348878.jpg", "James Smith Dashner is an American writer of speculative fiction, primarily series for children or young adults, such as The Maze Runner series and the young adult fantasy series the 13th Reality. His 2008 novel The Journal of Curious Letters, first in the series, was one of the annual Borders Original Voices picks.\n" +
                "\n" +
                "In 2018, Dashner was dropped by his agent, Michael Bourret, and by his publisher, Penguin Random House, following accusations of sexual harassment; Dashner replied in a statement, \"I am taking any and all criticisms and accusations very seriously, and I will seek counseling and guidance to address them.\"", Collections.emptyList()));

        authors.add(new Author(0, "Veronica Roth", LocalDate.of(1988, 8, 19), "United States", "https://upload.wikimedia.org/wikipedia/commons/6/67/Veronica_Roth_March_18%2C_2014_%28cropped%29.jpg", "Veronica Roth is the #1 New York Times bestselling author of Carve the Mark and the Divergent Series (Divergent, Insurgent, Allegiant, and Four: A Divergent Collection). Her short stories and essays have appeared in Summer Days and Summer Nights, Shards and Ashes, and the upcoming Three Sides of a Heart. The Divergent Series was developed into three major motion pictures.\n" +
                "\n" +
                "Veronica grew up outside of Chicago and graduated from Northwestern University. She now lives in Chicago proper with her husband and dog and writes full-time.", Collections.emptyList()));

        authors.add(new Author(0, "J. R. R. Tolkien", LocalDate.of(1892, 1, 3), "South Africa", "https://cdn.britannica.com/65/66765-050-63A945A7/JRR-Tolkien.jpg", "John Ronald Reuel Tolkien, CBE was an English writer, poet, WWI veteran (a First Lieutenant in the Lancashire Fusiliers, British Army), philologist, and university professor, best known as the author of the high fantasy classic works The Hobbit and The Lord of the Rings .\n" +
                "\n" +
                "Tolkien was Rawlinson and Bosworth Professor of Anglo-Saxon at Oxford from 1925 to 1945, and Merton Professor of English language and literature from 1945 to 1959. He was a close friend of C.S. Lewis.\n" +
                "\n" +
                "Christopher Tolkien published a series of works based on his father's extensive notes and unpublished manuscripts, including The Silmarillion . These, together with The Hobbit and The Lord of the Rings, form a connected body of tales, poems, fictional histories, invented languages, and literary essays about an imagined world called Arda, and Middle-earth within it. Between 1951 and 1955, Tolkien applied the word \"legendarium\" to the larger part of these writings.\n" +
                "\n" +
                "While many other authors had published works of fantasy before Tolkien, the great success of The Hobbit and The Lord of the Rings led directly to a popular resurgence of the genre. This has caused Tolkien to be popularly identified as the \"father\" of modern fantasy literature—or more precisely, high fantasy. Tolkien's writings have inspired many other works of fantasy and have had a lasting effect on the entire field.\n" +
                "\n" +
                "In 2008, The Times ranked him sixth on a list of \"The 50 greatest British writers since 1945\". Forbes ranked him the 5th top-earning dead celebrity in 2009.", Collections.emptyList()));

        authors.add(new Author(0, "Dan Brown", LocalDate.of(1964, 6, 22), "United States", "https://upload.wikimedia.org/wikipedia/commons/thumb/8/8b/Dan_Brown_bookjacket_cropped.jpg/220px-Dan_Brown_bookjacket_cropped.jpg", "Daniel Gerhard Brown (born June 22, 1964) is an American author best known for his thriller novels, including the Robert Langdon novels Angels & Demons (2000), The Da Vinci Code (2003), The Lost Symbol (2009), Inferno (2013) and Origin (2017). His novels are treasure hunts that usually take place over a period of 24 hours.[2] They feature recurring themes of cryptography, art, and conspiracy theories. His books have been translated into 57 languages and, as of 2012, have sold over 200 million copies. Three of them, Angels & Demons, The Da Vinci Code, and Inferno, have been adapted into films.\n" +
                "\n" +
                "The Robert Langdon novels are deeply engaged with Christian themes and historical fact, and have generated controversy as a result. Brown states on his website that his books are not anti-Christian, though he is on a \"constant spiritual journey\" himself. He claims that his book The Da Vinci Code is simply \"an entertaining story that promotes spiritual discussion and debate\"[3] and suggests that the book may be used \"as a positive catalyst for introspection and exploration of our faith.", Collections.emptyList()));

        authors.add(new Author(0, "Stephen King", LocalDate.of(1947, 9, 21), "United States", "https://upload.wikimedia.org/wikipedia/commons/thumb/e/e3/Stephen_King%2C_Comicon.jpg/220px-Stephen_King%2C_Comicon.jpg", "Stephen Edwin King (born September 21, 1947) is an American author of horror, supernatural fiction, suspense, and fantasy novels. His books have sold more than 350 million copies,[2] many of which have been adapted into feature films, miniseries, television series, and comic books. King has published 61 novels (including seven under the pen name Richard Bachman) and six non-fiction books.[3] He has written approximately 200 short stories,[4][5] most of which have been published in book collections.\n" +
                "\n" +
                "King has received Bram Stoker Awards, World Fantasy Awards, and British Fantasy Society Awards. In 2003, the National Book Foundation awarded him the Medal for Distinguished Contribution to American Letters.[6] He has also received awards for his contribution to literature for his entire oeuvre, such as the World Fantasy Award for Life Achievement (2004) and the Grand Master Award from the Mystery Writers of America (2007).[7] In 2015, King was awarded with a National Medal of Arts from the United States National Endowment for the Arts for his contributions to literature.[8] He has been described as the \"King of Horror\".", Collections.emptyList()));

        authors.add(new Author(0, "Linwood Barclay", LocalDate.of(1955, 2, 21), "United States", "https://upload.wikimedia.org/wikipedia/commons/thumb/9/9a/Linwood_Barclay_-_Eden_Mills_Writers_Festival_-_2013_%28DanH-1952%29_%28cropped%29.jpg/220px-Linwood_Barclay_-_Eden_Mills_Writers_Festival_-_2013_%28DanH-1952%29_%28cropped%29.jpg", "Linwood Barclay was born in Darien, Connecticut, son of Muriel and Everett Barclay. His father was a professional illustrator who moved his family to Canada in 1959 where he had accepted a job with William R. Templeton Studios in Toronto. In 1966 the family purchased a vacation campground in Bobcaygeon, Ontario, which they ran for about five years until his father died from lung cancer when Barclay was sixteen.[3]\n" +
                "\n" +
                "Barclay recognized his interest in writing detective fiction at an early age, inspired by the works of Ross Macdonald, who had grown up in Kitchener, Ontario.[4] After graduating from high school Barclay studied literature at Trent University in Peterborough, Ontario, where one of his teachers was the noted novelist Margaret Laurence. While attending university, he began a correspondence with Macdonald that proved inspirational for Barclay. They met once, at which time Macdonald inscribed one of his books to Barclay: \"For Linwood, who will, I hope, someday outwrite me\".[4]\n" +
                "\n" +
                "After graduation with an English literature degree from Trent, he could not sell any of his novels so he found work on a number of local newspapers beginning with the Peterborough Examiner.[3] He subsequently moved to the Toronto Star in 1981. In 1993, following the death of Gary Lautens, he began to write a thrice-weekly humour column for the paper. He also released podcasts of his articles and published three collections: Mike Harris Made Me Eat My Dog, Father Knows Zilch: A Guide for Dumbfounded Dads, and This House Is Nuts!. Between 2004 and 2007, while still writing his column, he published four mystery/comedies, all featuring a sleuth named Zack Walker who works as a newspaper columnist by day. The books were published in the United Kingdom and were modestly successful.", Collections.emptyList()));

        authors.add(new Author(0, "Jojo Moyes", LocalDate.of(1969, 8, 4), "England", "https://upload.wikimedia.org/wikipedia/commons/thumb/c/ce/Paris_-_Salon_du_livre_de_Paris_2017_-_Jojo_Moyes_-_001_%28cropped%29.jpg/220px-Paris_-_Salon_du_livre_de_Paris_2017_-_Jojo_Moyes_-_001_%28cropped%29.jpg", "Jojo Moyes is a British novelist.\n" +
                "\n" +
                "Moyes studied at Royal Holloway, University of London. She won a bursary financed by The Independent newspaper to study journalism at City University and subsequently worked for The Independent for 10 years. In 2001 she became a full time novelist.\n" +
                "\n" +
                "Moyes' novel Foreign Fruit won the Romantic Novelists' Association (RNA) Romantic Novel of the Year in 2004.\n Pauline Sara-Jo Moyes was born on 4 August 1969[2] in Maidstone,[3] England.[4] Before attending university, Moyes held several jobs: she was a typist at NatWest typing statements in braille for blind people, a brochure writer for Club 18-30, and a minicab controller for a brief time. While an undergraduate at Royal Holloway, University of London, Moyes worked for the Egham and Staines News.[5] Moyes won a bursary financed by The Independent newspaper which allowed her to attend the postgraduate newspaper journalism course at City University in 1992. She subsequently worked for The Independent for the next 10 years (except for one year, when she worked in Hong Kong for the Sunday Morning Post) in various roles, becoming Assistant News Editor in 1998. In 2002 she became the newspaper's Arts and Media Correspondent.", Collections.emptyList()));

        authors.add(new Author(0, "Khaled Hosseini", LocalDate.of(1965, 3, 4), "Afghanistan", "https://images.gr-assets.com/authors/1359753468p5/569.jpg", "Hosseini was born in Kabul, Afghanistan, in 1965. In 1970 Hosseini and his family moved to Iran where his father worked for the Embassy of Afghanistan in Tehran. In 1973 Hosseini's family returned to Kabul, and Hosseini's youngest brother was born in July of that year.\n" +
                "In 1976, when Hosseini was 11 years old, Hosseini's father obtained a job in Paris, France, and moved the family there. They were unable to return to Afghanistan because of the Saur Revolution in which the PDPA communist party seized power through a bloody coup in April 1978. Instead, a year after the Soviet invasion of Afghanistan, in 1980 they sought political asylum in the United States and made their residence in San Jose, California.\n" +
                "Hosseini graduated from Independence High School in San Jose in 1984 and enrolled at Santa Clara University, where he earned a bachelor's degree in biology in 1988. The following year, he entered the University of California, San Diego, School of Medicine, where he earned his M.D. in 1993. He completed his residency in internal medicine at Cedars-Sinai Medical Center in Los Angeles in 1996. He practiced medicine for over ten years, until a year and a half after the release of The Kite Runner.\n" +
                "Hosseini is currently a Goodwill Envoy for the United Nations High Commissioner for Refugees (UNHCR). He has been working to provide humanitarian assistance in Afghanistan through the Khaled Hosseini Foundation. The concept for the foundation was inspired by the trip to Afghanistan that Hosseini made in 2007 with UNHCR.\n" +
                "He lives in Northern California with his wife, Roya, and their two children (Harris and Farah).", Collections.emptyList()));

        books.add(new Book("9780439554930", "Harry Potter and the Sorcerer's Stone", LocalDate.of(2003, 11, 1), authors.get(0), 4.47, 309, "Harry Potter's life is miserable. His parents are dead and he's stuck with his heartless relatives, who force him to live in a tiny closet under the stairs. But his fortune changes when he receives a letter that tells him the truth about himself: he's a wizard. A mysterious visitor rescues him from his relatives and takes him to his new home, Hogwarts School of Witchcraft and Wizardry.\n" +
                "\n" +
                "After a lifetime of bottling up his magical powers, Harry finally feels like a normal kid. But even within the Wizarding community, he is special. He is the boy who lived: the only person to have ever survived a killing curse inflicted by the evil Lord Voldemort, who launched a brutal takeover of the Wizarding world, only to vanish after failing to kill Harry.\n" +
                "\n" +
                "Though Harry's first year at Hogwarts is the best of his life, not everything is perfect. There is a dangerous secret object hidden within the castle walls, and Harry believes it's his responsibility to prevent it from falling into evil hands. But doing so will bring him into contact with forces more terrifying than he ever could have imagined.\n" +
                "\n" +
                "Full of sympathetic characters, wildly imaginative situations, and countless exciting details, the first installment in the series assembles an unforgettable magical world and sets the stage for many high-stakes adventures to come.", "", false, false, "https://upload.wikimedia.org/wikipedia/en/6/6b/Harry_Potter_and_the_Philosopher%27s_Stone_Book_Cover.jpg", genres.stream()
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
                "Remember. Survive. Run.", "", false, false, "https://upload.wikimedia.org/wikipedia/en/d/db/The_Maze_Runner_cover.png", genres.stream()
                .filter(g -> g.getName().equalsIgnoreCase("Science Fiction") ||
                        g.getName().equalsIgnoreCase("Young Adult"))
                .collect(Collectors.toList())));

        books.add(new Book("0062024027", "Divergent", LocalDate.of(2011, 4, 25), authors.get(2), 4.20, 487, "In Beatrice Prior's dystopian Chicago, society is divided into five factions, each dedicated to the cultivation of a particular virtue--Candor (the honest), Abnegation (the selfless), Dauntless (the brave), Amity (the peaceful), and Erudite (the intelligent). On an appointed day of every year, all sixteen-year-olds must select the faction to which they will devote the rest of their lives. For Beatrice, the decision is between staying with her family and being who she really is--she can't have both. So she makes a choice that surprises everyone, including herself.\n" +
                "\n" +
                "During the highly competitive initiation that follows, Beatrice renames herself Tris and struggles to determine who her friends really are--and where, exactly, a romance with a sometimes fascinating, sometimes infuriating boy fits into the life she's chosen. But Tris also has a secret, one she's kept hidden from everyone because she's been warned it can mean death. And as she discovers a growing conflict that threatens to unravel her seemingly perfect society, she also learns that her secret might help her save those she loves . . . or it might destroy her.", "", false, false, "https://upload.wikimedia.org/wikipedia/en/f/f4/Divergent_%28book%29_by_Veronica_Roth_US_Hardcover_2011.jpg", genres.stream()
                .filter(g -> g.getName().equalsIgnoreCase("Fantasy") ||
                        g.getName().equalsIgnoreCase("Fiction") ||
                        g.getName().equalsIgnoreCase("Young Adult") ||
                        g.getName().equalsIgnoreCase("Science Fiction"))
                .collect(Collectors.toList())));

        books.add(new Book("0618346252", "The Fellowship of the Ring", LocalDate.of(1954, 9, 5), authors.get(3), 4.36, 398, "One Ring to rule them all, One Ring to find them, One Ring to bring them all and in the darkeness bind them\n" +
                "\n" +
                "In ancient times the Rings of Power were crafted by the Elven-smiths, and Sauron, The Dark Lord, forged the One Ring, filling it with his own power so that he could rule all others. But the One Ring was taken from him, and though he sought it throughout Middle-earth, it remained lost to him. After many ages it fell into the hands of Bilbo Baggins, as told in The Hobbit.\n" +
                "\n" +
                "In a sleepy village in the Shire, young Frodo Baggins finds himself faced with an immense task, as his elderly cousin Bilbo entrusts the Ring to his care. Frodo must leave his home and make a perilous journey across Middle-earth to the Cracks of Doom, there to destroy the Ring and foil the Dark Lord in his evil purpose.", "", false, false, "https://upload.wikimedia.org/wikipedia/en/8/8e/The_Fellowship_of_the_Ring_cover.gif", genres.stream()
                .filter(g -> g.getName().equalsIgnoreCase("Fantasy") ||
                        g.getName().equalsIgnoreCase("Fiction") ||
                        g.getName().equalsIgnoreCase("Classics"))
                .collect(Collectors.toList())));

        books.add(new Book("9781594631764", "And the Mountains Echoed", LocalDate.of(2012, 2, 29), authors.get(8), 4.05, 404, "So, then. You want a story and I will tell you one...Afghanistan, 1952. Abdullah and his sister Pari live with their father and stepmother in the small village of Shadbagh. Their father, Saboor, is constantly in search of work and they struggle together through poverty and brutal winters. To Abdullah, Pari - as beautiful and sweet-natured as the fairy for which she was named - is everything. More like a parent than a brother, Abdullah will do anything for her, even trading his only pair of shoes for a feather for her treasured collection. Each night they sleep together in their cot, their heads touching, their limbs tangled. One day the siblings journey across the desert to Kabul with their father. Pari and Abdullah have no sense of the fate that awaits them there, for the event which unfolds will tear their lives apart; sometimes a finger must be cut to save the hand. Crossing generations and continents, moving from Kabul, to Paris, to San Francisco, to the Greek island of Tinos, with profound wisdom, depth, insight and compassion, Khaled Hosseini writes about the bonds that define us and shape our lives, the ways in which we help our loved ones in need, how the choices we make resonate through history and how we are often surprised by the people closest to us.", "", false, false,"https://i.gr-assets.com/images/S/compressed.photo.goodreads.com/books/1358190204l/16115612.jpg" ,genres.stream()
                .filter(g -> g.getName().equalsIgnoreCase("Historical") ||
                        g.getName().equalsIgnoreCase("Fiction") ||
                        g.getName().equalsIgnoreCase("Drama"))
                .collect(Collectors.toList())));

        books.add(new Book("0618346260", "The Two Towers", LocalDate.of(1954, 11, 11), authors.get(3), 4.44, 322, "The Fellowship was scattered. Some were bracing hopelessly for war against the ancient evil of Sauron. Some were contending with the treachery of the wizard Saruman. Only Frodo and Sam were left to take the accursed Ring of Power to be destroyed in Mordor–the dark Kingdom where Sauron was supreme. Their guide was Gollum, deceitful and lust-filled, slave to the corruption of the Ring. Thus continues the magnificent, bestselling tale of adventure begun in The Fellowship of the Ring, which reaches its soul-stirring climax in The Return of the King.", "", false, false,"https://upload.wikimedia.org/wikipedia/en/a/a1/The_Two_Towers_cover.gif" ,genres.stream()
                .filter(g -> g.getName().equalsIgnoreCase("Fantasy") ||
                        g.getName().equalsIgnoreCase("Fiction") ||
                        g.getName().equalsIgnoreCase("Classics") ||
                        g.getName().equalsIgnoreCase("Adventure"))
                .collect(Collectors.toList())));

        books.add(new Book("9780553805550", "No Time for Goodbye", LocalDate.of(2007, 9, 25), authors.get(6), 4.01, 338, "Fourteen-year-old Cynthia Bigge woke one morning to discover that her entire family, mother, father, brother had vanished. No note, no trace, no return. Ever. Now, twenty-five years later, she'll learn the devastating truth\n" +
                "\n" +
                "Sometimes better not to know. . .\n" +
                "\n" +
                "Cynthia is happily married with a young daughter, a new family. But the story of her old family isn't over. A strange car in the neighborhood, untraceable phone calls, ominous gifts, someone has returned to her hometown to finish what was started twenty-five years ago. And no one's innocence is guaranteed, not even her own. By the time Cynthia discovers her killer's shocking identity, it will again be too late . . . even for goodbye.", "", true, false,"https://i.gr-assets.com/images/S/compressed.photo.goodreads.com/books/1182031065l/1225261._SY475_.jpg" ,genres.stream()
                .filter(g -> g.getName().equalsIgnoreCase("Thriller") ||
                        g.getName().equalsIgnoreCase("Fiction") ||
                        g.getName().equalsIgnoreCase("Drama") ||
                        g.getName().equalsIgnoreCase("Mystery"))
                .collect(Collectors.toList())));

        books.add(new Book("1594489505", "A Thousand Splendid Suns", LocalDate.of(2007, 5, 22), authors.get(8), 4.37, 372, "A Thousand Splendid Suns is a breathtaking story set against the volatile events of Afghanistan's last thirty years—from the Soviet invasion to the reign of the Taliban to post-Taliban rebuilding—that puts the violence, fear, hope, and faith of this country in intimate, human terms. It is a tale of two generations of characters brought jarringly together by the tragic sweep of war, where personal lives—the struggle to survive, raise a family, find happiness—are inextricable from the history playing out around them.\n" +
                "\n" +
                "Propelled by the same storytelling instinct that made The Kite Runner a beloved classic, A Thousand Splendid Suns is at once a remarkable chronicle of three decades of Afghan history and a deeply moving account of family and friendship. It is a striking, heart-wrenching novel of an unforgiving time, an unlikely friendship, and an indestructible love—a stunning accomplishment.", "", true, true,"https://i.gr-assets.com/images/S/compressed.photo.goodreads.com/books/1345958969l/128029.jpg" ,genres.stream()
                .filter(g -> g.getName().equalsIgnoreCase("Fiction") ||
                        g.getName().equalsIgnoreCase("Historical"))
                .collect(Collectors.toList())));

        books.add(new Book("0385537859", "Inferno", LocalDate.of(2013, 5, 14), authors.get(4), 3.85, 463, "Harvard professor of symbology Robert Langdon awakens in an Italian hospital, disoriented and with no recollection of the past thirty-six hours, including the origin of the macabre object hidden in his belongings. With a relentless female assassin trailing them through Florence, he and his resourceful doctor, Sienna Brooks, are forced to flee. Embarking on a harrowing journey, they must unravel a series of codes, which are the work of a brilliant scientist whose obsession with the end of the world is matched only by his passion for one of the most influential masterpieces ever written, Dante Alighieri's The Inferno.\n" +
                "\n" +
                "Dan Brown has raised the bar yet again, combining classical Italian art, history, and literature with cutting-edge science in this sumptuously entertaining thriller.", "", false, false,"https://i.gr-assets.com/images/S/compressed.photo.goodreads.com/books/1534070896l/17212231.jpg" ,genres.stream()
                .filter(g -> g.getName().equalsIgnoreCase("Thriller") ||
                        g.getName().equalsIgnoreCase("Fiction") ||
                        g.getName().equalsIgnoreCase("Mystery"))
                .collect(Collectors.toList())));

        books.add(new Book("0385514239", "Origin", LocalDate.of(2017, 10, 3), authors.get(4), 3.86, 461, "Robert Langdon, Harvard professor of symbology and religious iconology, arrives at the ultramodern Guggenheim Museum Bilbao to attend a major announcement—the unveiling of a discovery that “will change the face of science forever.” The evening’s host is Edmond Kirsch, a forty-year-old billionaire and futurist whose dazzling high-tech inventions and audacious predictions have made him a renowned global figure. Kirsch, who was one of Langdon’s first students at Harvard two decades earlier, is about to reveal an astonishing breakthrough . . . one that will answer two of the fundamental questions of human existence. As the event begins, Langdon and several hundred guests find themselves captivated by an utterly original presentation, which Langdon realizes will be far more controversial than he ever imagined. But the meticulously orchestrated evening suddenly erupts into chaos, and Kirsch’s precious discovery teeters on the brink of being lost forever. Reeling and facing an imminent threat, Langdon is forced into a desperate bid to escape Bilbao. With him is Ambra Vidal, the elegant museum director who worked with Kirsch to stage the provocative event. Together they flee to Barcelona on a perilous quest to locate a cryptic password that will unlock Kirsch’s secret. Navigating the dark corridors of hidden history and extreme religion, Langdon and Vidal must evade a tormented enemy whose all-knowing power seems to emanate from Spain’s Royal Palace itself . . . and who will stop at nothing to silence Edmond Kirsch. On a trail marked by modern art and enigmatic symbols, Langdon and Vidal uncover clues that ultimately bring them face-to-face with Kirsch’s shocking discovery . . . and the breathtaking truth that has long eluded us. Origin is Dan Brown’s most brilliant and entertaining novel to date.", "", true, true,"https://i.gr-assets.com/images/S/compressed.photo.goodreads.com/books/1576370917l/32283133.jpg" ,genres.stream()
                .filter(g -> g.getName().equalsIgnoreCase("Thriller") ||
                        g.getName().equalsIgnoreCase("Fiction") ||
                        g.getName().equalsIgnoreCase("Mystery"))
                .collect(Collectors.toList())));

        books.add(new Book("0143124544", "Me Before You", LocalDate.of(2012, 12, 31), authors.get(7), 4.26, 369, "They had nothing in common until love gave them everything to lose . . .\n" +
                "\n" +
                "Louisa Clark is an ordinary girl living an exceedingly ordinary life—steady boyfriend, close family—who has barely been farther afield than their tiny village. She takes a badly needed job working for ex–Master of the Universe Will Traynor, who is wheelchair bound after an accident. Will has always lived a huge life—big deals, extreme sports, worldwide travel—and now he’s pretty sure he cannot live the way he is.\n" +
                "\n" +
                "Will is acerbic, moody, bossy—but Lou refuses to treat him with kid gloves, and soon his happiness means more to her than she expected. When she learns that Will has shocking plans of his own, she sets out to show him that life is still worth living.\n" +
                "\n" +
                "A Love Story for this generation and perfect for fans of John Green’s The Fault in Our Stars, Me Before You brings to life two people who couldn’t have less in common—a heartbreakingly romantic novel that asks, What do you do when making the person you love happy also means breaking your own heart?", "", true, false,"https://i.gr-assets.com/images/S/compressed.photo.goodreads.com/books/1387003413l/17347634.jpg" ,genres.stream()
                .filter(g -> g.getName().equalsIgnoreCase("Romance") ||
                        g.getName().equalsIgnoreCase("Fiction"))
                .collect(Collectors.toList())));

        books.add(new Book("0007442912", "Insurgent", LocalDate.of(2012, 5, 1), authors.get(2), 4.04, 525, "One choice can transform you—or it can destroy you. But every choice has consequences, and as unrest surges in the factions all around her, Tris Prior must continue trying to save those she loves—and herself—while grappling with haunting questions of grief and forgiveness, identity and loyalty, politics and love.\n" +
                "\n" +
                "Tris's initiation day should have been marked by celebration and victory with her chosen faction; instead, the day ended with unspeakable horrors. War now looms as conflict between the factions and their ideologies grows. And in times of war, sides must be chosen, secrets will emerge, and choices will become even more irrevocable—and even more powerful. Transformed by her own decisions but also by haunting grief and guilt, radical new discoveries, and shifting relationships, Tris must fully embrace her Divergence, even if she does not know what she may lose by doing so.\n" +
                "\n" +
                "New York Times bestselling author Veronica Roth's much-anticipated second book of the dystopian DIVERGENT series is another intoxicating thrill ride of a story, rich with hallmark twists, heartbreaks, romance, and powerful insights about human nature.", "", false, false, "https://i.gr-assets.com/images/S/compressed.photo.goodreads.com/books/1325667729l/11735983.jpg", genres.stream()
                .filter(g -> g.getName().equalsIgnoreCase("Fantasy") ||
                        g.getName().equalsIgnoreCase("Fiction") ||
                        g.getName().equalsIgnoreCase("Young Adult") ||
                        g.getName().equalsIgnoreCase("Science Fiction") ||
                        g.getName().equalsIgnoreCase("Adventure"))
                .collect(Collectors.toList())));

        books.add(new Book("0450040186", "The Shining", LocalDate.of(1977, 1, 28), authors.get(5), 4.22, 659, "Jack Torrance's new job at the Overlook Hotel is the perfect chance for a fresh start. As the off-season caretaker at the atmospheric old hotel, he'll have plenty of time to spend reconnecting with his family and working on his writing. But as the harsh winter weather sets in, the idyllic location feels ever more remote...and more sinister. And the only one to notice the strange and terrible forces gathering around the Overlook is Danny Torrance, a uniquely gifted five-year-old.", "", false, false,"https://i.gr-assets.com/images/S/compressed.photo.goodreads.com/books/1353277730l/11588.jpg" ,genres.stream()
                .filter(g -> g.getName().equalsIgnoreCase("Horror") ||
                        g.getName().equalsIgnoreCase("Fiction") ||
                        g.getName().equalsIgnoreCase("Thriller"))
                .collect(Collectors.toList())));

        jpaGenreRepository.saveAll(genres);
        jpaAuthorRepository.saveAll(authors);
        jpaBookRepository.saveAll(books);
    }
}
