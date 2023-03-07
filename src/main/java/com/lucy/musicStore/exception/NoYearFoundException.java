package com.lucy.musicStore.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Year not found with the given ID")
public class NoYearFoundException extends Exception {
}
