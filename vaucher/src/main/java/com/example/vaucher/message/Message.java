package com.example.vaucher.message;

public enum Message {
    MENU_SELECT("""
                === Voucher Program ===
                Type exit to exit the program.
                Type create to create a new voucher.
                Type list to list all vouchers.
                """),
    EXIT_PROGRAM("Exit the program.");

    private String message;

    Message(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
