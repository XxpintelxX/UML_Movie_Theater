import java.util.*;

public class Main {
    public static void main(String[] args) {

        // CREATING MOVIE
//        ArrayList<Movie> listMovies = new ArrayList<Movie>();
        Manager manager = Manager.getInstance();
//        manager.setListMovies(listMovies);

        Movie movie = new Movie.MovieBuilder("Alice in Wonderland")
                .duration(new Time(0, 48, 1))
                .genre("Adventure, Fantastic, Young")
                .rating(5.2)
                .description("Alice, now 19 years old, returns to the whimsical world she first entered as a child and embarks on a journey to discover her true destiny.")
                .build();

        Movie movie1 = new Movie.MovieBuilder("Arrival")
                .duration(new Time(0, 56, 1))
                .genre("Science Fiction, Thriller")
                .rating(7.6)
                .description("Taking place after alien crafts land around the world, an expert linguist is recruited by the military to determine whether they come in peace or are a threat.")
                .build();

//        listMovies.add(movie);
//        listMovies.add(movie1);
        manager.addListMovies(movie);
        manager.addListMovies(movie1);


        // ADDING SHOW TO MOVIE
        Show s = new Show.ShowBuilder()
                .date(new Date(2025, 11, 30))
                .duration(movie.getDuration())
                .startTime(new Time(0, 30, 11))
                .hall(new Hall(3, "Georges Lucas", 145))
                .listBookings(new ArrayList<Booking>())
                .build();

        Show s1 = new Show.ShowBuilder()
                .date(new Date(2025, 12, 5))
                .duration(movie1.getDuration())
                .startTime(new Time(0, 45, 9))
                .hall(new Hall(1, "Steven Spielberg", 100))
                .listBookings(new ArrayList<Booking>())
                .build();

        movie.addShow(s);

        movie1.addShow(s1);

        // ADDING BOOKING TO SHOW
        Customer c = new Customer(0, "Yrieix", "de Salaberry", "yrieix@gmail.com", "0607080910", "T-REX123");
        Booking b = new Booking(s.getDate(), c, Status.RESERVED);
        movie.addBooking(b, s);

        Customer c1 = new Customer(1, "Mattéo", "Cousinard", "matteo@gmail.com", "0710136790", "JAVAGENIUS");
        Booking b1 = new Booking(s.getDate(), c1, Status.PAID);
        Booking b2 = new Booking(s1.getDate(), c1, Status.RESERVED);
        movie.addBooking(b1, s);
        movie1.addBooking(b2, s1);

        // CREATING AND ADDING CUSTOMERS TO THE LIST OF CUSTOMERS
        ArrayList<Customer> listCustomers = new ArrayList<Customer>();
        listCustomers.add(c);
        listCustomers.add(c1);

        // PRINTING THE LIST OF MOVIES WITH ALL THE INFORMATION OF EACH MOVIE
        System.out.println("===== LIST OF MOVIES =====");
        displayMovies(manager.getListMovies());
        System.out.println();

        // LOOP FOR CONSOLE INTERFACE
        String input = "";
        Scanner scanner = new Scanner(System.in);
        while (!input.equals("0")) {
            System.out.println("0- Exit");
            System.out.println("1- Display movies");
            System.out.println("2- Add Movie");
            System.out.println("3- Enter Show as");
            System.out.println("4- Reserve Show as\n");
            input = scanner.nextLine();
            switch (input) {
                case "1":
                    displayMovies(manager.getListMovies());
                    break;
                case "2":
                    addMovie(manager.getListMovies());
                    break;
                case "3":
                    System.out.println("Enter your email :");
                    String checkingEmail = scanner.nextLine();

                    boolean isAllowed = enterShow(checkingEmail, listCustomers, manager.getListMovies());
                    if (isAllowed) {
                        System.out.println("You are allowed to enter.");
                    } else {
                        System.out.println("You are not allowed to enter");
                    }
                    break;
                case "4":
                    System.out.println("Enter your email :");
                    String reservingEmail = scanner.nextLine();
                    manager.setListMovies(addBooking(manager.getListMovies(), reservingEmail, listCustomers));
                default:
                    break;
            }
        }
    }

