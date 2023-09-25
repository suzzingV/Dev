package dev.lecture.sec04_05.a_integrated_interface;

public interface Repository {
    void createUser();
    User findUserById(Long id);

    void createArticle();
    Article findArticleById(Long id);
}
