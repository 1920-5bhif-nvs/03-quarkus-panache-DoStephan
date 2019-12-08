package at.htl.quickstart.boundary;

import at.htl.quickstart.entity.Guest;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("guest")
public class GuestEndpoint {

    @Inject
    EntityManager em;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAll() {
        TypedQuery<Guest> query = em.createNamedQuery("Guest.getAll", Guest.class);
        List<Guest> guests = query.getResultList();
        return Response.ok().entity(guests).build();
    }
}
