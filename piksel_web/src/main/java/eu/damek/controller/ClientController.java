package eu.damek.controller;

import eu.damek.dao.ClientDAO;
import eu.damek.dao.EpisodeDAO;
import eu.damek.entity.Client;
import eu.damek.entity.Episode;
import eu.damek.exception.EpisodeNotFoundException;
import eu.damek.service.view.ViewImpl;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import java.io.Serializable;
import java.util.List;

/**
 * Project: piksel
 * For:
 * Created by damekjan on 23/07/2017.
 */
@ManagedBean
@ViewScoped
public class ClientController implements Serializable {

    /**
     * {@inheritDoc}
     */
    private static final long serialVersionUID = -2306894380149086555L;
    /**
     * injected object {@link ClientDAO}
     */
    @Inject
    /**
     * injected {@link ClientDAO}
     */
    private ClientDAO clientDAO;
    /**
     * injected {@link EpisodeDAO}
     */
    @Inject
    private EpisodeDAO episodeDAO;
    /**
     * injected {@link ViewImpl}
     */
    @Inject
    private ViewImpl view;
    /**
     * store client GUID from UI
     */
    private String clientId;
    /**
     * store episod GUID ffrom UI
     */
    private String episodeId;

    /**
     * return list of all {@link Client}
     *
     * @return List of {@link Client}
     */
    public List<Client> getAllClients() {
        return clientDAO.getAllClients();
    }

    /**
     * return list of all {@link Episode}
     *
     * @return list of {@link Episode}
     */
    public List<Episode> getAllEpisodes() {
        return episodeDAO.getAllEpisodes();
    }

    /**
     * getter for client GUID from UI
     *
     * @return String client GUID
     */
    public String getClientId() {
        return clientId;
    }

    /**
     * setter client GUID from UI
     *
     * @param clientId String GUID
     */
    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    /**
     * getter {@link Episode GUID for UI}
     *
     * @return String GUID
     */
    public String getEpisodeId() {
        return episodeId;
    }

    /**
     * setter of {@link Episode} GUID for UI
     *
     * @param episodeId Strign GUID
     */
    public void setEpisodeId(String episodeId) {
        this.episodeId = episodeId;
    }

    /**
     * send requeat for viewing count of client and episode
     *
     * @throws EpisodeNotFoundException if episode not found
     */
    public void send() throws EpisodeNotFoundException {
        view.countView(clientId, episodeId);
        clientId = "";
        episodeId = "";
    }

    /**
     * method for autocomplete field on UI. Return list of GUID of {@link Client} containing query string
     *
     * @param query String for find
     * @return List of String
     */
    public List<String> completeText(String query) {
        return clientDAO.findByQueryFromId(query);
    }
}
