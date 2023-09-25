package dev.lecture.sec04_05.b_segretated_interface;

public interface UserRepositoryInterface {
    void createUser();
    User findUserById(Long id);
}