    public static ArrayList<Movie> addBooking(ArrayList<Movie> listMovies, String email, ArrayList<Customer> listCustomers) {
        // INITIALIZING NEEDED VARIABLES
        boolean foundCustomer = false;
        Customer customer = null;
        Manager manager = Manager.getInstance();

        // FINDING CUSTOMER WITH CORRESPONDING EMAIL
        for (Customer c : listCustomers) {
            if (c.getEmail().equals(email)) {
                foundCustomer = true;
                customer = c;
            }
        }

        // HANDLING CASE IF EMAIL DOES NOT CORRESPOND TO ANY EXISTING CUSTOMER
        if (!foundCustomer) {
            System.out.println("There is no customer with such email.");
            return listMovies;
        }

        // ASKING USER TO CONNECT
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your password (you have 3 tries) :");
        String pwdEntered = "";
        int i = 0;
        pwdEntered = scanner.nextLine();
        while ((i < 3) && !pwdEntered.equals(customer.getPassword())) {
            System.out.println("Wrong password, try again. You still got " + (3-(i+1)) + " tries");
            pwdEntered = scanner.nextLine();
            i++;
        }

        // HANDLING 3 WRONG PASSWORDS
        if (i >= 3) {
            System.out.println("You entered a wrong password 3 times.");
            return listMovies;
        }

        // SEEING WHICH SHOW DOES THE CUSTOMER WANT TO RESERVE
        System.out.println("Which show do you want to reserve ? (\"0\" to display the list of movies and shows) : ");
        int input = scanner.nextInt();
        while ((input <= 0) || (Show.getShowIDCounter() < input)) {
            if (input == 0) {
                displayMovies(listMovies);
            }
            System.out.println("Enter a number between 0 and " + Show.getShowIDCounter() + " : ");
            scanner.nextLine();
            input = scanner.nextInt();
        }

        // CHECKING IF CUSTOMER CAN RESERVE SHOW
        if (manager.checkCustomerCanReserve(customer, input)) {
            manager.addBooking(customer, input);
        }


        return listMovies;
    }

    public static boolean enterShow(String email, ArrayList<Customer> listCustomers, ArrayList<Movie> listMovies) {
        // INITIALIZING NEEDED VARIABLES
        boolean isAllowed = false;
        boolean foundCustomer = false;
        Customer customer = null;

        // FINDING CUSTOMER WITH CORRESPONDING EMAIL
        for (Customer c : listCustomers) {
            if (c.getEmail().equals(email)) {
                foundCustomer = true;
                customer = c;
            }
        }

        // HANDLING CASE IF EMAIL DOES NOT CORRESPOND TO ANY EXISTING CUSTOMER
        if (!foundCustomer) {
            System.out.println("There is no customer with such email.");
            return isAllowed;
        }

        // ASKING USER TO CONNECT
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your password (you have 3 tries) :");
        String pwdEntered = "";
        int i = 0;
        pwdEntered = scanner.nextLine();
        while ((i < 3) && !pwdEntered.equals(customer.getPassword())) {
            System.out.println("Wrong password, try again. You still got " + (3-(i+1)) + " tries");
            pwdEntered = scanner.nextLine();
            i++;
        }

        // HANDLING 3 WRONG PASSWORDS
        if (i >= 3) {
            System.out.println("You entered a wrong password 3 times.");
            return isAllowed;
        }

        // SEEING WHICH SHOW DOES THE CUSTOMER WANT TO ENTER
        System.out.println("Which show do you want to enter ? (\"0\" to display the list of movies and shows) : ");
        int input = scanner.nextInt();
        while ((input <= 0) || (Show.getShowIDCounter() < input)) {
            if (input == 0) {
                displayMovies(listMovies);
            }
            System.out.println("Enter a number between 0 and " + Show.getShowIDCounter() + " : ");
            scanner.nextLine();
            input = scanner.nextInt();
        }

        // CHECKING IF CUSTOMER IS ALLOWED
        for (Movie m : listMovies) {
            for (Show s : m.getListShows()) {
                if (s.getShowID() == input) {
                    Manager manager = Manager.getInstance();
                    isAllowed = manager.verifyEntry(customer, s);
                }
            }
        }

        return isAllowed;
    }

    public static void displayMovies(ArrayList<Movie> listMovies) {
        for (Movie m : listMovies) {
            System.out.println(m);
        }
    }

