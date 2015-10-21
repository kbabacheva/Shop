package Products;

import java.math.BigDecimal;

import Main.AgeRestriction;
import Main.GuaranteePeriod;

public class Computer extends ElectronicsProduct {
    private final int totalQualityForReducedPrice = 1000;
    private final BigDecimal offPercentage = new BigDecimal(5);

    public Computer(String name, BigDecimal price, double quantity){
        super(name, price, quantity, AgeRestriction.NONE, GuaranteePeriod.COMPUTER);
        this.setPrice(price);
    }

    @Override
    public void setPrice(BigDecimal price){
        if(this.getQuantity() >= totalQualityForReducedPrice){
            super.setPrice(price.subtract(percentage(price, offPercentage)));
        }
    }
}
