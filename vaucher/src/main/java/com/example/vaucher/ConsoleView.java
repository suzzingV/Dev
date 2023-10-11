package com.example.vaucher;

import java.util.Scanner;

public class ConsoleView {
    public static String selectMenu() {
        System.out.println("""
                === Voucher Program ===
                Type exit to exit the program.
                Type create to create a new voucher.
                Type list to list all vouchers.
                """);

        Scanner sc = new Scanner(System.in);
        return sc.nextLine();
    }

    public static void exitMessage() {
        System.out.println("Exit");
    }
}