    public static void addMovie(ArrayList<Movie> listMovies) {
        Scanner s = new Scanner(System.in);

        int seconds, minutes, hours;

        System.out.println("Enter movie name : ");
        Movie.MovieBuilder mvb = new Movie.MovieBuilder(s.nextLine());

        System.out.println("Do you have a duration ? (y/n)");
        if (s.nextLine().equals("y")) {

            System.out.println("Enter number of seconds : ");
            seconds = s.nextInt();

            s.nextLine();
            System.out.println("Enter number of minutes : ");
            minutes = s.nextInt();

            s.nextLine();
            System.out.println("Enter number of hours : ");
            hours = s.nextInt();

            s.nextLine();
            mvb.duration(new Time(seconds, minutes, hours));
        }
        System.out.println("Do you have a genre(s) ? (y/n)");
        if (s.nextLine().equals("y")) {
            System.out.println("Enter genre(s) as this \"Genre1, Genre2, Genre3, ...\" : ");
            mvb.genre(s.nextLine());
        }
        System.out.println("Do you have a rating ? (y/n)");
        if (s.nextLine().equals("y")) {
            System.out.println("Enter rating : ");
            mvb.rating(s.nextDouble());

            s.nextLine();
        }
        System.out.println("Do you have a description ? (y/n)");
        if (s.nextLine().equals("y")) {
            System.out.println("Enter the description : ");
            mvb.description(s.nextLine());
        }

        System.out.println("Do you want to add a show(s) ? (y/n)");
        if (s.nextLine().equals("y")) {
            mvb.listShows(addShows());
        }

        Movie movie = mvb.build();
        listMovies.add(movie);
    }

    public static ArrayList<Show> addShows() {
        ArrayList<Show> listShows = new ArrayList<Show>();
        Scanner s = new Scanner(System.in);
        System.out.println("How many shows do you want to add ?");
        int nbShows = s.nextInt();
        s.nextLine();

        for (int i = 0; i < nbShows; i++) {
            System.out.println("Show #" + (i+1) + " : ");
            listShows.add(createShow());
        }
        return listShows;
    }

    public static Show createShow() {
        Scanner s = new Scanner(System.in);

        Show.ShowBuilder sb = new Show.ShowBuilder();

        System.out.println("Do you have a date ? (y/n)");
        if (s.nextLine().equals("y")) {
            int year, month, day;
            System.out.println("Enter year : ");
            year = s.nextInt();

            s.nextLine();
            System.out.println("Enter month : ");
            month = s.nextInt();

            s.nextLine();
            System.out.println("Enter day : ");
            day = s.nextInt();

            s.nextLine();
            sb.date(new Date(year, month, day));
        }

        System.out.println("Do you have a duration ? (y/n)");
        if (s.nextLine().equals("y")) {
            int seconds, minutes, hours;
            System.out.println("Enter number of seconds : ");
            seconds = s.nextInt();

            s.nextLine();
            System.out.println("Enter number of minutes : ");
            minutes = s.nextInt();

            s.nextLine();
            System.out.println("Enter number of hours : ");
            hours = s.nextInt();

            s.nextLine();
            sb.duration(new Time(seconds, minutes, hours));
        }

        System.out.println("Do you have a start time ? (y/n)");
        if (s.nextLine().equals("y")) {
            int seconds, minutes, hours;
            System.out.println("Enter seconds of start time : ");
            seconds = s.nextInt();

            s.nextLine();
            System.out.println("Enter minutes of start time : ");
            minutes = s.nextInt();

            s.nextLine();
            System.out.println("Enter hours of start time : ");
            hours = s.nextInt();

            s.nextLine();
            sb.startTime(new Time(seconds, minutes, hours));
        }

        System.out.println("Do you have a price ? (y/n)");
        if (s.nextLine().equals("y")) {
            System.out.println("Enter price : ");
            sb.price(s.nextDouble());

            s.nextLine();
        }
        System.out.println("Do you have a hall ? (y/n)");
        if (s.nextLine().equals("y")) {
            int hallID;
            String hallName;
            int nbSeats;
            System.out.println("Enter the hall ID : ");
            hallID = s.nextInt();
            s.nextLine();
            System.out.println("Enter hall Name : ");
            hallName = s.nextLine();
            System.out.println("Enter number of seats : ");
            nbSeats = s.nextInt();
            s.nextLine();
            sb.hall(new Hall(hallID, hallName, nbSeats));
        }

        Show show = sb.build();
        return show;
    }
}
