package dev.lecture.sec04_06;

import java.util.NoSuchElementException;

public class Service {
    private Repository repository;

    public Object findById(Long id) {
        Object obj = null;

        try {
            obj = repository.findById(id);
        } catch (RecordNotFoundException recordNotFoundException) {

        } catch (TextNotFoundException textNotFoundException) {

        } catch (NoSuchElementException noSuchElementException) {

        }

        return obj;
    }
}
