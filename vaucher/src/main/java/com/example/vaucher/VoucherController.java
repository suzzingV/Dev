package com.example.vaucher;

import org.springframework.stereotype.Controller;

import static com.example.vaucher.ConsoleView.exitMessage;
import static com.example.vaucher.ConsoleView.selectMenu;

@Controller
public class VoucherController {
    static VoucherService service;
    public static void run() {
        String command = selectMenu();
        switch (command) {
            case "create" -> service.create();
            case "list" -> service.list();
            case "exit" -> {
                exitMessage();
                System.exit(0);
            }
        }
    }
}
