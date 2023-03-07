package com.lucy.musicStore.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "No sale present with this ID")
public class NoSaleIdFoundException extends Exception{
}
