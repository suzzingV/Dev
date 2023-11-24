package com.prgrms.devcource.security;

import org.springframework.boot.autoconfigure.integration.IntegrationAutoConfiguration;

import java.util.concurrent.CompletableFuture;

import static java.util.concurrent.CompletableFuture.runAsync;

public class ThreadLocalApp {
    final static ThreadLocal<Integer> threadLocalValue = new ThreadLocal<>();

    public static void main(String[] args) {
        System.out.println(getCurrentThreadName() + " ### main set value = 1");
        threadLocalValue.set(1);

        a();
        b();

        CompletableFuture<Void> task = runAsync(() -> { //main스레드가 아닌 다른 스레드에서 실행됨
            a();
            b();
        });

        task.join();
    }

    public static void a() {
        Integer value = threadLocalValue.get();
        System.out.println(getCurrentThreadName() + "### a() get value = " + value);
    }

    public static void b() {
        Integer value = threadLocalValue.get();
        System.out.println(getCurrentThreadName() + "### b() get value = " + value);
    }

    public static String getCurrentThreadName() {
        return Thread.currentThread().getName();
    }
}
