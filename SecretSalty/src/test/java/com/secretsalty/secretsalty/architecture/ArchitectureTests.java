package com.secretsalty.secretsalty.architecture;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;

import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.core.importer.ClassFileImporter;
import com.tngtech.archunit.lang.ArchRule;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RestController;

class ArchitectureTests {

  @Test
  @DisplayName("Controllers should be annotated with @RestController")
  void controllerClassesShouldBeAnnotatedAccordingly() {
    JavaClasses classes = new ClassFileImporter().importPackages("com.secretsalty");

    ArchRule rule =
        classes()
            .that()
            .haveSimpleNameEndingWith("Controller")
            .should()
            .beAnnotatedWith(RestController.class);

    rule.check(classes);
  }

  @Test
  @DisplayName("Repositories should be annotated with @Repository")
  void repositoryClassesShouldBeAnnotatedAccordingly() {
    JavaClasses classes = new ClassFileImporter().importPackages("com.secretsalty");

    ArchRule rule =
        classes()
            .that()
            .haveSimpleNameEndingWith("Repository")
            .should()
            .beAnnotatedWith(Repository.class);

    rule.check(classes);
  }

  @Test
  @DisplayName("Configs should be annotated with @Configuration")
  void configurationClassesShouldBeAnnotatedAccordingly() {
    JavaClasses classes = new ClassFileImporter().importPackages("com.secretsalty");

    ArchRule rule =
        classes()
            .that()
            .haveSimpleNameEndingWith("Config")
            .or()
            .haveSimpleNameEndingWith("Configuration")
            .should()
            .beAnnotatedWith(Configuration.class);

    rule.check(classes);
  }
}
