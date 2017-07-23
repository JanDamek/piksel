package eu.damek.service.bill;

import eu.damek.exception.StudioNotFoundException;
import eu.damek.model.Payment;
import eu.damek.model.PaymentOne;

import java.util.List;

/**
 * Project: piksel
 * For:
 * Created by damekjan on 20/07/2017.
 */
public interface Billing {

    /**
     * Reset all counter of viewed
     */
    void resetCounters();

    /**
     * Get payment detail for given studio id
     *
     * @param studioId GUID of studio
     * @return retun object of {@link PaymentOne}
     * @throws StudioNotFoundException are throws when the studio with id not exist
     */
    PaymentOne calcPaymentForStudio(final String studioId) throws StudioNotFoundException;

    /**
     * Get all payments details
     *
     * @return return list of {@link PaymentOne}
     */
    List<Payment> calcAllPayments();

}
