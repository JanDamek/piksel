package eu.damek.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

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
                name = "Studio.findById",
                query = "SELECT s FROM Studio s WHERE s.id = :id"
        )
}
)

@Entity
public class Studio {

    @Id
    private String id;

    private String name;

    private Float payment;

    public String getName() {
        return name;
    }

    public Float getPayment() {
        return payment;
    }

    @Override
    public int hashCode() {
        return getId() != null ? getId().hashCode() : 0;
    }

    public String getId() {
        return id;
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

}
