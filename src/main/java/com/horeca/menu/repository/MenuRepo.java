package com.horeca.menu.repository;

// Add necessary imports here

import com.horeca.menu.model.MenuItem;

import java.util.List;
import java.util.Optional;

// This interface will define methods to access menu items
public interface MenuRepo {
    // TODO: Define method to find all menu items - ✅
    List<MenuItem> findAllItems();

    // TODO: Define method to find a menu item by its ID - ✅
    Optional<MenuItem> findItemById(Long id);

    // TODO: Define method to save a new menu item - ✅
    MenuItem saveItem(MenuItem item);

    // TODO: Define method to delete a menu item - ✅
    void deleteItem(Long id);
}