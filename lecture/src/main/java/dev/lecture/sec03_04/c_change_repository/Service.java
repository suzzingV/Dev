package dev.lecture.sec03_04.c_change_repository;

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
