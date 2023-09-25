package dev.lecture.sec04_05.b_segretated_interface;

public class UserRepository implements UserRepositoryInterface {
    @Override
    public void createUser() {}

    @Override
    public User findUserById(Long id) {
        return null;
    }
}
