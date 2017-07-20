package eu.damek.entity;

import org.apache.commons.lang3.builder.ToStringBuilder;

import javax.persistence.*;

/**
 * Project: piksel
 * For:
 * Created by damekjan on 20/07/2017.
 */
@NamedQueries({
        @NamedQuery(
                name = "Episode.findAll",
                query = "SELECT e FROM Episode e"),
        @NamedQuery(
                name = "Episode.findById",
                query = "SELECT e FROM Episode e WHERE e.id = :id"
        )
})
@Entity
public class Episode {

    @Id
    private String id;

    private String name;

    @ManyToOne
    private Studio rightsowner;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Studio getRightsowner() {
        return rightsowner;
    }

    public void setRightsowner(Studio rightsowner) {
        this.rightsowner = rightsowner;
    }

    @Override
    public int hashCode() {
        return getId() != null ? getId().hashCode() : 0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Episode)) {
            return false;
        }

        Episode episode = (Episode) o;

        return getId() != null ? getId().equals(episode.getId()) : episode.getId() == null;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("id", id)
                .append("name", name)
                .append("rightsowner", rightsowner)
                .toString();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
