package com.example.vaucher.view;

import com.example.vaucher.message.Message;

import static com.example.vaucher.view.Reader.sc;

public class ConsoleView {
    public static String selectMenu() {
        System.out.println(Message.MENU_SELECT.getMessage());
        return sc.nextLine();
    }

    public static void exitMessage() {
        System.out.println(Message.EXIT_PROGRAM.getMessage());
    }
}
