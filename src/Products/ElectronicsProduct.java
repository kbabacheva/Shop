package Products;

import java.math.BigDecimal;

import Main.AgeRestriction;
import Main.GuaranteePeriod;

public abstract class ElectronicsProduct extends Product{
    private GuaranteePeriod guaranteePeriod;

    protected ElectronicsProduct(
            String name,
            BigDecimal price,
            double quantity,
            AgeRestriction ageRestriction,
            GuaranteePeriod guaranteePeriod) {
        super(name, price, quantity, ageRestriction);
        this.guaranteePeriod = guaranteePeriod;
    }

    public GuaranteePeriod getGuaranteePeriod() {
        return guaranteePeriod;
    }
}
