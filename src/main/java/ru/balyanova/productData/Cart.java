package ru.balyanova.productData;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Component
@Scope("prototype")
public class Cart {

    private ProductRepository productRepository;
    public List<Product> productInCart;

    public List<Product> getProductInCart() {
        return productInCart;
    }
     @PostConstruct
    public void init() {
        productInCart = new ArrayList<>();
    }

    @Autowired
    public void setProductRepository(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public void addProduct(int id) {
        productInCart.add(productRepository.findProductById(id));
    }

    public void delProduct(int id) {
        productInCart.remove(productInCart.stream().filter(i -> i.getId() == id).findFirst().get());
    }
}
