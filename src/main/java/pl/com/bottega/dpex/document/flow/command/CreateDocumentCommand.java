package pl.com.bottega.dpex.document.flow.command;

import pl.com.bottega.dpex.document.flow.DocumentType;

public class CreateDocumentCommand {

    private String title;

    private DocumentType documentType;

    public DocumentType getDocumentType() {
        return documentType;
    }

    public void setDocumentType(DocumentType documentType) {
        this.documentType = documentType;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

}
