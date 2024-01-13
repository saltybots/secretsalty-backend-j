package com.secretsalty.secretsalty.security.config;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.auth.FirebaseAuth;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;
import java.io.InputStream;

@Configuration
public class FireBaseConfig {

    @Bean
    public FirebaseApp setupFireBaseApp() throws IOException {
        InputStream is = FireBaseConfig.class.getResourceAsStream("/firebase_config.json");

        FirebaseOptions options = FirebaseOptions.builder()
                .setCredentials(GoogleCredentials.fromStream(is))
                .build();

        return FirebaseApp.initializeApp(options);
    }

    @Bean
    public FirebaseAuth getFirebaseAuth(FirebaseApp app) {
        return FirebaseAuth.getInstance(app);
    }

}
