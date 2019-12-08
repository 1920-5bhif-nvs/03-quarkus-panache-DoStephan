package at.htl.quickstart.control;

import at.htl.quickstart.entity.Booking;
import at.htl.quickstart.entity.Guest;
import at.htl.quickstart.entity.Hotel;
import at.htl.quickstart.entity.Room;
import io.quarkus.runtime.StartupEvent;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class InitBean {

    @Inject
    EntityManager em;

    @Transactional
    public void init(@Observes StartupEvent ev){
        initGuest();
        initHotel();
        initRoom();
        initBooking();
    }

    private void initBooking() {
        List<Guest> guests = em.createNamedQuery("Guest.getAll", Guest.class).getResultList();
        List<Room> rooms = em.createNamedQuery("Room.getAll", Room.class).getResultList();
        Booking[] bookings = {
                new Booking(70, "Euro", 3, guests.get(0), rooms.get(2)),
                new Booking(70, "Euro", 3, guests.get(1), rooms.get(2)),
                new Booking(50, "Euro", 1, guests.get(2), rooms.get(3)),
                new Booking(150, "Euro", 7, guests.get(3), rooms.get(4)),
                new Booking(150, "Euro", 7, guests.get(4), rooms.get(4)),
        };
        for (Booking booking : bookings) {
            em.persist(booking);
        }
    }

    private void initRoom() {
        List<Hotel> hotels = em.createNamedQuery("Hotel.getAll", Hotel.class).getResultList();
        for (int i = 1; i < 50; i++) {
            Room room = new Room(i);
            room.setHotel(hotels.get(0));
            em.persist(room);
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
            em.persist(guest);
        }
    }

    private void initHotel() {
        Hotel[] hotels = {
                new Hotel("Ibis"),
                new Hotel("Meininger Hotel"),
        };
        for (Hotel hotel : hotels) {
            em.persist(hotel);
        }
    }
}
