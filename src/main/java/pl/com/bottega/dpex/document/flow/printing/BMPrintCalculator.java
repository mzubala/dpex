package pl.com.bottega.dpex.document.flow.printing;

import pl.com.bottega.dpex.document.shared.Money;

import java.math.BigDecimal;

public class BMPrintCalculator implements PrintingCostCalculator {

    private static final Money COST_PER_PAGE = new Money(new BigDecimal(0.25));

    @Override
    public Money cost(Printable printable) {
        return COST_PER_PAGE.multiplyBy(printable.pagesCount());
    }

}
