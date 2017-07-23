package eu.damek.rest;

import eu.damek.dao.EpisodeDAO;
import eu.damek.dao.StudioDAO;
import eu.damek.exception.EpisodeNotFoundException;
import eu.damek.exception.StudioNotFoundException;
import eu.damek.model.rest.ViewingCount;
import eu.damek.service.bill.BillingImpl;
import eu.damek.service.view.ViewImpl;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;

import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.doThrow;

/**
 * Project: piksel
 * For:
 * Created by damekjan on 22/07/2017.
 */
@RunWith(MockitoJUnitRunner.class)
public class RestEndpointTest {

    private InMemoryRestServer server;

    @InjectMocks
    private RestEndpoint restEndpoint;

    @Mock
    private BillingImpl billing;
    @Mock
    private ViewImpl view;
    @Mock
    private StudioDAO studioDAO;
    @Mock
    private EpisodeDAO episodeDAO;

    @Before
    public void beforeClass() throws Exception {
        MockitoAnnotations.initMocks(this);
        server = InMemoryRestServer.create(restEndpoint);
    }

    @Test
    public void reset() throws Exception {
        Response response = server.newRequest("/reset").request(
                MediaType.APPLICATION_JSON_TYPE).buildPost(Entity.json("")).invoke();
        assertEquals(Response.Status.ACCEPTED.getStatusCode(), response.getStatus());
    }

    @Test
    public void viewing() throws Exception {
        ViewingCount valid = new ViewingCount("6a1db5d6610a4c048d3df9a6268c68dc", "test");
        Response response = server.newRequest("/reset")
                .request(MediaType.APPLICATION_JSON_TYPE)
                .buildPost(Entity.json(valid))
                .invoke();
        assertEquals(Response.Status.ACCEPTED.getStatusCode(), response.getStatus());
    }

    @Test
    public void viewingNotFount() throws Exception {
        doThrow(new EpisodeNotFoundException()).when(view).countView("test", "notexist");

        ViewingCount notValid = new ViewingCount("notexist", "test");
        Response response = server.newRequest("/reset")
                .request(MediaType.APPLICATION_JSON_TYPE)
                .buildPost(Entity.json(notValid))
                .invoke();
        assertEquals(Response.Status.ACCEPTED.getStatusCode(), response.getStatus());
    }

    @Test
    public void payments() throws Exception {
        Response response = server.newRequest("/payments")
                .request(MediaType.APPLICATION_JSON_TYPE)
                .buildGet()
                .invoke();
        assertEquals(Response.Status.OK.getStatusCode(), response.getStatus());
    }

    @Test
    public void paymentNotFound() throws Exception {
        doThrow(new StudioNotFoundException()).when(billing).calcPaymentForStudio("75aee18236484501b209aa36f95c7e0f");

        Response response = server.newRequest("/payments/75aee18236484501b209aa36f95c7e0f")
                .request(MediaType.APPLICATION_JSON_TYPE)
                .buildGet()
                .invoke();
        assertEquals(Response.Status.NOT_FOUND.getStatusCode(), response.getStatus());
    }

    @Test
    public void payment() throws Exception {
        Response response = server.newRequest("/payments/75aee18236484501b209aa36f95c7e0f")
                .request(MediaType.APPLICATION_JSON_TYPE)
                .buildGet()
                .invoke();
        assertEquals(Response.Status.OK.getStatusCode(), response.getStatus());
    }

    @Test
    public void getAllStuios() throws Exception {
        Response response = server.newRequest("/studios")
                .request(MediaType.APPLICATION_JSON_TYPE)
                .buildGet()
                .invoke();
        assertEquals(Response.Status.OK.getStatusCode(), response.getStatus());
    }

    @org.junit.Test
    public void getAllEpisodes() throws Exception {
        Response response = server.newRequest("/episodes")
                .request(MediaType.APPLICATION_JSON_TYPE)
                .buildGet()
                .invoke();
        assertEquals(Response.Status.OK.getStatusCode(), response.getStatus());
    }

}