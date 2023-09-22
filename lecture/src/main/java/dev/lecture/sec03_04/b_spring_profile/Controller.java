package dev.lecture.sec03_04.b_spring_profile;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
    private Service service;

    public Controller(Service service) {
        this.service = service;
    }

    @GetMapping("/some-api")
    public void someApi() {
        service.createArticle("");
    }
}
