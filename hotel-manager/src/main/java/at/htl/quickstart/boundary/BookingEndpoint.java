package at.htl.quickstart.boundary;

import at.htl.quickstart.entity.Booking;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("booking")
public class BookingEndpoint {

    @Inject
    EntityManager em;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAll(){
        TypedQuery<Booking> query = em.createNamedQuery("Booking.getAll", Booking.class);
        List<Booking> bookings = query.getResultList();
        return Response.ok().entity(bookings).build();
    }
}
