package eu.damek.dao;

import eu.damek.entity.Episode;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.logging.Logger;

/**
 * Project: piksel
 * For:
 * Created by damekjan on 20/07/2017.
 */
public class EpisodeDAO {

    @Inject
    private EntityManager em;
    @Inject
    private Logger logger;

    public List<Episode> getAllEpisodes() {
        return em.createNamedQuery("Episode.findAll", Episode.class).getResultList();
    }

    public Episode getEpisodeById(final String id) {
        final TypedQuery<Episode> query = em.createNamedQuery("Episode.findById", Episode.class);
        query.setParameter("id", id);
        return query.getSingleResult();
    }

}
