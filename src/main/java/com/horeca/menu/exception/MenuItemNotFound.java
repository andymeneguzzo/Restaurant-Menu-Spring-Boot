package com.horeca.menu.exception;

public class MenuItemNotFound extends RuntimeException {
    public MenuItemNotFound(String message) {
        super(message);
    }
}
