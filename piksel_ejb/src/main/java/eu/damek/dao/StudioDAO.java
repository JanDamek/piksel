package eu.damek.dao;

import eu.damek.entity.Studio;

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
public class StudioDAO extends MainDAO<Studio> {

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
     * return List of all {@link Studio}
     *
     * @return List of all {@link Studio}
     */
    public List<Studio> getAllStudios() {
        return em.createNamedQuery("Studio.findAll", Studio.class).getResultList();
    }

    /**
     * return one {@link Studio} for given GUID
     *
     * @param id String as GUID of {@link Studio} id
     * @return object of {@link Studio} for given id
     */
    public Studio getStudioById(final String id) {
        return em.find(Studio.class, id);
    }

    /**
     * set counter of view to zero
     */
    public void setAllViewingsToZero() {
        em.createNamedQuery("Studio.setAllViewingsToZero").executeUpdate();
    }
}
