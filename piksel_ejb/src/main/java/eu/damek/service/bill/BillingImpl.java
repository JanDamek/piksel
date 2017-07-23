package eu.damek.service.bill;

import eu.damek.dao.ClientDAO;
import eu.damek.dao.EpisodeDAO;
import eu.damek.dao.StudioDAO;
import eu.damek.entity.Studio;
import eu.damek.exception.StudioNotFoundException;
import eu.damek.model.Payment;
import eu.damek.model.PaymentOne;

import javax.ejb.LocalBean;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

/**
 * Project: piksel
 * For:
 * Created by damekjan on 20/07/2017.
 */
@LocalBean
@Remote(Billing.class)
@Stateless
public class BillingImpl implements Billing {

    /**
     * injected class {@link StudioDAO}
     */
    @Inject
    private StudioDAO studioDAO;
    /**
     * injected class {@link ClientDAO}
     */
    @Inject
    private ClientDAO clientDAO;
    /**
     * inject class {@link EpisodeDAO}
     */
    @Inject
    private EpisodeDAO episodeDAO;

    /**
     * {@inheritDoc}
     */
    @Override
    public void resetCounters() {
        clientDAO.setAllViewingsToZero();
        episodeDAO.setAllViewingsToZero();
        studioDAO.setAllViewingsToZero();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public PaymentOne calcPaymentForStudio(String studioId) throws StudioNotFoundException {
        final Studio studio = studioDAO.getStudioById(studioId);
        if (studio == null) {
            throw new StudioNotFoundException();
        }
        final PaymentOne payment = new PaymentOne();
        payment.setRightsowner(studio.getName());
        payment.setRoyalty(calcRoyalty(studio));
        payment.setViewings(studio.getViewings());
        return payment;
    }

    /**
     * method for calc the royalty by given studio, where is payment anf viewings count
     *
     * @param studio class of {@link Studio}
     * @return calculate result
     */
    private float calcRoyalty(Studio studio) {
        return studio.getPayment() * studio.getViewings();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Payment> calcAllPayments() {
        final ArrayList<Payment> list = new ArrayList<>();
        for (Studio studio : studioDAO.getAllStudios()) {
            final Payment payment = new Payment();
            payment.setRightsownerId(studio.getId());
            payment.setRightsowner(studio.getName());
            payment.setRoyalty(calcRoyalty(studio));
            payment.setViewings(studio.getViewings());

            list.add(payment);
        }
        return list;
    }

}
