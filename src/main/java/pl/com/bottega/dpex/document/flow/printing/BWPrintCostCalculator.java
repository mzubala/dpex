package pl.com.bottega.dpex.document.flow.printing;

import pl.com.bottega.dpex.document.shared.Money;

import java.math.BigDecimal;

public class BWPrintCostCalculator implements PrintCostCalculator {


    private static final Money COST_PER_PAGE = new Money(new BigDecimal(0.15));

    @Override
    public Money calculateCost(Printable p) {
        return COST_PER_PAGE.multiplyBy(p.getPagesCount());
    }
}
