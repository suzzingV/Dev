package dev.lecture.sec03_04.a_spring_framework;

import org.springframework.stereotype.Component;

@Component
public class Service {
    private Repository repository;

    public Service(Repository repository) {
        this.repository = repository;
    }

    public void createArticle(String articleContent) {
        repository.someMethod(articleContent);
    }
}
