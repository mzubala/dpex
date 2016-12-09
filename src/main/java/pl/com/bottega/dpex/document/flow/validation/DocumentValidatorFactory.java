package pl.com.bottega.dpex.document.flow.validation;

import pl.com.bottega.dpex.document.flow.DocumentStatus;
import pl.com.bottega.dpex.document.flow.validation.managerimpl.*;
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

    public DocumentValidator createAlternative() {
        if (Settings.CURRENT_SYSTEM == "ISO") {
            return new DocumentValidationManager(
                    new NumberChecker(DocumentStatus.VERIFIED),
                    new ExpirationDateChecker(DocumentStatus.VERIFIED)
            );
        } else {
            return new DocumentValidationManager(
                    new AuthorChecker(DocumentStatus.VERIFIED),
                    new ExpirationDateChecker(DocumentStatus.VERIFIED),
                    new ContentChecker(DocumentStatus.PUBLISHED)
            );
        }
    }

}
