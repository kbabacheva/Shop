package Main;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import Interfaces.Expirable;
import Products.Appliance;
import Products.Computer;
import Products.FoodProduct;
import Products.Product;

public class Shop {
    public static void main(String[] args) {
        FoodProduct cigars = new FoodProduct("Karelia", new BigDecimal(5), 1500, AgeRestriction.ADULT, LocalDate.of(2016,10,10));
        FoodProduct martini = new FoodProduct("Martini Bianco", new BigDecimal(18), 40, AgeRestriction.ADULT, LocalDate.of(2020,9,10));
        FoodProduct chocolete = new FoodProduct("Toblerone", new BigDecimal(6), 100, AgeRestriction.NONE, LocalDate.of(2015,10,25));
        Computer laptop = new Computer("Acer Aspire",new BigDecimal(1500),1050);
        Computer desktopPC = new Computer("Intel", new BigDecimal(1200),1);
        Appliance tv = new Appliance("Toshiba 32", new BigDecimal(700), 3);
        Appliance dishwasher = new Appliance("Indesit", new BigDecimal(600), 5);
        FoodProduct bread = new FoodProduct("White bread", new BigDecimal(1), 100, AgeRestriction.NONE,LocalDate.of(2014,10,10));

        ArrayList<Product> products = new ArrayList<>();
        products.add(cigars);
        products.add(martini);
        products.add(chocolete);
        products.add(laptop);
        products.add(desktopPC);
        products.add(tv);
        products.add(dishwasher);

        Customer ivan = new Customer("Ivan Ivanov", 15, new BigDecimal(30));
        Customer petar = new Customer("Petar Petrov", 22, new BigDecimal(1));
        Customer stoyan = new Customer("Stoyan Stoyanov", 40, new BigDecimal(5000));
        try{
        //    PurchaseManager.processPurchase(martini,petar);
        //    PurchaseManager.processPurchase(cigars,ivan);
        //    PurchaseManager.processPurchase(bread,ivan);
        //    PurchaseManager.processPurchase(laptop, stoyan);
        } catch (Exception ex){
            System.out.println(ex.getMessage());
        }
        //System.out.println(laptop.getPrice());
        //System.out.println(stoyan.getBalance());

        String recentlyExpiring = products.stream()
                .filter(p -> p instanceof Expirable)
                .map(p -> ((FoodProduct) p))
                .sorted(Comparator.comparing(p -> p.getExpirationDate()))
                .findFirst()
                .get().getName();
        //System.out.println(recentlyExpiring);

        List<Product> adultProducts= products.stream()
                .filter(p -> p.getAgeRestriction() == AgeRestriction.ADULT)
                .sorted(Comparator.comparing(p -> p.getPrice()))
                .collect(Collectors.toList());
        StringBuilder sb = new StringBuilder();
        for(Product p : adultProducts){
            sb.append(p.getName());
            sb.append("\t\n");
        }
        //System.out.println(sb);
    }
}

