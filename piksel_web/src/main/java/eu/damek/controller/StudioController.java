package eu.damek.controller;

import eu.damek.dao.StudioDAO;
import eu.damek.entity.Studio;

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
public class StudioController implements Serializable {

    /**
     * {@inheritDoc}
     */
    private static final long serialVersionUID = 5173453085021853625L;
    /**
     * injected object of {@link StudioDAO}
     */
    @Inject
    private StudioDAO studioDAO;

    /**
     * return list of all {@link Studio}
     *
     * @return List of {@link Studio}
     */
    public List<Studio> getAllStudios() {
        return studioDAO.getAllStudios();
    }

}
