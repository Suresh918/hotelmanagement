package com.booking.hotelmanagement.exception;

import lombok.Getter;

@Getter
public class DefaultException extends RuntimeException {
	private final String message;

	public DefaultException(String exceptionMessage) {
		this.message = exceptionMessage;
	}
}
