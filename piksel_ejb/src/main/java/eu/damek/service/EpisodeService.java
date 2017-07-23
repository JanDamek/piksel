package eu.damek.service;

import eu.damek.dao.EpisodeDAO;
import eu.damek.dao.StudioDAO;
import eu.damek.entity.Episode;
import eu.damek.entity.Studio;

import javax.ejb.LocalBean;
import javax.inject.Inject;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Project: piksel
 * For:
 * Created by damekjan on 21/07/2017.
 */
@LocalBean
public class EpisodeService {

    /**
     * injected {@link EpisodeDAO}
     */
    @Inject
    private EpisodeDAO episodeDAO;
    /**
     * injected {@link StudioDAO}
     */
    @Inject
    private StudioDAO studioDAO;
    /**
     * injected {@link java.util.logging.Logger}
     */
    @Inject
    private Logger logger;

    /**
     * create new Entity for {@link eu.damek.entity.Episode} by given id, name and rights owner. Rights owner are
     * {@link eu.damek.entity.Studio} id
     *
     * @param id          String GUID
     * @param name        String name
     * @param rightsowner String rights owner {@link eu.damek.entity.Studio} id
     */
    public void addNewOrUpdate(String id, String name, String rightsowner) {
        final Episode episode = episodeDAO.getEpisodeById(id);
        final Studio studio = studioDAO.getStudioById(rightsowner);
        if (episode != null) {
            episode.setName(name);
            episode.setRightsowner(studio);
            episodeDAO.merge(episode);
            logger.log(Level.INFO, "Update entity Episode:{0}", episode);
        } else {
            final Episode newEpisode = new Episode();
            newEpisode.setId(id);
            newEpisode.setName(name);
            newEpisode.setRightsowner(studio);
            episodeDAO.persist(newEpisode);
            logger.log(Level.INFO, "Create new entity Episode:{0}", newEpisode);
        }
    }
}
