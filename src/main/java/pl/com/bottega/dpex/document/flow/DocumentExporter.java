package pl.com.bottega.dpex.document.flow;

import pl.com.bottega.dpex.document.flow.printing.DocumentType;

import java.util.Date;

public interface DocumentExporter {

    void addTitle(String title);

    void addContent(String content);

    void addStatus(DocumentStatus status);

    void addDocumentType(DocumentType type);

    void addExpirationDate(Date date);

    void start();

    void finish();
}
