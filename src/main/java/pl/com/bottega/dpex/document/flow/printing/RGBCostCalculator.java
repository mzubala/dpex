package pl.com.bottega.dpex.document.flow.printing;

import pl.com.bottega.dpex.document.shared.Money;

import java.math.BigDecimal;

public class RGBCostCalculator implements PrintingCostCalculator {

    private static final Money COST_PER_PAGE = new Money(new BigDecimal(0.25));
    private static final Money COST_PER_IMG = new Money(new BigDecimal(0.30));

    @Override
    public Money cost(Printable printable) {
        return COST_PER_PAGE.multiplyBy(printable.pagesCount()).
                add(COST_PER_IMG.multiplyBy(printable.picturesCount()));
    }

}
