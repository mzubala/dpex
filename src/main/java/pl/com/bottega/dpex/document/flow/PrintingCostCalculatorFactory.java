package pl.com.bottega.dpex.document.flow;

import pl.com.bottega.dpex.document.flow.printing.*;
import pl.com.bottega.dpex.document.shared.Settings;

public class PrintingCostCalculatorFactory {

    public PrintingCostCalculator create() {
        PrintingCostCalculator calculator;
        if(Settings.CURRENT_PRINTER.equals("COLOR"))
            calculator = new RGBCostCalculator();
        else
            calculator = new BWPrintCalculator();
        calculator = new LargeDocumentPrintingCostDecorator(calculator);
        calculator = new ManualPrintingCostDecorator(calculator);
        return calculator;
    }

}
