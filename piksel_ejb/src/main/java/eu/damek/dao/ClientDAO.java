package eu.damek.dao;

import eu.damek.entity.Client;

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
public class ClientDAO extends MainDAO<Client> {

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
     * return list of all {@link Client}
     *
     * @return List of all {@link Client}
     */
    public List<Client> getAllClients() {
        return em.createNamedQuery("Client.findAll", Client.class)
                .getResultList();
    }

    /**
     * return {@link Client} by given id
     *
     * @param id is GUID of Client
     * @return {@link Client} for given Client
     */
    public Client getClientById(final String id) {
        return em.find(Client.class, id);
    }

    /**
     * method set on all clients view to zero
     */
    public void setAllViewingsToZero() {
        em.createNamedQuery("Client.setViewingsToZero").executeUpdate();
    }

    /**
     * find all Client containing query in id
     *
     * @param query String for find
     * @return List of String fo GUID of {@link Client}
     */
    public List<String> findByQueryFromId(String query) {
        return em.createNamedQuery("Client.findByQueryOnId", String.class)
                .setParameter("id", "%" + query + "%")
                .getResultList();
    }
}
