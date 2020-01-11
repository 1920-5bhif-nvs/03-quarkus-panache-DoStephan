package at.htl.hotelmanager.boundary;

import at.htl.hotelmanager.entity.Hotel;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("hotel")
public class HotelEndpoint {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAll() {
        List<Hotel> hotels = Hotel.listAll();
        return Response.ok().entity(hotels).build();
    }
}
