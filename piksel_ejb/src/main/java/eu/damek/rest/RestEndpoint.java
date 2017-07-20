package eu.damek.rest;

import eu.damek.model.Payment;

import javax.ejb.Stateless;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

@Stateless
@Path("/")
@Produces({"application/json"})
@Consumes({"application/json"})
public class RestEndpoint {


    @POST
    @Path("reset")
    public Response reset() {
        //TODO reset all counter
        return Response.status(Response.Status.ACCEPTED).build();
    }

    @POST
    @Path("viewing")
    public Response nicks(@FormParam("episode") final String episode,
                          @FormParam("customer") final String customer) {
        //TODO count viewed counter
        return Response.status(Response.Status.ACCEPTED).build();
    }

    @GET
    @Path("payments")
    public List<Payment> payments(){
        // TODO: 20/07/2017 get list of payments
        return new ArrayList<>();
    }

    @GET
    @Path("payments/{id}")
    public Payment payment(@PathParam("id") final String id){
        // TODO: 20/07/2017 get one
        return new Payment();
    }

}
