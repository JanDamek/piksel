package eu.damek.model.rest;

/**
 * Project: piksel
 * For:
 * Created by damekjan on 23/07/2017.
 */
public class ViewingCount {

    /**
     * {@link eu.damek.entity.Episode} GUID
     */
    private String episode;

    /**
     * customer as {@link eu.damek.entity.Client} GUID
     */
    private String customer;

    /**
     * constructor for set field of episode and customer GUID
     *
     * @param episode  String GUID of episode
     * @param customer String GUID of customer
     */
    public ViewingCount(String episode, String customer) {
        this.episode = episode;
        this.customer = customer;
    }

    /**
     * getter for {@link eu.damek.entity.Episode} GUID
     *
     * @return String of GUID for {@link eu.damek.entity.Episode}
     */
    public String getEpisode() {
        return episode;
    }

    /**
     * setter for {@link eu.damek.entity.Episode} GUID
     *
     * @param episode String GUID
     */
    public void setEpisode(String episode) {
        this.episode = episode;
    }

    /**
     * getter for customer GUID from {@link eu.damek.entity.Client}
     *
     * @return String with GUID
     */
    public String getCustomer() {
        return customer;
    }

    /**
     * setter of customer GUID on {@link eu.damek.entity.Client}
     *
     * @param customer String GUID
     */
    public void setCustomer(String customer) {
        this.customer = customer;
    }
}
