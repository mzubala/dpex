package pl.com.bottega.dpex.document.flow.validation;

import pl.com.bottega.dpex.document.flow.Document;
import pl.com.bottega.dpex.document.flow.DocumentStatus;

public interface DocumentValidator {

    void validate(Document document, DocumentStatus targetStatus);

}
