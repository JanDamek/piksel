package eu.damek.service;

import eu.damek.dao.StudioDAO;
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
public class StudioService {

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
     * create new Entity for {@link eu.damek.entity.Studio} by given id, name and payment
     *
     * @param id      String of GUID
     * @param name    String of name
     * @param payment Float of price by view
     */
    public void addNewOrUpdate(String id, String name, double payment) {
        Studio studio = studioDAO.getStudioById(id);
        if (studio!=null) {
            studio.setName(name);
            studio.setPayment((float) payment);
            studioDAO.merge(studio);
            logger.log(Level.INFO, "Update entity Studio:{0}", studio);
        } else {
            Studio newStudio = new Studio();
            newStudio.setId(id);
            newStudio.setName(name);
            newStudio.setPayment((float) payment);
            studioDAO.persist(newStudio);
            logger.log(Level.INFO, "Create new entity Studio:{0}", newStudio);
        }
    }
}
