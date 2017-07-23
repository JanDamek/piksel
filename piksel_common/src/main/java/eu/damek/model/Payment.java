package eu.damek.model;

import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * Project: piksel
 * For:
 * Created by damekjan on 21/07/2017.
 */
public class Payment extends PaymentOne {

    /**
     * rights owner id if GUID of Studio
     */
    private String rightsownerId;

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (getRightsownerId() != null ? getRightsownerId().hashCode() : 0);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Payment)) {
            return false;
        }
        if (!super.equals(o)) {
            return false;
        }

        Payment payment = (Payment) o;

        return getRightsownerId() != null ? getRightsownerId().equals(payment.getRightsownerId()) :
                payment.getRightsownerId() == null;
    }

    /**
     * getter for rights owner id, it's {@link eu.damek.entity.Studio} id
     *
     * @return String as GUID of rights owner
     */
    public String getRightsownerId() {
        return rightsownerId;
    }

    /**
     * setter for rights owner id
     *
     * @param rightsownerId is String of {@link eu.damek.entity.Studio} id
     */
    public void setRightsownerId(String rightsownerId) {
        this.rightsownerId = rightsownerId;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("rightsownerId", rightsownerId)
                .toString();
    }
}
