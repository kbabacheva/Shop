package Products;
import java.math.BigDecimal;

import Interfaces.Buyable;
import Main.AgeRestriction;


/**
 * Created by lucky on 10/21/2015.
 */
public abstract class Product implements Buyable {
    private static final BigDecimal ONE_HUNDRED = new BigDecimal(100);

    private String name;
    private BigDecimal price;
    private double quantity;
    private AgeRestriction ageRestriction;

    protected Product(String name, BigDecimal price, double quantity, AgeRestriction ageRestriction){
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.ageRestriction = ageRestriction;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name.equals(null) || name.length() == 0) {
            throw new IllegalArgumentException("Name cannot be empty");
        }
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        if (price.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("Price cannot be negative");
        }
        this.price = price;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        if (quantity < 0) {
            throw new IllegalArgumentException("Quantity cannot be negative");
        }
        this.quantity = quantity;
    }
     protected static BigDecimal percentage(BigDecimal base, BigDecimal pct) {
         return base.multiply(pct).divide(ONE_HUNDRED);
     }

     public AgeRestriction getAgeRestriction() {
         return ageRestriction;
     }
}

