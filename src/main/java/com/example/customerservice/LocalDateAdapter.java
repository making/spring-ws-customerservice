package com.example.customerservice;

import java.time.LocalDate;

public class LocalDateAdapter {
	public static LocalDate parse(String value) {
		return LocalDate.parse(value);
	}

	public static String print(LocalDate value) {
		return value.toString();
	}
}
