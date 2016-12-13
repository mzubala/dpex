package pl.com.bottega.dpex.document.flow.printing;

import pl.com.bottega.dpex.document.shared.PrintType;
import pl.com.bottega.dpex.document.shared.Settings;

public class PrintCostCalculatorFactory {

    public PrintCostCalculator create() {
        if (Settings.getPrintType().equals(PrintType.BW))
            return new BWPrintCostCalculator();
        else
            return new RGBPrintCostCalculator();
    }

}
