package com.lucy.musicStore.product.music.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Price not found with the given ID")
public class NoPriceFoundException extends Exception {
}
