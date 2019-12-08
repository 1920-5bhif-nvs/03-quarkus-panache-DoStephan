package at.htl.quickstart.boundary;

import at.htl.quickstart.entity.Room;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("room")
public class RoomEndpoint {

    @Inject
    EntityManager em;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAll(){
        TypedQuery<Room> query = em.createNamedQuery("Room.getAll", Room.class);
        List<Room> rooms = query.getResultList();
        return Response.ok().entity(rooms).build();
    }
}
