package pl.com.bottega.dpex.document.flow;

import pl.com.bottega.dpex.document.flow.commands.CreateDocumentCommand;
import pl.com.bottega.dpex.document.flow.commands.PublishDocumentCommand;
import pl.com.bottega.dpex.document.flow.number.DocumentNumber;
import pl.com.bottega.dpex.document.flow.number.NumberGenerator;
import pl.com.bottega.dpex.document.flow.printing.Printable;
import pl.com.bottega.dpex.document.flow.printing.PrintingCostCalculator;
import pl.com.bottega.dpex.document.shared.Money;

public class Document implements Printable {

    private static final int CHARS_PER_PAGE = 500;

    private DocumentNumber number;

    private String title, content;

    private DocumentStatus status;

    private Money printingCost;

    public Document(DocumentNumber number, CreateDocumentCommand createDocumentCommand) {
        this.title = createDocumentCommand.getTitle();
        this.number = number;
        this.status = DocumentStatus.DRAFT;
    }

    public void publish(PrintingCostCalculator printingCostCalculator, PublishDocumentCommand publishDocumentCommand) {
        this.printingCost = printingCostCalculator.cost(this);
        this.status = DocumentStatus.PUBLISHED;
        // TODO further publish processing
    }

    @Override
    public int pagesCount() {
        if(content == null)
            return 1;
        return content.length() / CHARS_PER_PAGE + 1;
    }

    @Override
    public int picturesCount() {
        // TODO count pics in content
        return 0;
    }

    public DocumentNumber getNumber() {
        return number;
    }

    public String getTitle() {
        return title;
    }

    public DocumentStatus getStatus() {
        return status;
    }

    public Money getPrintingCost() {
        return printingCost;
    }

}
