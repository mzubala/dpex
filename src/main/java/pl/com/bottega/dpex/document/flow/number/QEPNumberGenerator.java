package pl.com.bottega.dpex.document.flow.number;

import pl.com.bottega.dpex.document.flow.DocumentType;

import java.util.UUID;

public class QEPNumberGenerator implements NumberGenerator {
    @Override
    public DocumentNumber generate(DocumentType t) {
        String s = UUID.randomUUID().toString();
        return new DocumentNumber(String.format("QEP-%s-%s", t, s));
    }
}
