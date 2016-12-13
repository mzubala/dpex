package pl.com.bottega.dpex.document.flow.printing;

import pl.com.bottega.dpex.document.shared.Money;

public interface PrintCostCalculator {

    Money calculateCost(Printable p);

}
