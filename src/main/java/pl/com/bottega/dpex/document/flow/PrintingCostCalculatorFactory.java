package pl.com.bottega.dpex.document.flow;

import pl.com.bottega.dpex.document.flow.printing.BWPrintCalculator;
import pl.com.bottega.dpex.document.flow.printing.PrintingCostCalculator;
import pl.com.bottega.dpex.document.flow.printing.RGBCostCalculator;
import pl.com.bottega.dpex.document.shared.Settings;

public class PrintingCostCalculatorFactory {

    private PrintingCostCalculator printingCostCalculator;

    public PrintingCostCalculator create() {
        if(Settings.CURRENT_PRINTER.equals("COLOR"))
            return new RGBCostCalculator();
        else
            return new BWPrintCalculator();
    }

}
