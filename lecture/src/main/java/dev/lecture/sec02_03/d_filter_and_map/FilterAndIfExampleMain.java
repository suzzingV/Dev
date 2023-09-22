package dev.lecture.sec02_03.d_filter_and_map;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FilterAndIfExampleMain {
    public static void main(String[] args) {
        int[] integerArray = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        List<Integer> integerList = Arrays.stream(integerArray)
                .boxed()
                .toList();

        System.out.println(integerList);

        List<Integer> evenNumberList = integerList.stream()
                .filter(integer -> integer % 2 == 0)
                .toList();

        List<Integer> evenX10NumberList = evenNumberList.stream()
                        .map(integer -> integer * 10)
                        .toList();

        System.out.println(evenX10NumberList);
    }
}
