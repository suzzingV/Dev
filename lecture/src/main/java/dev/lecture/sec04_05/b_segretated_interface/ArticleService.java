package dev.lecture.sec04_05.b_segretated_interface;

public class ArticleService {
    private ArticleRepositoryInterface repository = new ArticleRepository();

    public void createArticle() {
        repository.createArticle();
    }

    public Article findByArticle(Long id) {
        return repository.findArticleById(id);
    }
}
