@RestController
public class Controller {
    Service service;

    public Controller(Service service) {
        this.service = service;
    }

    @RequestMapping(value = "/some-api")
    public void someApi() {
        service.createArticle("의미 없는 데이터");
    }
}