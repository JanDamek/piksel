package eu.damek.dao;

import eu.damek.entity.Episode;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;
import java.util.logging.Logger;

/**
 * Project: piksel
 * For:
 * Created by damekjan on 20/07/2017.
 */
@Stateless
public class EpisodeDAO extends MainDAO<Episode> {

    /**
     * injected {@link EntityManager} for "piksel" data source
     */
    @Inject
    private EntityManager em;
    /**
     * injected {@link Logger} for current class
     */
    @Inject
    private Logger logger;

    /**
     * return all {@link Episode}
     *
     * @return List of {@link Episode}
     */
    public List<Episode> getAllEpisodes() {
        return em.createNamedQuery("Episode.findAll", Episode.class).getResultList();
    }

    /**
     * return current {@link Episode} for given id
     *
     * @param id String as GUID of episode
     * @return object os {@link Episode} for id
     */
    public Episode getEpisodeById(final String id) {
        return em.find(Episode.class, id);
    }

    /**
     * clear all counts for all episodes
     */
    public void setAllViewingsToZero() {
        em.createNamedQuery("Episode.setAllViewingsToZero").executeUpdate();
    }
}
