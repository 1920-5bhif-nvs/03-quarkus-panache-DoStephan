package at.htl.quickstart.control;

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
        initHotel();
        initGuest();
        initRoom();
    }

    private void initRoom() {
        for (int i = 1; i < 50; i++) {
            em.persist(new Room(i));
        }
    }

    private void initGuest() {
        Guest[] guests = {
                new Guest("Steve"),
                new Guest("Nero"),
                new Guest("Luna"),
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
