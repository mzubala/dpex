package pl.com.bottega.dpex.document.flow.validation.managerimpl;

import pl.com.bottega.dpex.document.flow.Document;
import pl.com.bottega.dpex.document.flow.DocumentStatus;
import pl.com.bottega.dpex.document.flow.validation.DocumentProblems;

public abstract class AbstractChecker {

    private DocumentStatus applicableState;

    protected AbstractChecker(DocumentStatus applicableState) {
        this.applicableState = applicableState;
    }

    public abstract void check(Document document, DocumentProblems problems);

    public boolean canCheck(DocumentStatus targetStatus) {
        return applicableState == targetStatus;
    }

}
