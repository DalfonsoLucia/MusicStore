package com.lucy.musicStore.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NO_CONTENT, reason = "No subtotal found")
public class NoSubtotalContentException extends Exception{
}