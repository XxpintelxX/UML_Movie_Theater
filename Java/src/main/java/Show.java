import java.util.*;

public class Show {
    private int showID;
    private Date date;
    private Time duration;
    private Time startTime;
    private double price;
    private Hall hall;
    private ArrayList<Booking> listBookings;

    public Show() {}

    public Show(int showID, Date date, Time duration, Time startTime, double price, Hall hall, ArrayList<Booking> listBookings) {
        this.showID = showID;
        this.date = date;
        this.duration = duration;
        this.startTime = startTime;
        this.price = price;
        this.hall = hall;
        this.listBookings = listBookings;
    }

    public int getShowID() {
        return showID;
    }

    public void setShowID(int showID) {
        this.showID = showID;
    }

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
