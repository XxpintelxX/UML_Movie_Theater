package fr.efrei.repository;

import fr.efrei.domain.Booking;
import java.util.ArrayList;
import java.util.List;

public class BookingRepository implements IBookingRepository{
    private static BookingRepository instance;
    private List<Booking> bookingList;

    private BookingRepository() {
        this.bookingList = new ArrayList<>();
    }

    public static BookingRepository getInstance() {
        if (instance == null) {
            instance = new BookingRepository();
        }
        return instance;
    }

    @Override
    public void save(Booking booking) {
        this.bookingList.add(booking);
    }

    @Override
    public Booking findById(int id) {
        for (Booking booking : bookingList) {
            if (booking.getBookingID() == id) {
                return booking;
            }
        }
        return null; // Retourne null si non trouvé
    }

    @Override
    public List<Booking> findAll() {
        return this.bookingList;
    }

    @Override
    public void delete(Booking booking) {
        this.bookingList.remove(booking);
    }
}