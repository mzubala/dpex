package pl.com.bottega.dpex.document.flow.validation.managerimpl;

import pl.com.bottega.dpex.document.flow.Document;
import pl.com.bottega.dpex.document.flow.DocumentStatus;
import pl.com.bottega.dpex.document.flow.validation.DocumentProblems;

public class ExpirationDateChecker extends AbstractChecker {

    public ExpirationDateChecker(DocumentStatus applicableStatus) {
        super(applicableStatus);
    }

    @Override
    public void check(Document document, DocumentProblems problems) {
        if (document.getExpirationDate() == null)
            problems.add("Document must have expiration date");
    }

}
