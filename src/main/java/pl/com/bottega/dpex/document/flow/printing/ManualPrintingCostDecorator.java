package pl.com.bottega.dpex.document.flow.printing;

import pl.com.bottega.dpex.document.shared.Money;

public class ManualPrintingCostDecorator implements PrintingCostCalculator {

    private PrintingCostCalculator decorated;

    public ManualPrintingCostDecorator(PrintingCostCalculator decorated) {
        this.decorated = decorated;
    }

    @Override
    public Money cost(Printable printable) {
        Money cost = decorated.cost(printable);
        if(printable.getType().equals(DocumentType.MANUAL))
            return cost.add(new Money(30.0));
        return cost;
    }
}
