package pl.com.bottega.dpex.document.flow;

import pl.com.bottega.dpex.document.flow.number.DocumentNumber;

public interface DocumentRepository {

    void put(Document document);

    Document get(DocumentNumber nr);

}
