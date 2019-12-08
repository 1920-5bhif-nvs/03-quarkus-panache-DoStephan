package at.htl.quickstart.control;

import at.htl.quickstart.entity.Guest;
import io.quarkus.runtime.StartupEvent;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;

@ApplicationScoped
public class InitBean {

    @Inject
    EntityManager em;

    @Transactional
    public void init(@Observes StartupEvent ev){
        Guest[] guests = {
                new Guest("Steve"),
                new Guest("Nero"),
                new Guest("Luna"),
        };
        for (Guest guest : guests) {
            em.persist(guest);
        }
    }
}
