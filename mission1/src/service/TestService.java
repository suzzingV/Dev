package service;

import repository.Repository;
import repository.TestRepository;

public class TestService extends Service {
    Repository repository = new TestRepository();
}
