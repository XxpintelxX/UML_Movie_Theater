package fr.efrei.repository;

import fr.efrei.domain.Booking;

import java.util.List;

public interface IBookingRepository {
    public void save(Booking booking);
    public Booking findById(int id);
    public List<Booking> findAll();
    public void delete(Booking booking);
}
