package org.example.models;

import org.example.util.DataTransferObject;

public class Product implements DataTransferObject {
    private long product_id;
    private String product_name;
    private long category_id;
    private String unit;

    public long getProduct_id() {
        return product_id;
    }

    public void setProduct_id(long product_id) {
        this.product_id = product_id;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public long getCategory_id() {
        return category_id;
    }

    public void setCategory_id(long category_id) {
        this.category_id = category_id;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    private long price;

    @Override
    public long getId() {
        return product_id;
    }

    @Override
    public String toString() {
        return "Product: " + product_name + " " + price;
    }
}
