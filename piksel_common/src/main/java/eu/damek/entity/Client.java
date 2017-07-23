package eu.damek.entity;

import org.apache.commons.lang3.builder.ToStringBuilder;

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
                name = "Client.findAll",
                query = "SELECT c FROM Client c"
        ),
        @NamedQuery(
                name = "Client.setViewingsToZero",
                query = "UPDATE Client c SET c.count=0"
        ),
        @NamedQuery(
                name = "Client.findByQueryOnId",
                query = "SELECT c.id FROM Client c WHERE c.id LIKE :id"
        )
})
@Entity
public class Client {

    /**
     * client GUID
     */
    @Id
    private String id;

    /**
     * count of view
     */
    private Integer count;

    @Override
    public int hashCode() {
        int result = getId() != null ? getId().hashCode() : 0;
        result = 31 * result + (getCount() != null ? getCount().hashCode() : 0);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Client)) {
            return false;
        }

        Client client = (Client) o;

        if (getId() != null ? !getId().equals(client.getId()) : client.getId() != null) {
            return false;
        }
        return getCount() != null ? getCount().equals(client.getCount()) : client.getCount() == null;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("id", id)
                .append("count", count)
                .toString();
    }

    /**
     * getter for client GUID
     *
     * @return String as GUID of client
     */
    public String getId() {
        return id;
    }

    /**
     * setter for client GUID
     *
     * @param id String as GUID of client
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * getter for count of view
     *
     * @return Integer with count of view
     */
    public Integer getCount() {
        return count;
    }

    /**
     * setter for count of view
     *
     * @param count Integer for set count of view
     */
    public void setCount(Integer count) {
        this.count = count;
    }
}

