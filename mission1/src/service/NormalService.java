package service;

import repository.NormalRepository;
import repository.Repository;

import java.io.IOException;

public class NormalService extends Service {
    Repository repository = new NormalRepository();

    public NormalService() throws IOException {
    }
}
