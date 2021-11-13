package ru.balyanova.productData;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;
import java.util.Scanner;

@Configuration
@ComponentScan("ru.balyanova.productData")
public class Console {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Console.class);

        Scanner scanner = new Scanner(System.in);
        ProductRepository productRepository = context.getBean(ProductRepository.class);

        while (true) {
            System.out.println("Create new cart? - send '1' \n" +
                               "If you want to exit - send '0'");
            int createCartOrExit = scanner.nextInt();

            if (createCartOrExit == 1) {
                Cart cart = context.getBean(Cart.class);
                System.out.println("Cart created. \n " + stringAction());
                try {
                    actionWithCart(cart, scanner, productRepository);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else
                System.out.println("Exit"); break;
        }
    }
    private static String stringAction() {
        return  "Add product - send '10' \n " +
                "Delete product - send '20' \n" +
                "If you want to exit - send '00'";
    }

    private static void actionWithCart(Cart cart, Scanner scanner, ProductRepository productRepository) throws Exception{
        // TODO: 05.11.2021  
        while (true) {
            Long scanActionWithCart = scanner.nextLong();
            if (scanActionWithCart == 10) {
                System.out.println("Choose the product by id: \n" + productRepository.getProductList());
                cart.addProduct(scanner.nextLong());
                System.out.println("Choose the action. \n" + stringAction());
            } else if (scanActionWithCart == 20) {
                System.out.println("Choose the product by id: \n" + cart.getProductInCart());
                cart.delProduct(scanner.nextLong());
                System.out.println("Product in the cart: " + cart.getProductInCart());
                System.out.println("Choose the action. \n" + stringAction());
            } else if (scanActionWithCart == 00) {
                System.out.println("Exit");
            } else {
                System.out.println("something wrong. \n" + stringAction());
            }
        }
    }
}
