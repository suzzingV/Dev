package dev.lecture.sec04_05.b_segretated_interface;

public class UserService {
    private UserRepositoryInterface repository = new UserRepository();

    public void createUser() {
        repository.createUser();
    }

    public User findByUser(Long id) {
        return repository.findUserById(id);
    }
}
