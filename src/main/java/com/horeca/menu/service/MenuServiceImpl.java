package com.horeca.menu.service;

// Add necessary imports here

import com.horeca.menu.model.MenuItem;
import com.horeca.menu.repository.MenuRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

// This class implements the service interface

@Service
public class MenuServiceImpl implements MenuService {

    // TODO: Inject the MenuRepository using @Autowired - ✅
    private final MenuRepo menuRepo;

    @Autowired
    public MenuServiceImpl(MenuRepo menuRepo) {
        this.menuRepo = menuRepo;
    }

    // TODO: Implement all methods defined in the MenuService interface - ✅

    // TODO: Add validation and business logic as needed - ✅

    @Override
    public List<MenuItem> getAllItems() {
        return menuRepo.findAllItems();
    }

    @Override
    public MenuItem getItemById(Long id) {
        return menuRepo.findItemById(id).orElseThrow(() -> new RuntimeException("Item not found"));
    }

    @Override
    public MenuItem createItem(MenuItem item) {
        return menuRepo.saveItem(item);
    }

    @Override
    public MenuItem updateItem(Long id, MenuItem itemDetails) {
        MenuItem toUpdateItem = getItemById(id);

        // Update all info about the item with the info we want to update it with
        toUpdateItem.setName(itemDetails.getName());
        toUpdateItem.setDescription(itemDetails.getDescription());
        toUpdateItem.setPrice(itemDetails.getPrice());
        toUpdateItem.setCategory(itemDetails.getCategory());

        return menuRepo.saveItem(toUpdateItem);
    }

    @Override
    public void deleteItem(Long id) {
        getItemById(id);
        menuRepo.deleteItem(id);
    }
}
