package com.secretsalty.secretsalty.endpoint.controller;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@RequestMapping("/app")
public class TestAuthController {

    private final FirebaseAuth firebaseAuth;

    @Autowired
    public TestAuthController(FirebaseAuth firebaseAuth) {
        this.firebaseAuth = firebaseAuth;
    }

    @GetMapping(path = "/test")
    public String test(Principal principal) throws FirebaseAuthException {
        return "hello, " + firebaseAuth.getUser(principal.getName()).getEmail();
    }
}
