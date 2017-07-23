package eu.damek.entity;

import javax.persistence.*;
import java.util.List;

/**
 * Project: piksel
 * For:
 * Created by damekjan on 20/07/2017.
 */

@NamedQueries({
        @NamedQuery(
                name = "Studio.findAll",
                query = "SELECT s FROM Studio s"),
        @NamedQuery(
                name = "Studio.setAllViewingsToZero",
                query = "UPDATE Studio s SET s.viewings=0"
        )
}
)

@Entity
public class Studio {

    /**
     * GUID of studio
     */
    @Id
    private String id;

    /**
     * name of studio
     */
    private String name;

    /**
     * payment for view
     */
    private Float payment;
    /**
     * viewings value
     */
    private Integer viewings;

    /**
     * episodes from rights owner
     */
    @OneToMany(mappedBy = "rightsowner")
    private List<Episode> episodes;

    /**
     * getter for name of studio
     *
     * @return String as name of studio
     */
    public String getName() {
        return name;
    }

    /**
     * setter for name of studio
     *
     * @param name String for name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * getter for payment by view price
     *
     * @return Float as price of payment
     */
    public Float getPayment() {
        return payment;
    }

    /**
     * setter for payment
     *
     * @param payment Float value of payment
     */
    public void setPayment(Float payment) {
        this.payment = payment;
    }

    @Override
    public int hashCode() {
        return getId() != null ? getId().hashCode() : 0;
    }

    /**
     * getter for studio GUID
     *
     * @return String as GUID of studio
     */
    public String getId() {
        return id;
    }

    /**
     * sette for Studio GUID
     *
     * @param id String of GUID
     */
    public void setId(String id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Studio)) {
            return false;
        }

        Studio studio = (Studio) o;

        return getId() != null ? getId().equals(studio.getId()) : studio.getId() == null;
    }

    @Override
    public String toString() {
        return new org.apache.commons.lang3.builder.ToStringBuilder(this)
                .append("id", id)
                .append("name", name)
                .append("payment", payment)
                .toString();
    }

    /**
     * getter fol total of views
     *
     * @return Integer for total count of view
     */
    public Integer getViewings() {
        if (viewings == null) {
            viewings = 0;
        }
        return viewings;
    }

    /**
     * setter for set the total count of view
     *
     * @param viewings Integer value of total count
     */
    public void setViewings(Integer viewings) {
        this.viewings = viewings;
    }

    /**
     * getter for list of {@link Episode}
     *
     * @return List of {@link Episode}
     */
    public List<Episode> getEpisodes() {
        return episodes;
    }

    /**
     * setter for list of {@link Episode}
     *
     * @param episodes for store
     */
    public void setEpisodes(List<Episode> episodes) {
        this.episodes = episodes;
    }
}
