package com.horeca.menu.service;

// Add necessary imports here

import com.horeca.menu.model.MenuItem;

import java.util.List;

// This interface will define the business operations on menu items
public interface MenuService {
    // TODO: Define method to get all menu items - ✅
    List<MenuItem> getAllItems();

    // TODO: Define method to get a menu item by its ID - ✅
    MenuItem getItemById(Long id);

    // TODO: Define method to create a new menu item - ✅
    MenuItem createItem(MenuItem item);

    // TODO: Define method to update a menu item - ✅
    MenuItem updateItem(Long id, MenuItem item);

    // TODO: Define method to delete a menu item - ✅
    void deleteItem(Long id);
}
