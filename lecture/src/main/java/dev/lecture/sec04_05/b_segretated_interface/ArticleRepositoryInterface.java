package dev.lecture.sec04_05.b_segretated_interface;

public interface ArticleRepositoryInterface {
    void createArticle();
    Article findArticleById(Long id);
}
