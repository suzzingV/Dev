package dev.lecture.sec04_05.a_integrated_interface;

import java.lang.annotation.Inherited;

public class ArticleRepository implements Repository {
    @Override
    public void createUser() {

    }

    @Override
    public User findUserById(Long id) {
        return null;
    }

    @Override
    public void createArticle() {

    }

    @Override
    public Article findArticleById(Long id) {
        return null;
    }
}
