package service;

import repository.NormalRepository;
import repository.Repository;

public class NormalService extends Service {
    Repository repository = new NormalRepository();
}
