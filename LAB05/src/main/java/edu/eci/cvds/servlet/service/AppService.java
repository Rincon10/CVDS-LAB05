package edu.eci.cvds.servlet.service;

import org.springframework.stereotype.Service;
import edu.eci.cvds.servlet.domain.App;

/**
 * .
 *
 * @author Leonardo y Camilo
 */
@Service
public class AppService {
    public App getApp(String appName) {
        App app = new App();
        app.setAppName("App");

        return app;
    }
}