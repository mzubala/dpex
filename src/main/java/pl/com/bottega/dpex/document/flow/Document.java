package pl.com.bottega.dpex.document.flow;

import pl.com.bottega.dpex.document.flow.commands.CreateDocumentCommand;
import pl.com.bottega.dpex.document.flow.commands.PublishDocumentCommand;
import pl.com.bottega.dpex.document.flow.number.DocumentNumber;
import pl.com.bottega.dpex.document.flow.number.NumberGenerator;
import pl.com.bottega.dpex.document.flow.printing.DocumentType;
import pl.com.bottega.dpex.document.flow.printing.Printable;
import pl.com.bottega.dpex.document.flow.printing.PrintingCostCalculator;
import pl.com.bottega.dpex.document.flow.validation.DocumentValidator;
import pl.com.bottega.dpex.document.shared.Money;

import java.util.Date;

public class Document implements Printable {

    private static final int CHARS_PER_PAGE = 500;
    private final String author;

    private DocumentNumber number;

    private String title, content;

    private DocumentStatus status;

    private Money printingCost;
    private DocumentType documentType;
    private Date expirationDate;

    public Document(DocumentNumber number, CreateDocumentCommand createDocumentCommand) {
        this.title = createDocumentCommand.getTitle();
        this.number = number;
        this.status = DocumentStatus.DRAFT;
        this.documentType = createDocumentCommand.getDocumentType();
        this.author = createDocumentCommand.getAuthor();
    }

    public void verify(DocumentValidator documentValidator) {
        documentValidator.validate(this, DocumentStatus.VERIFIED);
        this.status = DocumentStatus.VERIFIED;
    }

    public void publish(PrintingCostCalculator printingCostCalculator, DocumentValidator validator,
                        PublishDocumentCommand publishDocumentCommand) {
        validator.validate(this, DocumentStatus.PUBLISHED);
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

    @Override
    public DocumentType getType() {
        return documentType;
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

    public Date getExpirationDate() {
        return expirationDate;
    }

    public String getAuthor() {
        return author;
    }

    public String getContent() {
        return content;
    }
}
