import java.awt.print.Book;
import java.util.ArrayList;

public class Manager {
    private static Manager manager;
    private ArrayList<Movie> listMovies;

    private Manager() {
        listMovies = new ArrayList<Movie>();
    }

    public static Manager getInstance() {
        if (manager == null) {
            manager = new Manager();
        }
        return manager;
    }

    public ArrayList<Movie> getListMovies() {return listMovies;}

    public void setListMovies(ArrayList<Movie> listMovies) {
        this.listMovies = listMovies;
    }

    public void addListMovies(Movie m) {
        listMovies.add(m);
    }

    public boolean verifyEntry(Customer c, Show s) {
        boolean isAllowed = false;
        for (Booking b : s.getListBookings()) {
                        if (b.getCustomer().equals(c) && b.getStatus().equals(Status.PAID)) {
                            isAllowed = true;
                        }
                    }

        return isAllowed;
    }

    public boolean checkCustomerCanReserve(Customer customer, int showID) {
        boolean canReserve = true;

        for (Movie m : listMovies) {
            for (Show s : m.getListShows()) {
                if (s.getShowID() == (showID)) {
                    for (Booking b : s.getListBookings()) {
                        if (b.getCustomer().equals(customer)) {
                            canReserve = false;
                        }
                    }
                }
            }
        }

        return canReserve;
    }

    public void addBooking(Customer customer, int showID) {
        for (Movie m : listMovies) {
            for (Show s : m.getListShows()) {
                if (s.getShowID() == (showID)) {
                    s.addBooking(new Booking(s.getDate(), customer, Status.RESERVED));
                }
            }
        }
    }
}
