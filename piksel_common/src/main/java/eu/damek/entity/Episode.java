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
                name = "Episode.setAllViewingsToZero",
                query = "UPDATE Episode e SET e.viewings=0"
        )
})
@Entity
public class Episode {

    /**
     * GUID of the episode
     */
    @Id
    private String id;

    /**
     * name of episode
     */
    private String name;

    /**
     * relationship for {@link Studio} rights owner
     */
    @ManyToOne
    private Studio rightsowner;

    /**
     * count of all view of episode
     */
    private Integer viewings;

    /**
     * getter of name
     *
     * @return name of the episode
     */
    public String getName() {
        return name;
    }

    /**
     * setter of name
     *
     * @param name of the episode
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * getter of rights owner for episode
     *
     * @return Studio as {@link Studio} of rights owner
     */
    public Studio getRightsowner() {
        return rightsowner;
    }

    /**
     * setter for rights owner
     *
     * @param rightsowner {@link Studio} as rights owner
     */
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

    /**
     * getter for GUID of episode
     *
     * @return String as GUID of episode
     */
    public String getId() {
        return id;
    }

    /**
     * setter GUID of episode
     *
     * @param id as {@link String} of episode
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * getter for count of all views
     *
     * @return Integer of all count
     */
    public Integer getViewings() {
        if (viewings == null) {
            viewings = 0;
        }
        return viewings;
    }

    /**
     * setter for count of all views
     *
     * @param viewed Integer of total count of views
     */
    public void setViewings(Integer viewed) {
        this.viewings = viewed;
    }
}
