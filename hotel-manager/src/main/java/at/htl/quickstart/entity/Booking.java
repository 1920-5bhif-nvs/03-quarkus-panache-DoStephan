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

    public Booking() {
    }

    public Booking(double price) {
        this.price = price;
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
}
