package eu.damek.model;

import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * Project: piksel
 * For:
 * Created by damekjan on 20/07/2017.
 */
public class Payment {

    private String ightsownerId;
    private String rightsowner;
    private Float royalty;
    private Integer viewings;

    @Override
    public int hashCode() {
        int result = getIghtsownerId() != null ? getIghtsownerId().hashCode() : 0;
        result = 31 * result + (getRightsowner() != null ? getRightsowner().hashCode() : 0);
        result = 31 * result + (getRoyalty() != null ? getRoyalty().hashCode() : 0);
        result = 31 * result + (getViewings() != null ? getViewings().hashCode() : 0);
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

        Payment payment = (Payment) o;

        if (getIghtsownerId() != null ? !getIghtsownerId().equals(payment.getIghtsownerId()) :
                payment.getIghtsownerId() != null) {
            return false;
        }
        if (getRightsowner() != null ? !getRightsowner().equals(payment.getRightsowner()) :
                payment.getRightsowner() != null) {
            return false;
        }
        if (getRoyalty() != null ? !getRoyalty().equals(payment.getRoyalty()) : payment.getRoyalty() != null) {
            return false;
        }
        return getViewings() != null ? getViewings().equals(payment.getViewings()) : payment.getViewings() == null;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("ightsownerId", ightsownerId)
                .append("rightsowner", rightsowner)
                .append("royalty", royalty)
                .append("viewings", viewings)
                .toString();
    }

    public String getIghtsownerId() {
        return ightsownerId;
    }

    public void setIghtsownerId(String ightsownerId) {
        this.ightsownerId = ightsownerId;
    }

    public String getRightsowner() {
        return rightsowner;
    }

    public void setRightsowner(String rightsowner) {
        this.rightsowner = rightsowner;
    }

    public Float getRoyalty() {
        return royalty;
    }

    public void setRoyalty(Float royalty) {
        this.royalty = royalty;
    }

    public Integer getViewings() {
        return viewings;
    }

    public void setViewings(Integer viewings) {
        this.viewings = viewings;
    }
}
