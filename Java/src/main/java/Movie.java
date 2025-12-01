import java.util.*;

public class Movie {
    private int movieID;
    private static int movieIDCounter = 0;
    private String title;
    private Time duration;
    private String genre;
    private double rating;
    private String description;
    private ArrayList<Show> listShows;

    public Movie(MovieBuilder builder) {
        movieIDCounter++;
        this.movieID = movieIDCounter;
        this.title = builder.title;
        this.duration = builder.duration;
        this.genre = builder.genre;
        this.rating = builder.rating;
        this.description = builder.description;
        this.listShows = builder.listShows != null ? builder.listShows : new ArrayList<>();
    }

    public static class MovieBuilder {
        private final String title;

        private Time duration = null;
        private String genre = null;
        private double rating = 0.0;
        private String description = null;
        private ArrayList<Show> listShows = null;

        public MovieBuilder(String title) {
            this.title = title;
        }

        public MovieBuilder duration(Time duration) {
            this.duration = duration;
            return this;
        }

        public MovieBuilder genre(String genre) {
            this.genre = genre;
            return this;
        }

        public MovieBuilder rating(double rating) {
            this.rating = rating;
            return this;
        }

        public MovieBuilder description(String description) {
            this.description = description;
            return this;
        }

        public MovieBuilder listShows(ArrayList<Show> listShows) {
            this.listShows = listShows;
            return this;
        }

        public Movie build() {
            return new Movie(this);
        }
    }

    public int getMovieID() {
        return movieID;
    }

    public void setMovieID(int movieID) {
        this.movieID = movieID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Time getDuration() {
        return duration;
    }

    public void setDuration(Time duration) {
        this.duration = duration;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ArrayList<Show> getListShows() {
        return listShows;
    }

    public void setListShows(ArrayList<Show> listShows) {
        this.listShows = listShows;
    }

    @Override
    public String toString() {
        return "Movie #" + movieID + " : " + title + "\n" +
                "\t- Duration : " + duration + "\n" +
                "\t- Genre : " + genre + "\n" +
                "\t- Rating : " + rating + "\n" +
                "\t- Description : " + description + "\n" +
                "\t- List of Shows : " + displayShows();
    }

    public void addShow(Show s) {
        listShows.add(s);
    }

    public String displayShows() {
        String res = "\n\t";
        for (Show s : listShows) {
            res += s;
            res += "\n\t";
        }
        return res;
    }

    public void addBooking(Booking b, Show s) {
        listShows.get(listShows.indexOf(s)).addBooking(b);
    }
}
