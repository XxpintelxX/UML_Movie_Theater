import java.util.*;

public class Main {
    public static void main(String[] args) {

        // CREATING MOVIE
        ArrayList<Movie> listMovies = new ArrayList<Movie>();
        Movie movie = new Movie(
                1,
                "Alice in Wonderland",
                new Time(0, 48, 1),
                "Adventure, Fantastic, Young",
                5.2,
                "Alice, now 19 years old, returns to the whimsical world she first entered as a child and embarks on a journey to discover her true destiny.",
                new ArrayList<Show>());

        Movie movie1 = new Movie(
                2,
                "Arrival",
                new Time(0, 56, 1),
                "Science-Fiction, Thriller",
                7.6,
                "Taking place after alien crafts land around the world, an expert linguist is recruited by the military to determine whether they come in peace or are a threat.",
                new ArrayList<Show>());

        listMovies.add(movie);
        listMovies.add(movie1);

        // ADDING SHOW TO MOVIE
        Show s = new Show(1, new Date(2025, 11, 30), movie.getDuration(), new Time(0, 30, 11), 11.5, new Hall(3, "Georges Lucas", 145), new ArrayList<Booking>());
        Show s1 = new Show(2, new Date(2025, 12, 5), movie1.getDuration(), new Time(0, 45, 9), 11.5, new Hall(1, "Steven Spielberg", 100), new ArrayList<Booking>());
        movie.addShow(s);
        movie1.addShow(s1);

        // ADDING BOOKING TO SHOW
        Customer c = new Customer(0, "Yrieix", "de Salaberry", "yrieix@gmail.com", "0607080910");
        Booking b = new Booking(1, s.getDate(), c, Status.RESERVED);
        movie.addBooking(b, s);

        Customer c1 = new Customer(1, "Mattéo", "Cousinard", "mattéo@gmail.com", "0710136790");
        Booking b1 = new Booking(2, s.getDate(), c1, Status.PAID);
        Booking b2 = new Booking(3, s1.getDate(), c1, Status.RESERVED);
        movie.addBooking(b1, s);
        movie1.addBooking(b2, s1);

        // PRINTING THE LIST OF MOVIES WITH ALL THE INFORMATION OF EACH MOVIE
        System.out.println("===== LIST OF MOVIES =====");
        displayMovies(listMovies);
        System.out.println();

    }

    public static void displayMovies(ArrayList<Movie> listMovies) {
        for (Movie m : listMovies) {
            System.out.println(m);
        }
    }
}
