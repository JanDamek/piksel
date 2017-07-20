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
                name = "Client.findAll",
                query = "SELECT c FROM Client c"
        ),
        @NamedQuery(
                name = "Client.findById",
                query = "SELECT c FROM Client c WHERE c.id = :id"
        )
})
@Entity
public class Client {

    @Id
    private String id;

    private Integer count;
}
