package ru.balyanova.productData;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Component
public class ProductRepository {
    private List<Product> productList;

    public List<Product> getProductList() {
        return Collections.unmodifiableList(productList);
    }

    @PostConstruct
    public void init() {
        productList = new ArrayList<>(Arrays.asList(
                new Product(1L, "Bread", 100),
                new Product(2L, "Bread Luxury", 200),
                new Product(3L, "Apple", 100),
                new Product(4L, "Milk", 70),
                new Product(5L, "Eggs", 100)
        ));}

    public Product findProductById(Long id) {
        return productList.get(Math.toIntExact(id));
    }
}
