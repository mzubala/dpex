package pl.com.bottega.dpex.document.flow.infrastructure;

import pl.com.bottega.dpex.document.flow.Document;
import pl.com.bottega.dpex.document.flow.DocumentRepository;
import pl.com.bottega.dpex.document.flow.number.DocumentNumber;

import java.util.HashMap;
import java.util.Map;

public class InMemoryDocumentRepository implements DocumentRepository {

    private static final Map<DocumentNumber, Document> DOCS = new HashMap<>();

    @Override
    public void put(Document document) {
        DOCS.put(document.getNumber(), document);
    }

    @Override
    public Document get(DocumentNumber nr) {
        return DOCS.get(nr);
    }
}
