package at.htl.hotelmanager.control;

import at.htl.hotelmanager.entity.Hotel;
import io.quarkus.runtime.StartupEvent;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;
import javax.transaction.Transactional;

@ApplicationScoped
public class InitBean {

    @Transactional
    public void init(@Observes StartupEvent ev){
        initHotel();
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
