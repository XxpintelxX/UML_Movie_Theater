import java.util.*;

public class Movie {
    private int movieID;
    private String title;
    private Time duration;
    private String genre;
    private double rating;
    private String description;
    private ArrayList<Show> listShows;


    public Movie() {}

    public Movie(int movieID, String title, Time duration, String genre, double rating, String description, ArrayList<Show> listShows) {
        this.movieID = movieID;
        this.title = title;
        this.duration = duration;
        this.genre = genre;
        this.rating = rating;
        this.description = description;
        this.listShows = listShows;
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
