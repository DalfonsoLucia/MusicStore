package com.lucy.musicStore.exception;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@Getter
@Setter
@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "No value present with this ID in the stock")
public class NoStockIdFoundException extends Exception {

}
