package at.htl.quickstart.boundary;

import at.htl.quickstart.entity.Hotel;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("hotel")
public class HotelEndpoint {

    @Inject
    EntityManager em;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAll() {
        TypedQuery<Hotel> query = em.createNamedQuery("Hotel.getAll", Hotel.class);
        List<Hotel> hotels = query.getResultList();
        return Response.ok().entity(hotels).build();
    }
}
