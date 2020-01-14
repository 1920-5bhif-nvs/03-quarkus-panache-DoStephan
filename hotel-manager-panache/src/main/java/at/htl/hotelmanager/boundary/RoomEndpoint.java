package at.htl.hotelmanager.boundary;

import at.htl.hotelmanager.entity.*;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("room")
public class RoomEndpoint {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAll(){
        List<Room> rooms = Booking.listAll();
        return Response.ok().entity(rooms).build();
    }
}
