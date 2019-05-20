package hr.mobile.apps.course.lab9.config;

import java.util.ArrayList;
import java.util.List;

import hr.mobile.apps.course.lab9.model.Book;
import hr.mobile.apps.course.lab9.model.Publisher;
import hr.mobile.apps.course.lab9.model.User;

public class Mock {

    public class Credentials {
        public static final String EMAIL = "student@gmail.com";
        public static final String PASSWORD = "password";
        public static final String TOKEN = "EvNElvTOZvi1fnczpuVR77dQT3GlKkjtaRSFZmEo";
    }

    public static final User USER = new User(1, "Kariane", "Gibson", "admin@app.com", true);

    public static final List<Book> BOOKS = new ArrayList<Book>() {{
        add(new Book(1,
                "Crime and Punishment",
                1, 671, "1866-01-01", 4.20, 9780143058144L, 5,
                "https://images-na.ssl-images-amazon.com/images/I/71CcO-jvRUL.jpg",
                "One of the supreme masterpieces of world literature, Crime and Punishment catapulted Fyodor Dostoyevsky to the forefront of Russian writers and into the ranks of the world's greatest novelists. Drawing upon experiences from his own prison days, the author recounts in feverish, compelling tones the story of Raskolnikov, an impoverished student tormented by his own nihilism, and the struggle between good and evil. Believing that he is above the law, and convinced that humanitarian ends justify vile means, he brutally murders an old woman--a pawnbroker whom he regards as \"stupid, ailing, greedy...good for nothing.\" Overwhelmed afterwards by feelings of guilt and terror, Raskolnikov confesses to the crime and goes to prison. There he realizes that happiness and redemption can only be achieved through suffering. Infused with forceful religious, social, and philosophical elements, the novel was an immediate success. This extraordinary, unforgettable work is reprinted here in the authoritative Constance Garnett translation.",
                "2019-05-02 12:39:35",
                "2019-05-02 12:39:35",
                new ArrayList<>(), new ArrayList<>(),
                new Publisher(1, "Granta books", "2019-05-02 12:39:35", "2019-05-02 12:39:35")));
        add(new Book(2,
                "Notes from Underground",
                1, 96, "1864-01-01", 4.19, 9780486270531L, 6,
                "https://images-na.ssl-images-amazon.com/images/I/51G45Mh83iL.jpg",
                "Dostoevsky’s most revolutionary novel, Notes from Underground marks the dividing line between nineteenth- and twentieth-century fiction, and between the visions of self each century embodied. One of the most remarkable characters in literature, the unnamed narrator is a former official who has defiantly withdrawn into an underground existence. In full retreat from society, he scrawls a passionate, obsessive, self-contradictory narrative that serves as a devastating attack on social utopianism and an assertion of man’s essentially irrational nature.",
                "2019-05-02 12:39:35",
                "2019-05-02 12:39:35",
                new ArrayList<>(), new ArrayList<>(),
                new Publisher(1, "Granta books", "2019-05-02 12:39:35", "2019-05-02 12:39:35")));
        add(new Book(3,
                "Anna Karenina",
                1, 864, "1851-01-01", 4.03, 9780140449174L, 20,
                "https://images-na.ssl-images-amazon.com/images/I/51No5KBspvL._SX321_BO1,204,203,200_.jpg",
                "Some people say Anna Karenina is the single greatest novel ever written, which makes about as much sense to me as trying to determine the world's greatest color. But there is no doubt that Anna Karenina, generally considered Tolstoy's best book, is definitely one ripping great read. Anna, miserable in her loveless marriage, does the barely thinkable and succumbs to her desires for the dashing Vronsky. I don't want to give away the ending, but I will say that 19th-century Russia doesn't take well to that sort of thing.",
                "2019-05-02 12:39:35",
                "2019-05-02 12:39:35",
                new ArrayList<>(), new ArrayList<>(),
                new Publisher(1, "Granta books", "2019-05-02 12:39:35", "2019-05-02 12:39:35")));
    }};

}
