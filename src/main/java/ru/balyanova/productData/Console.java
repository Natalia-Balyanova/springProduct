package ru.balyanova.productData;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.Scanner;

@Configuration
@ComponentScan("ru.balyanova.productData")
public class Console {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Console.class);

        Scanner scanner = new Scanner(System.in);
        ProductRepository productRepository = context.getBean(ProductRepository.class);
        // TODO: 05.11.2021  
        while (true) {
            System.out.println("Create new cart? -Send '1' \n" +
                    "If you want to exit - send '0'");
            int createOrExit = scanner.nextInt();
            if (createOrExit == 0) {
                System.out.println("Exit");
                break;
            } else if (createOrExit == 1) {
                Cart cart = context.getBean(Cart.class);
                System.out.println("Cart created. \n " +
                        "Add product - send '1' \n " +
                        "Delete product - send '2' \n" +
                        "If you want to exit - send '0'");
                actionWithCart(cart, scanner, productRepository);
            } else break;
        }
    }

    private static void actionWithCart(Cart cart, Scanner scanner, ProductRepository productRepository) {
        // TODO: 05.11.2021  
        while (true) {
            int scanActionWithCart = scanner.nextInt();
            switch (scanActionWithCart) {
                case 0:
                    System.out.println("Exit");
                    break;
                case 1:
                    System.out.println("Choose the product by id: " + productRepository.getProductList());
                    cart.addProduct(scanner.nextInt());
                    System.out.println("Choose the action. " +
                            "Add product - send '1' \n" +
                            "Delete product - send '2' \n" +
                            "If you want to exit - send '0'");
                case 2:
                    cart.delProduct(scanner.nextInt());
                    System.out.println("Product deleted. Product in the cart: " + cart.getProductInCart());
                    System.out.println("Choose the action. " +
                            "Add product - send '1' \n" +
                            "Delete product - send '2' \n" +
                            "If you want to exit - send '0'");
            }
        }
    }
}
