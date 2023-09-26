@RestController
public class Controller extends Service {
    @GetMapping("/some-api")
    public void someApi() {
        this.createArticle("의미 없는 데이터");
    }
}