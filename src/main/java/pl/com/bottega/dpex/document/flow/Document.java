package pl.com.bottega.dpex.document.flow;

import pl.com.bottega.dpex.document.flow.command.CreateDocumentCommand;
import pl.com.bottega.dpex.document.flow.number.DocumentNumber;
import pl.com.bottega.dpex.document.flow.number.NumberGenerator;
import pl.com.bottega.dpex.document.flow.printing.PrintCostCalculator;
import pl.com.bottega.dpex.document.flow.printing.Printable;
import pl.com.bottega.dpex.document.shared.Money;

public class Document implements Printable {

    private static final int CHARS_PER_PAGE = 1000;
    private final DocumentNumber number;
    private String title, content;
    private DocumentType type;
    private Money printingCost = Money.ZERO;

    public Document(NumberGenerator numberGenerator, CreateDocumentCommand cmd) {
        this.number = numberGenerator.generate(cmd.getDocumentType());
        this.title = cmd.getTitle();
        this.type = cmd.getDocumentType();
        this.content = "";
    }

    @Override
    public int getPagesCount() {
        return 1 + content.length() / CHARS_PER_PAGE;
    }

    public void publish(PrintCostCalculator calculator) {
        this.printingCost = calculator.calculateCost(this);
    }

}
