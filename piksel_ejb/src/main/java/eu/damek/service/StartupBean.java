package eu.damek.service;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.inject.Inject;
import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Project: piksel
 * For:
 * Created by damekjan on 20/07/2017.
 */
@Startup
@Singleton
public class StartupBean {

    /**
     * injected {@link EpisodeService} for handle {@link eu.damek.entity.Episode}
     */
    @Inject
    private EpisodeService episodeService;
    /**
     * inject {@link StudioService} for handle {@link eu.damek.entity.Studio}
     */
    @Inject
    private StudioService studioService;
    /**
     * inject {@link Logger}
     */
    @Inject
    private Logger logger;

    /**
     * Initialization on startup of the application.
     * Load json files from resources to Entity. It's for simulated  remote load data
     */
    @PostConstruct
    private void init() {
        importStudios();

        importEpisodes();
    }

    private void importStudios() {
        InputStream studioAsStream = this.getClass()
                .getClassLoader()
                .getResourceAsStream("studios.json");
        try (final Reader reader = new InputStreamReader(studioAsStream)) {
            try (final JsonReader jsonReader = Json.createReader(reader)) {
                final JsonArray studios = jsonReader.readObject().getJsonArray("studios");
                if (!studios.isEmpty()) {
                    for (JsonObject value : studios.getValuesAs(JsonObject.class)) {
                        studioService.addNewOrUpdate(value.getJsonString("id").getString(),
                                value.getJsonString("name").getString(),
                                value.getJsonNumber("payment").doubleValue());
                    }
                }
            }
        } catch (IOException e) {
            logger.log(Level.WARNING, "Error in import studios.json to Entity. E:{0}", e.getMessage());
        }
    }

    private void importEpisodes() {
        InputStream episodesAsStream = this.getClass()
                .getClassLoader()
                .getResourceAsStream("episodes.json");
        try (final Reader reader = new InputStreamReader(episodesAsStream)) {
            try (final JsonReader jsonReader = Json.createReader(reader)) {
                final JsonArray episodes = jsonReader.readObject().getJsonArray("episodes");
                if (!episodes.isEmpty()) {
                    for (JsonObject value : episodes.getValuesAs(JsonObject.class)) {
                        episodeService.addNewOrUpdate(value.getJsonString("id").getString(),
                                value.getJsonString("name").getString(),
                                value.getJsonString("rightsowner").getString());
                    }
                }
            }
        } catch (IOException e) {
            logger.log(Level.WARNING, "Error in import episodes.json to Entity. E:{0}", e.getMessage());
        }
    }

}
