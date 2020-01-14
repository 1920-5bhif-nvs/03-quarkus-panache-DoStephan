package at.htl.hotelmanager.control;

import at.htl.hotelmanager.entity.Booking;
import at.htl.hotelmanager.entity.Guest;
import at.htl.hotelmanager.entity.Hotel;
import at.htl.hotelmanager.entity.Room;
import io.quarkus.runtime.StartupEvent;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;
import javax.transaction.Transactional;
import java.io.LineNumberReader;
import java.util.List;

@ApplicationScoped
public class InitBean {

    @Transactional
    public void init(@Observes StartupEvent ev){
        initHotel();
        initGuest();
        initRoom();
        initBooking();
    }

    private void initBooking() {
        List<Guest> guests = Guest.listAll();
        List<Room> rooms = Room.listAll();
        Booking[] bookings = {
                new Booking(70, "Euro", 3, guests.get(0), rooms.get(2)),
                new Booking(70, "Euro", 3, guests.get(1), rooms.get(2)),
                new Booking(50, "Euro", 1, guests.get(2), rooms.get(3)),
                new Booking(150, "Euro", 7, guests.get(3), rooms.get(4)),
                new Booking(150, "Euro", 7, guests.get(4), rooms.get(4)),
        };
        for (Booking booking : bookings) {
            booking.persist();
        }
    }

    private void initRoom() {
        List<Hotel> hotels = Hotel.listAll();
        for (int i = 1; i < 50; i++) {
            Room room = new Room(i);
            room.setHotel(hotels.get(0));
            room.persist();
        }
    }

    private void initGuest() {
        Guest[] guests = {
                new Guest("Steve"),
                new Guest("Nero"),
                new Guest("Luna"),
                new Guest("Alan"),
                new Guest("Maya"),
                new Guest("John"),
        };
        for (Guest guest : guests) {
            guest.persist();
        }
    }

    private void initHotel() {
        Hotel[] hotels = {
                new Hotel("Ibis"),
                new Hotel("Meininger Hotel"),
        };
        for (Hotel hotel : hotels) {
            hotel.persist();
        }
    }

}
