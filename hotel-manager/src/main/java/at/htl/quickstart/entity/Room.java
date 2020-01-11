package at.htl.quickstart.entity;

import javax.persistence.*;

@NamedQueries(value = {
        @NamedQuery(name = "Room.getAll", query = "select r from Room r")
})
@Entity
public class Room {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int roomNr;
    @ManyToOne(fetch = FetchType.LAZY)
    private Hotel hotel;

    public Room() {
    }

    public Room(int roomNr) {
        this.roomNr = roomNr;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getRoomNr() {
        return roomNr;
    }

    public void setRoomNr(int roomNr) {
        this.roomNr = roomNr;
    }

    @Override
    public String toString() {
        return "Room{" +
                "id=" + id +
                ", roomNr=" + String.format("%03d", roomNr) +
                '}';
    }

    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }
}
