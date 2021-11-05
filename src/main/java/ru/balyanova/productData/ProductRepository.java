package ru.balyanova.productData;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class ProductRepository {
    private List<Product> productList;

    @PostConstruct
    public void init() {
        productList = new ArrayList<>(Arrays.asList(
                new Product(1, "Bread", 100),
                new Product(2, "Bread Luxury", 200),
                new Product(3, "Apple", 100),
                new Product(4, "Milk", 70),
                new Product(5, "Eggs", 100)
        ));}

    public List<Product> getProductList() {
        return productList;
    }

    public Product findProductById(int id) {
        return productList.stream().filter(i -> i.getId() == id).findFirst().get();
    }
}
