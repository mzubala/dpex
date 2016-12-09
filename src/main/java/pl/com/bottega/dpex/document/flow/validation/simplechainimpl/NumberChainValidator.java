package pl.com.bottega.dpex.document.flow.validation.simplechainimpl;

import pl.com.bottega.dpex.document.flow.Document;
import pl.com.bottega.dpex.document.flow.DocumentStatus;
import pl.com.bottega.dpex.document.flow.validation.DocumentProblems;

public class NumberChainValidator extends DocumentChainValidator {

    public NumberChainValidator(DocumentStatus applicableStatus) {
        super(applicableStatus);
    }

    @Override
    protected void doValidate(Document document, DocumentStatus targetStatus, DocumentProblems problems) {
        if (!canValidate(targetStatus)) {
            proceed(document, targetStatus, problems);
            return;
        }
        if (document.getNumber() == null)
            problems.add("Document must have a number");
        proceed(document, targetStatus, problems);
    }
}
