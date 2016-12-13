package pl.com.bottega.dpex.document.flow;

import pl.com.bottega.dpex.document.flow.command.CreateDocumentCommand;
import pl.com.bottega.dpex.document.flow.number.DocumentNumber;
import pl.com.bottega.dpex.document.flow.printing.PrintCostCalculator;
import pl.com.bottega.dpex.document.flow.printing.Printable;
import pl.com.bottega.dpex.document.shared.Money;

public class Document implements Printable {

    private static final int CHARS_PER_PAGE = 1000;
    private final DocumentNumber number;
    private String title, content;
    private DocumentType type;
    private Money printingCost = Money.ZERO;
    private DocumentState state;

    public Document(DocumentNumber number, CreateDocumentCommand cmd) {
        this.number = number;
        this.title = cmd.getTitle();
        this.type = cmd.getDocumentType();
        this.content = "";
        this.state = DocumentState.DRAFT;
    }

    @Override
    public int getPagesCount() {
        return 1 + content.length() / CHARS_PER_PAGE;
    }

    public void verify() {
        if(!isDraft())
            throw new IllegalStateException("Document can only be verified in DRAFT state");
        this.state = DocumentState.VERIFIED;
    }

    public boolean isDraft() {
        return state.equals(DocumentState.DRAFT);
    }

    public void publish(PrintCostCalculator calculator) {
        if(!isVerified())
            throw new IllegalStateException("Document can only be published in VERIFIED state");
        this.state = DocumentState.PUBLISHED;
        this.printingCost = calculator.calculateCost(this);
    }

    public boolean isVerified() {
        return state.equals(DocumentState.VERIFIED);
    }

    public DocumentNumber getNumber() {
        return number;
    }

    public Money getPrintCost() {
        return printingCost;
    }
}
