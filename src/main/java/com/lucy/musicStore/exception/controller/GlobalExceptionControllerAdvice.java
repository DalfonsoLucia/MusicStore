package com.lucy.musicStore.exception.controller;

import com.lucy.musicStore.exception.*;
import com.lucy.musicStore.exception.error.ApiError;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;

@ControllerAdvice
public class GlobalExceptionControllerAdvice {

    // GESTIONE ECCEZIONI PER LA SEZIONE STOCK
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    @ExceptionHandler(value = NoStockIdFoundException.class)
    public ResponseEntity<ApiError> NoStockIdFoundExceptionHadler(NoStockIdFoundException e, WebRequest request) {

        ApiError error = new ApiError();
        error.setMessage("No value present with this ID in the stock");
        error.setStatusCode(HttpStatus.NOT_FOUND);
        error.setTimeStamp(LocalDateTime.now());
        error.setPath(request.getDescription(false));

        ResponseEntity<ApiError> errorResponse = ResponseEntity.status(HttpStatus.NOT_FOUND.value()).body(error);
        return errorResponse;
    }

    // GESTIONE ECCEZIONI PER LA SEZIONE ALBUM
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    @ExceptionHandler(value = NoAlbumIdFoundException.class)
    public ResponseEntity<ApiError> NoAlbumIdFoundExceptionHadler(NoAlbumIdFoundException e, WebRequest request) {

        ApiError error = new ApiError();
        error.setMessage("Album not present with the given ID");
        error.setStatusCode(HttpStatus.NOT_FOUND);
        error.setTimeStamp(LocalDateTime.now());
        error.setPath(request.getDescription(false));

        ResponseEntity<ApiError> errorResponse = ResponseEntity.status(HttpStatus.NOT_FOUND.value()).body(error);
        return errorResponse;
    }

    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    @ExceptionHandler(value = NoArtistFoundException.class)
    public ResponseEntity<ApiError> NoArtistFoundExceptionHadler(NoArtistFoundException e, WebRequest request) {

        ApiError error = new ApiError();
        error.setMessage("Artist not found with the given ID");
        error.setStatusCode(HttpStatus.NOT_FOUND);
        error.setTimeStamp(LocalDateTime.now());
        error.setPath(request.getDescription(false));

        ResponseEntity<ApiError> errorResponse = ResponseEntity.status(HttpStatus.NOT_FOUND.value()).body(error);
        return errorResponse;
    }

    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    @ExceptionHandler(value = NoTitleFoundException.class)
    public ResponseEntity<ApiError> NoTitleFoundExceptionHadler(NoTitleFoundException e, WebRequest request) {

        ApiError error = new ApiError();
        error.setMessage("Title not found with the given ID");
        error.setStatusCode(HttpStatus.NOT_FOUND);
        error.setTimeStamp(LocalDateTime.now());
        error.setPath(request.getDescription(false));

        ResponseEntity<ApiError> errorResponse = ResponseEntity.status(HttpStatus.NOT_FOUND.value()).body(error);
        return errorResponse;
    }

    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    @ExceptionHandler(value = NoYearFoundException.class)
    public ResponseEntity<ApiError> NoYearFoundExceptionHadler(NoYearFoundException e, WebRequest request) {

        ApiError error = new ApiError();
        error.setMessage("Year not found with the given ID");
        error.setStatusCode(HttpStatus.NOT_FOUND);
        error.setTimeStamp(LocalDateTime.now());
        error.setPath(request.getDescription(false));

        ResponseEntity<ApiError> errorResponse = ResponseEntity.status(HttpStatus.NOT_FOUND.value()).body(error);
        return errorResponse;
    }

    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    @ExceptionHandler(value = NoPriceFoundException.class)
    public ResponseEntity<ApiError> NoPriceFoundExceptionHadler(NoPriceFoundException e, WebRequest request) {

        ApiError error = new ApiError();
        error.setMessage("Price not found with the given ID");
        error.setStatusCode(HttpStatus.NOT_FOUND);
        error.setTimeStamp(LocalDateTime.now());
        error.setPath(request.getDescription(false));

        ResponseEntity<ApiError> errorResponse = ResponseEntity.status(HttpStatus.NOT_FOUND.value()).body(error);
        return errorResponse;
    }

    // GESTIONE ECCEZIONI PER LA SEZIONE SINGLE
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    @ExceptionHandler(value = NoSingleIdFoundException.class)
    public ResponseEntity<ApiError> NoSingleFoundExceptionHadler(NoSingleIdFoundException e, WebRequest request) {

        ApiError error = new ApiError();
        error.setMessage("No single found with this ID");
        error.setStatusCode(HttpStatus.NOT_FOUND);
        error.setTimeStamp(LocalDateTime.now());
        error.setPath(request.getDescription(false));

        ResponseEntity<ApiError> errorResponse = ResponseEntity.status(HttpStatus.NOT_FOUND.value()).body(error);
        return errorResponse;
    }
    // LE ECCEZIONI PER TITOLO, ARTISTA, PREZZO E ARTISTA SONO COMPATIBILI A QUELLE DI ARTIST

    // GESTIONE ECCEZIONI PER LA SEZIONE SALE
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    @ExceptionHandler(value = NoSaleIdFoundException.class)
    public ResponseEntity<ApiError> NoSaleFoundExceptionHadler(NoSaleIdFoundException e, WebRequest request) {

        ApiError error = new ApiError();
        error.setMessage("No sale present with this ID");
        error.setStatusCode(HttpStatus.NOT_FOUND);
        error.setTimeStamp(LocalDateTime.now());
        error.setPath(request.getDescription(false));

        ResponseEntity<ApiError> errorResponse = ResponseEntity.status(HttpStatus.NOT_FOUND.value()).body(error);
        return errorResponse;
    }

    // GESTIONE ECCEZIONI PER LA SEZIONE CART
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    @ExceptionHandler(value = NoCartIdFoundException.class)
    public ResponseEntity<ApiError> NoCartFoundExceptionHadler(NoCartIdFoundException e, WebRequest request) {

        ApiError error = new ApiError();
        error.setMessage("No cart found with this ID");
        error.setStatusCode(HttpStatus.NOT_FOUND);
        error.setTimeStamp(LocalDateTime.now());
        error.setPath(request.getDescription(false));

        ResponseEntity<ApiError> errorResponse = ResponseEntity.status(HttpStatus.NOT_FOUND.value()).body(error);
        return errorResponse;
    }
    //LE ECCEZIONI PER TITOLO, ARTISTA, PREZZO E ARTISTA SONO COMPATIBILI A QUELLE DI ARTIST
}
