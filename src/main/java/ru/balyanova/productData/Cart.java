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

    public void addProduct(Long id) {
        productInCart.add(productRepository.findProductById(id - 1));
    }

    public void delProduct(Long id) {
        if(checkProductInCart(id)) {
            productInCart.remove(productRepository.findProductById(id - 1));
        }
        else {
            System.out.println("There is no such a product in the cart with that id");
        }
    }

    private boolean checkProductInCart(Long id) {
        for (Product p : productInCart) {
            if(p.getId() == productRepository.findProductById(id - 1).getId()) {
                return true;
            }
        } return false;
    }
}
