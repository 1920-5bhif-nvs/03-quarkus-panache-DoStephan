package at.htl.quickstart.entity;

import javax.persistence.*;

@NamedQueries(value = {
        @NamedQuery(name = "Booking.getAll", query = "select b from Booking b")
})
@Entity
public class Booking {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private double price;
    private int nightSpan;
    private String currency;
    @ManyToOne
    private Guest guest;
    @ManyToOne
    private Room room;

    public Booking() {
    }

    public Booking(double price, String currency, int nightSpan, Guest guest, Room room) {
        this.price = price;
        this.currency = currency;
        this.nightSpan = nightSpan;
        this.guest = guest;
        this.room = room;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getNightSpan() {
        return nightSpan;
    }

    public void setNightSpan(int nightSpan) {
        this.nightSpan = nightSpan;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public Guest getGuest() {
        return guest;
    }

    public void setGuest(Guest guest) {
        this.guest = guest;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }
}
