package pl.com.bottega.dpex.document.flow.validation.simplechainimpl;

import pl.com.bottega.dpex.document.flow.Document;
import pl.com.bottega.dpex.document.flow.DocumentStatus;
import pl.com.bottega.dpex.document.flow.validation.DocumentProblems;
import pl.com.bottega.dpex.document.flow.validation.DocumentValidationException;
import pl.com.bottega.dpex.document.flow.validation.DocumentValidator;

public abstract class DocumentChainValidator implements DocumentValidator {

    private DocumentChainValidator next;
    private DocumentStatus applicableStatus;

    public static DocumentChainValidator link(DocumentChainValidator... links) {
        for (int i = 0; i < links.length - 1; i++) {
            links[i].next = links[i + 1];
        }
        return links[0];
    }

    public DocumentChainValidator(DocumentStatus applicableStatus) {
        this.applicableStatus = applicableStatus;
    }

    @Override
    public void validate(Document document, DocumentStatus targetStatus) {
        DocumentProblems problems = new DocumentProblems();
        doValidate(document, targetStatus, problems);
        if (!problems.isEmpty())
            throw new DocumentValidationException(problems);
    }

    protected DocumentChainValidator getNext() {
        return next;
    }

    protected boolean canValidate(DocumentStatus targetStatus) {
        return applicableStatus == targetStatus;
    }

    protected void proceed(Document document, DocumentStatus targetStatus, DocumentProblems problems) {
        if(next != null)
            next.doValidate(document, targetStatus, problems);
    }

    protected abstract void doValidate(Document document, DocumentStatus targetStatus, DocumentProblems problems);

}
