package com.horeca.menu.model;

// Add necessary imports here

import java.math.BigDecimal;
import java.util.Objects;

// This class will represent a menu item in our restaurant
public class MenuItem {

    // TODO: Add private fields for id, name, description, price, and category - ✅
    private Long id;
    private String name;
    private String description;
    private BigDecimal price; // to parse to float when using it to evaluate real prices
    private String category;

    // TODO: Create constructors (default and parameterized) - ✅
    public MenuItem() {}

    public MenuItem(Long id, String name, String description, BigDecimal price, String category) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.category = category;
    }

    // TODO: Create getters and setters for all fields - ✅
    public Long getId() {
        return id;
    }
    public void setId(Long id) {this.id = id;}

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    // TODO: Override toString(), equals(), and hashCode() methods - ✅
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MenuItem menuItem = (MenuItem) o;
        return Objects.equals(id, menuItem.id) && Objects.equals(name, menuItem.name) && Objects.equals(description, menuItem.description) && Objects.equals(price, menuItem.price) && Objects.equals(category, menuItem.category);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, description, price, category);
    }

    @Override
    public String toString() {
        return "Menu Item id=" + id + ", name=" + name + ", description=" + description + ", price=" + price + ", category=" + category + "\n";
    }
}