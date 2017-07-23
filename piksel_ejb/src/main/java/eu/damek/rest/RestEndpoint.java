package eu.damek.rest;

import eu.damek.dao.EpisodeDAO;
import eu.damek.dao.StudioDAO;
import eu.damek.entity.Episode;
import eu.damek.entity.Studio;
import eu.damek.exception.EpisodeNotFoundException;
import eu.damek.exception.StudioNotFoundException;
import eu.damek.model.Payment;
import eu.damek.model.PaymentOne;
import eu.damek.model.rest.ViewingCount;
import eu.damek.service.bill.BillingImpl;
import eu.damek.service.view.ViewImpl;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.util.List;

/**
 * Endpoint for REST
 */
@Stateless
@Path("/")
@Produces({"application/json"})
@Consumes({"application/json"})
public class RestEndpoint {

    /**
     * injected {@link StudioDAO}
     */
    @Inject
    private StudioDAO studioDAO;

    /**
     * injected {@link EpisodeDAO}
     */
    @Inject
    private EpisodeDAO episodeDAO;

    /**
     * inject local EJB bean {@link BillingImpl}
     */
    @Inject
    private BillingImpl billing;

    /**
     * inject local EJB bean {@link ViewImpl}
     */
    @Inject
    private ViewImpl view;

    /**
     * clear all counters of view and payments
     *
     * @return responce 202 (accepted)
     */
    @POST
    @Path("reset")
    @Consumes({"application/json"})
    public Response reset() {
        billing.resetCounters();
        return Response.status(Response.Status.ACCEPTED).build();
    }

    /**
     * send notice of viewing the episode by {@link eu.damek.entity.Client}
     *
     * @param viewingCount is GUID of episode and client GUID
     * @return responce 202 (accept) if is {@link eu.damek.entity.Episode} exist otherwise 404 (not found)
     */
    @POST
    @Path("viewing")
    @Consumes({"application/json"})
    public Response viewing(ViewingCount viewingCount) {
        try {
            view.countView(viewingCount.getCustomer(), viewingCount.getEpisode());
        } catch (EpisodeNotFoundException e) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.status(Response.Status.ACCEPTED).build();
    }

    /**
     * geting all payments for studios
     *
     * @return List of {@link PaymentOne} for all {@link eu.damek.entity.Studio}
     */
    @GET
    @Path("payments")
    @Produces({"application/json"})
    public List<Payment> payments() {
        return billing.calcAllPayments();
    }

    /**
     * return payment for concreate {@link eu.damek.entity.Studio} given by id
     *
     * @param id String as GUID of {@link eu.damek.entity.Studio}
     * @return object of {@link PaymentOne} for given {@link eu.damek.entity.Studio}. If not exist then return 404 (NotFound)
     */
    @GET
    @Path("payments/{id}")
    @Produces({"application/json"})
    public Response payment(@PathParam("id") final String id) {
        if (id.equalsIgnoreCase("RES_NOT_FOUND")) {
            return Response.status(Response.Status.NOT_ACCEPTABLE).build();
        }
        try {
            return Response.ok(billing.calcPaymentForStudio(id)).build();
        } catch (StudioNotFoundException e) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

    /**
     * helped method for list of all {@link Studio}
     *
     * @return List of all {@link Studio}
     */
    @GET
    @Path("/studios")
    @Produces({"application/json"})
    public List<Studio> getAllStuios() {
        return studioDAO.getAllStudios();
    }

    /**
     * helped method for list of all {@link Episode}
     *
     * @return List of {@link Episode}
     */
    @GET
    @Path("/episodes")
    @Produces({"application/json"})
    public List<Episode> getAllEpisodes() {
        return episodeDAO.getAllEpisodes();
    }

}
