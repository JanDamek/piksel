package eu.damek.service;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;

/**
 * Project: piksel
 * For:
 * Created by damekjan on 20/07/2017.
 */
@Startup
@Singleton
public class StartupBean {

    /**
     * Initialization on startup of the application.
     * Load json files from resources to Entity. It's for simulated  remote load data
     */
    @PostConstruct
    private void init(){
        //TODO read JSON files and store all data in Entity
    }

}
