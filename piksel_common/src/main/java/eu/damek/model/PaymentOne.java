package eu.damek.model;

import org.apache.commons.lang3.builder.ToStringBuilder;

import java.io.Serializable;

/**
 * Project: piksel
 * For:
 * Created by damekjan on 20/07/2017.
 */
public class PaymentOne implements Serializable {

    /**
     * {@inheritDoc}
     */
    private static final long serialVersionUID = 8149226064344605728L;
    /**
     * name of rights owner
     */
    private String rightsowner;
    /**
     * all payment for rights owner
     */
    private Float royalty;
    /**
     * count of view
     */
    private Integer viewings;

    @Override
    public int hashCode() {
        int result = getRightsowner() != null ? getRightsowner().hashCode() : 0;
        result = 31 * result + (getRoyalty() != null ? getRoyalty().hashCode() : 0);
        result = 31 * result + (getViewings() != null ? getViewings().hashCode() : 0);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof PaymentOne)) {
            return false;
        }

        PaymentOne that = (PaymentOne) o;

        if (getRightsowner() != null ? !getRightsowner().equals(that.getRightsowner()) :
                that.getRightsowner() != null) {
            return false;
        }
        if (getRoyalty() != null ? !getRoyalty().equals(that.getRoyalty()) : that.getRoyalty() != null) {
            return false;
        }
        return getViewings() != null ? getViewings().equals(that.getViewings()) : that.getViewings() == null;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("rightsowner", rightsowner)
                .append("royalty", royalty)
                .append("viewings", viewings)
                .toString();
    }

    /**
     * getter of rights owner name
     *
     * @return String as name of rights owner
     */
    public String getRightsowner() {
        return rightsowner;
    }

    /**
     * setter of rights owner name
     *
     * @param rightsowner is String name of rights owner
     */
    public void setRightsowner(String rightsowner) {
        this.rightsowner = rightsowner;
    }

    /**
     * getter of total payment for rights owner
     *
     * @return Float as total of payment for rights owner
     */
    public Float getRoyalty() {
        return royalty;
    }

    /**
     * setter of total payment of rights owner
     *
     * @param royalty is total of payments for rights owner
     */
    public void setRoyalty(Float royalty) {
        this.royalty = royalty;
    }

    /**
     * getter for total count of views
     *
     * @return Integer of total count of view
     */
    public Integer getViewings() {
        return viewings;
    }

    /**
     * setter of total count of view
     *
     * @param viewings is Integer with total count of views
     */
    public void setViewings(Integer viewings) {
        this.viewings = viewings;
    }
}
