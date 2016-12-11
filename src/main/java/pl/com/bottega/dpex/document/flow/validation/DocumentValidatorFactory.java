package pl.com.bottega.dpex.document.flow.validation;

import pl.com.bottega.dpex.document.flow.DocumentStatus;
import pl.com.bottega.dpex.document.flow.validation.simplechainimpl.*;
import pl.com.bottega.dpex.document.shared.Settings;

public class DocumentValidatorFactory {

    public DocumentValidator create() {
        if (Settings.CURRENT_SYSTEM == "ISO") {
            return DocumentChainValidator.link(
                    new NumberChainValidator(DocumentStatus.VERIFIED),
                    new ExpirationDateValidator(DocumentStatus.PUBLISHED)
            );
        } else {
            return DocumentChainValidator.link(
                    new AuthorChainValidator(DocumentStatus.VERIFIED),
                    new ExpirationDateValidator(DocumentStatus.VERIFIED),
                    new ContentChainValidator(DocumentStatus.PUBLISHED)
            );
        }
    }

}
