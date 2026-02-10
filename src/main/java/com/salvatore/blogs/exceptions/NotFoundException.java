package com.salvatore.blogs.exceptions;

public class NotFoundException extends RuntimeException {
    public NotFoundException(long id) {

        super("la risorsa con id " + id + " non è stata trovata!");
    }
}
