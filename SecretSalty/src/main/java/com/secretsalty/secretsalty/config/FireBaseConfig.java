package com.secretsalty.secretsalty.config;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.auth.FirebaseAuth;
import java.io.IOException;
import java.io.InputStream;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FireBaseConfig {

  @Bean
  public FirebaseApp setupFireBaseApp() throws IOException {
    InputStream config = FireBaseConfig.class.getResourceAsStream("/firebase_config.json");

    if (config == null) {
      throw new RuntimeException(
          "Couldn't find firebase config file. Did you forget to add a firebase_config.json?");
    }

    FirebaseOptions options =
        FirebaseOptions.builder().setCredentials(GoogleCredentials.fromStream(config)).build();

    return FirebaseApp.initializeApp(options);
  }

  @Bean
  public FirebaseAuth firebaseAuth(FirebaseApp app) {
    return FirebaseAuth.getInstance(app);
  }
}
