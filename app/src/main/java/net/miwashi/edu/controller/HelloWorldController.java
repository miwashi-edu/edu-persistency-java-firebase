package net.miwashi.edu.controller;

import net.miwashi.edu.repository.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ExecutionException;

@RestController
public class HelloWorldController {

    @Autowired
    UserService userService;

    @GetMapping(path="/users")
    ResponseEntity<?> getUsers() {
        try {
            userService.getUserDetails("nisse");

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        }
        return ResponseEntity.ok("Hello World");
    }

}
