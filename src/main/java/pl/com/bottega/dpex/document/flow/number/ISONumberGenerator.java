package pl.com.bottega.dpex.document.flow.number;

import pl.com.bottega.dpex.document.flow.DocumentType;

import java.util.Random;

public class ISONumberGenerator implements NumberGenerator {
    @Override
    public DocumentNumber generate(DocumentType t) {
        int r = new Random().nextInt();
        return new DocumentNumber(String.format("ISO-%s-%d", t, r));
    }
}
