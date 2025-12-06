package fr.efrei.domain;

public class Hall {
    private int hallID;
    private static int hallIDCounter = 0;
    private String hallName;
    private int nbSeats;

    public Hall() {}

    public Hall(int hallID, String hallName, int nbSeats) {
        hallIDCounter++;
        this.hallID = hallIDCounter;
        this.hallName = hallName;
        this.nbSeats = nbSeats;
    }

    public int getHallID() {
        return hallID;
    }

    public void setHallID(int hallID) {
        this.hallID = hallID;
    }

    public String getHallName() {
        return hallName;
    }

    public void setHallName(String hallName) {
        this.hallName = hallName;
    }

    public int getNbSeats() {
        return nbSeats;
    }

    public void setNbSeats(int nbSeats) {
        this.nbSeats = nbSeats;
    }

    @Override
    public String toString() {
        return "Hall{" +
                "hallID=" + hallID +
                ", hallName='" + hallName + '\'' +
                ", nbSeats=" + nbSeats +
                '}';
    }
}
