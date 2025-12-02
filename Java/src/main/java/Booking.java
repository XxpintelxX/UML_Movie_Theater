public class Booking {
    private int bookingID;
    private static int bookingIDCounter;
    private Date date;
    private Customer customer;
    private Status status;

    public Booking() {}

    public Booking(Date date, Customer customer, Status status) {
        bookingIDCounter++;
        this.bookingID = bookingIDCounter;
        this.date = date;
        this.customer = customer;
        this.status = status;
    }

    public int getBookingID() {
        return bookingID;
    }

    public void setBookingID(int bookingID) {
        this.bookingID = bookingID;
    }

    public static int getBookingIDCounter() {
        return bookingIDCounter;
    }

    public static void setBookingIDCounter(int bookingIDCounter) {
        Booking.bookingIDCounter = bookingIDCounter;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Booking #" + bookingID + " : \n" +
                "\t\t\t- Date : " + date + "\n" +
                "\t\t\t- Customer : " + customer + "\n" +
                "\t\t\t- Status : " + status;
    }

}
