package Main;
import java.time.LocalDate;

import Products.FoodProduct;
import Products.Product;

public class PurchaseManager {
    public static void processPurchase(Product product, Customer customer){

        if(product.getQuantity() <= 0){
            throw new IllegalArgumentException("Product is out of stock");
        }

        if((product instanceof FoodProduct && LocalDate.now().isAfter(((FoodProduct) product).getExpirationDate()))){
                throw new IllegalArgumentException("Product has expired");
        }

        if (customer.getBalance().compareTo(product.getPrice()) < 0) {
            throw new IllegalArgumentException("You do not have enough money to buy this product!");
        }

        if (customer.getAge() < product.getAgeRestriction().getValue()) {
            throw new IllegalArgumentException("You are too young to buy this product!");
        }

        product.setQuantity(product.getQuantity() - 1);
        customer.setBalance(customer.getBalance().subtract(product.getPrice()));
    }
}
