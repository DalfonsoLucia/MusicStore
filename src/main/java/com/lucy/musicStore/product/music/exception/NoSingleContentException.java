package com.lucy.musicStore.product.music.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NO_CONTENT, reason = "No single found")
public class NoSingleContentException extends Exception{
}