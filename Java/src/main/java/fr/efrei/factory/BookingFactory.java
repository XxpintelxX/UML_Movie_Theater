package fr.efrei.factory;

import fr.efrei.domain.*;
import fr.efrei.factory.*;

public class BookingFactory {

    // Méthode statique pour créer une simple réservation
    public static Booking createReservation(Customer customer, Show show) {
        // La date de la réservation est alignée sur celle du show
        return new Booking(show.getDate(), customer, Status.RESERVED);
    }

    // Méthode pour créer une réservation immédiatement payée
    public static Booking createPaidBooking(Customer customer, Show show) {
        // On pourrait ajouter ici une vérification de solde avant de créer l'objet
        return new Booking(show.getDate(), customer, Status.PAID);
    }
}
