package eu.damek.service.view;

import eu.damek.exception.EpisodeNotFoundException;

/**
 * Project: piksel
 * For:
 * Created by damekjan on 20/07/2017.
 */
public interface View {

    /**
     * Is assecible only by local injection and make count of view for given {@link eu.damek.entity.Client} id and
     * {@link eu.damek.entity.Episode} id. If {@link eu.damek.entity.Episode} not exist throws
     * {@link EpisodeNotFoundException}.
     *
     * @param clientId  String of {@link eu.damek.entity.Client} GUID as id
     * @param episodeId String of {@link eu.damek.entity.Episode} GUID as id
     * @throws EpisodeNotFoundException is throw if {@link eu.damek.entity.Episode} not exist
     */
    void countView(final String clientId, final String episodeId) throws EpisodeNotFoundException;

}
