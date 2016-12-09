package pl.com.bottega.dpex.document.flow.validation.simplechainimpl;

import pl.com.bottega.dpex.document.flow.Document;
import pl.com.bottega.dpex.document.flow.DocumentStatus;
import pl.com.bottega.dpex.document.flow.validation.DocumentProblems;

public class ContentChainValidator extends DocumentChainValidator {
    public ContentChainValidator(DocumentStatus applicableStatus) {
        super(applicableStatus);
    }


    @Override
    protected void doValidate(Document document, DocumentStatus targetStatus, DocumentProblems problems) {
        if (!canValidate(targetStatus)) {
            proceed(document, targetStatus, problems);
            return;
        }
        if (document.getContent() == null || document.getContent().length() == 0)
            problems.add("Document must have content");
        proceed(document, targetStatus, problems);
    }
}
