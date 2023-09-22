package dev.lecture.sec01_07.hash_code;

import java.util.HashSet;
import java.util.Set;

public class HashCodeExampleMain {
    public static void main(String[] args) {
        SomeObject sameObject1 = new SomeObject(1, "programmers");
        SomeObject sameObject2 = new SomeObject(1, "programmers");

        System.out.println(sameObject1.hashCode());
        System.out.println(sameObject2.hashCode());

        Set<SomeObject> set = new HashSet<>();

        set.add(sameObject1);
        set.add(sameObject2);

        System.out.println(set.size());
    }
}
