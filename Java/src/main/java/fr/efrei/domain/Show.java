package fr.efrei.domain;

import java.util.*;

public class Show {
    private int showID;
    private static int showIDCounter = 0;
    private Date date;
    private Time duration;
    private Time startTime;
    private double price;
    private Hall hall;
    private ArrayList<Booking> listBookings;

    public Show(ShowBuilder builder) {
        showIDCounter++;
        this.showID = showIDCounter;
        this.date = builder.date;
        this.duration = builder.duration;
        this.startTime = builder.startTime;
        this.price = builder.price;
        this.hall = builder.hall;
        this.listBookings = builder.listBookings;
    }

    public static class ShowBuilder {

        private Date date = null;
        private Time duration = null;
        private Time startTime = null;
        private double price = 0.0;
        private Hall hall = null;
        private ArrayList<Booking> listBookings = new ArrayList<Booking>();

        public ShowBuilder() {}

        public ShowBuilder date(Date date) {
            this.date = date;
            return this;
        }

        public ShowBuilder duration(Time duration) {
            this.duration = duration;
            return this;
        }

        public ShowBuilder startTime(Time startTime) {
            this.startTime = startTime;
            return this;
        }

        public ShowBuilder price(double price) {
            this.price = price;
            return this;
        }

        public ShowBuilder hall(Hall hall) {
            this.hall = hall;
            return this;
        }

        public ShowBuilder listBookings(ArrayList<Booking> listBookings) {
            this.listBookings = listBookings;
            return this;
        }

        public Show build() {
            return new Show(this);
        }
    }

    public int getShowID() {
        return showID;
    }

    public void setShowID(int showID) {
        this.showID = showID;
    }

    public static int getShowIDCounter() {return showIDCounter;}

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Time getDuration() {
        return duration;
    }

    public void setDuration(Time duration) {
        this.duration = duration;
    }

    public Time getStartTime() {
        return startTime;
    }

    public void setStartTime(Time startTime) {
        this.startTime = startTime;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Hall getHall() {
        return hall;
    }

    public void setHall(Hall hall) {
        this.hall = hall;
    }

    public ArrayList<Booking> getListBookings() {
        return listBookings;
    }

    public void setListBookings(ArrayList<Booking> listBookings) {
        this.listBookings = listBookings;
    }

    @Override
    public String toString() {
        return "Show #" + showID + " :\n" +
                "\t\t- Date : " + date + "\n" +
                "\t\t- Duration : " + duration + "\n" +
                "\t\t- Time of start : " + startTime + "\n" +
                "\t\t- Price : " + price + "\n" +
                "\t\t- Hall : " + hall + "\n" +
                "\t\t- List of Bookings : " + displayBookings();
    }

    public void addBooking(Booking b) {
        listBookings.add(b);
    }

    public String displayBookings() {
        String res = "\n\t\t";
        for (Booking b : listBookings) {
            res += b;
            res += "\n\t\t";
        }
        return res;
    }
}
