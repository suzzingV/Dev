package com.example.vaucher;

import com.example.vaucher.controller.VoucherController;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class VoucherApplication {

	public static void main(String[] args) {
		VoucherController.run();
	}

}
