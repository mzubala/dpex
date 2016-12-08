package pl.com.bottega.dpex.document.flow.printing;

import pl.com.bottega.dpex.document.shared.Money;

public class LargeDocumentPrintingCostDecorator implements PrintingCostCalculator {

    private PrintingCostCalculator decorated;

    public LargeDocumentPrintingCostDecorator(PrintingCostCalculator decorated) {
        this.decorated = decorated;
    }

    @Override
    public Money cost(Printable printable) {
        Money cost = decorated.cost(printable);
        if (printable.pagesCount() > 100)
            return cost.add(new Money(40.0));
        return cost;
    }
}
