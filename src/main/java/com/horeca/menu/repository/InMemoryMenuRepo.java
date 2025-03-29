package com.horeca.menu.repository;

// Add necessary imports here

// This class implements the repository interface using an in-memory collection

import com.horeca.menu.model.MenuItem;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.*;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class InMemoryMenuRepo implements MenuRepo {

    // TODO: Create a private Map<Long, MenuItem> to store menu items - ✅
    private final Map<Long, MenuItem> items = new HashMap<>();
    private final AtomicLong counter = new AtomicLong(1);

    // TODO: Initialize the map with some sample data in a constructor or @PostConstruct method - ✅
    @PostConstruct // remember to not add parameters to @PostConstruct methods
    public void initializeSampleData() {
        items.clear();

        MenuItem item1 = new MenuItem(1L, "Pizza", "bona", new BigDecimal("7.5"), "Pizza");
        MenuItem item2 = new MenuItem(2L, "Pasta", "rica", new BigDecimal("13"), "Pasta");
        MenuItem item3 = new MenuItem(3L, "Carne", "bomba", new BigDecimal("23"), "Manzo");

        items.put(1L, item1);
        items.put(2L, item2);
        items.put(3L, item3);
    }

    // TODO: Implement all methods defined in the MenuRepository interface - ✅

    @Override
    public List<MenuItem> findAllItems() {
        return new ArrayList<>(items.values());
    }

    @Override
    public Optional<MenuItem> findItemById(Long id) {
        return Optional.ofNullable(items.get(id));
    }

    @Override
    public MenuItem saveItem(MenuItem item) {
        if(item.getId() == null) {
            // add new item incrementing with getAndIncrement() method of AtomicLong
            item.setId(counter.getAndIncrement());
        }

        items.put(item.getId(), item);

        return item;
    }

    @Override
    public void deleteItem(Long id) {
        items.remove(id);
    }
}