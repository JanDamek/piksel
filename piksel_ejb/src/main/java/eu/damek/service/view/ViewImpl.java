package eu.damek.service.view;

import eu.damek.dao.ClientDAO;
import eu.damek.dao.EpisodeDAO;
import eu.damek.dao.StudioDAO;
import eu.damek.entity.Client;
import eu.damek.entity.Episode;
import eu.damek.entity.Studio;
import eu.damek.exception.EpisodeNotFoundException;

import javax.ejb.LocalBean;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 * Project: piksel
 * For:
 * Created by damekjan on 20/07/2017.
 */
@LocalBean
@Remote(View.class)
@Stateless
public class ViewImpl implements View {

    /**
     * injected class of {@link ClientDAO}
     */
    @Inject
    private ClientDAO clientDAO;
    /**
     * injected class of {@link EpisodeDAO}
     */
    @Inject
    private EpisodeDAO episodeDAO;
    /**
     * injected class of {@link StudioDAO}
     */
    @Inject
    private StudioDAO studioDAO;

    /**
     * {@inheritDoc}
     */
    @Override
    public void countView(String clientId, String episodeId) throws EpisodeNotFoundException {
        Episode episode = episodeDAO.getEpisodeById(episodeId);
        Client client = clientDAO.getClientById(clientId);
        if (client == null) {
            client = new Client();
            client.setId(clientId);
            client.setCount(1);
            clientDAO.persist(client);
        } else {
            client.setCount(client.getCount() + 1);
            clientDAO.merge(client);
        }
        final Studio studio = episode.getRightsowner();

        episode.setViewings(episode.getViewings() + 1);
        studio.setViewings(studio.getViewings() + 1);

        episodeDAO.merge(episode);
        studioDAO.merge(studio);
    }
}
