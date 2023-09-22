package dev.lecture.sec03_04.c_change_repository;

import org.springframework.context.annotation.Profile;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Order(0)
@Component
public class FileRepository implements Repository {
    @Override
    public void someMethod(String articleContent) {
        System.out.println("FileRepository");
    }
}
