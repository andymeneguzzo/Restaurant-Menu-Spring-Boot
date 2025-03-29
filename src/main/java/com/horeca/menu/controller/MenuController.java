package com.horeca.menu.controller;

// Add necessary imports here

// This class will handle HTTP requests related to menu items


// Add @RestController annotation to make it a REST controller
// Add @RequestMapping("/api/menu") to set the base path for all endpoints

import com.horeca.menu.model.MenuItem;
import com.horeca.menu.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/menu")
public class MenuController {

    // TODO: Inject the MenuService using @Autowired - ✅
    public final MenuService menuService;

    @Autowired
    public MenuController(MenuService menuService) {
        this.menuService = menuService;
    }

    // TODO: Create a GET endpoint that returns all menu items - ✅
    @GetMapping
    public ResponseEntity<List<MenuItem>> getAllItems() {
        return ResponseEntity.ok(menuService.getAllItems());
    }

    // TODO: Create a GET endpoint that returns a menu item by ID - ✅
    @GetMapping("/{id}")
    public ResponseEntity<MenuItem> getItemById(@PathVariable Long id) {
        // Exception handling
        try {
            return ResponseEntity.ok(menuService.getItemById(id));
        } catch (Exception ex) {
            return ResponseEntity.notFound().build();
        }
    }

    // TODO: Create a POST endpoint that creates a new menu item - ✅
    @PostMapping
    public ResponseEntity<MenuItem> createItem(@RequestBody MenuItem item) {
        MenuItem createdItem = menuService.createItem(item);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdItem);
    }

    // TODO: Create a PUT endpoint that updates an existing menu item - ✅
    @PutMapping("/{id}")
    public ResponseEntity<MenuItem> updateItem(@PathVariable Long id, @RequestBody MenuItem item) {
        try {
            MenuItem updatedItem = menuService.updateItem(id, item);
            return ResponseEntity.ok(updatedItem);
        } catch (Exception ex) {
            return ResponseEntity.notFound().build();
        }
    }

    // TODO: Create a DELETE endpoint that deletes a menu item - ✅
    @DeleteMapping("/{id}")
    public ResponseEntity<MenuItem> deleteItem(@PathVariable Long id) {
        try {
            menuService.deleteItem(id);
            return ResponseEntity.noContent().build();
        } catch (Exception ex) {
            return ResponseEntity.notFound().build();
        }
    }

}