package pl.com.bottega.dpex.document.flow;

import pl.com.bottega.dpex.document.flow.command.CreateDocumentCommand;
import pl.com.bottega.dpex.document.flow.number.DocumentNumber;
import pl.com.bottega.dpex.document.flow.number.NumberGenerator;

public class Document {

    private final DocumentNumber number;
    private String title, content;
    private DocumentType type;

    public Document(NumberGenerator numberGenerator, CreateDocumentCommand cmd) {
        this.number = numberGenerator.generate(cmd.getDocumentType());
        this.title = cmd.getTitle();
        this.type = cmd.getDocumentType();
    }

}
