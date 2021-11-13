package ru.balyanova.productData;

public class Product {

    private Long id;
    private String title;
    private double cost;

    public Product(Long id, String title, double cost) {
        this.id = id;
        this.title = title;
        this.cost = cost;
    }

    public Long getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Product: " + id + " " + title + " " + cost + " руб. \n";
    }
}
