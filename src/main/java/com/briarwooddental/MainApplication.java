package com.briarwooddental;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.awt.*;

@SpringBootApplication
public class MainApplication implements CommandLineRunner {
    public MainApplication() {
    }

    public static void main(String[] args) throws InterruptedException, AWTException {
        SpringApplication.run(MainApplication.class, args);
        String patientEmail = args[0];
        AutoSurf autoSurf = new AutoSurf();
        autoSurf.surf(patientEmail);
    }

    public void run(String... args) throws Exception {
    }
}
