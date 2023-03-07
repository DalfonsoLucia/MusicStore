package com.lucy.musicStore.exception;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@Getter
@Setter
@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Album not present with the given ID")
public class NoAlbumIdFoundException extends Exception {

}
