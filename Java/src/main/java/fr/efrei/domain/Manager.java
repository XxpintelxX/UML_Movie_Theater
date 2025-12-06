package fr.efrei.domain;

import fr.efrei.factory.BookingFactory;

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
                        if (s.getHall() != null) {
                            if (b.getBookingIDCounter() >= s.getHall().getNbSeats()) {
                                canReserve = false;
                            }
                        }
                    }
                }
            }
        }

        return canReserve;
    }

    public boolean checkCustomerCanPay(Customer customer, int bookingId) {
        boolean canPay = false;

        for (Movie m : listMovies) {
            for (Show s : m.getListShows()) {
                for (Booking b : s.getListBookings()) {
                    if ((b.getCustomer().equals(customer)) && (b.getStatus().equals(Status.RESERVED))) {
                        canPay = true;
                    }
                }
            }
        }

        return canPay;
    }

    public void addBooking(Customer customer, int showID) {
        for (Movie m : listMovies) {
            for (Show s : m.getListShows()) {
                if (s.getShowID() == (showID)) {
                    s.addBooking(BookingFactory.createReservation(customer, s));
                }
            }
        }
    }

    public void customerPays(Customer customer, int bookingID) {
        for (Movie m : listMovies) {
            for (Show s : m.getListShows()) {
                for (Booking b : s.getListBookings()) {
                    if ((b.getCustomer().equals(customer)) && (b.getStatus().equals(Status.RESERVED))) {
                        if (customer.canPay(s.getPrice())) {
                            customer.paying(s.getPrice());
                            b.paid();
                        }
                    }
                }
            }
        }
    }
}


