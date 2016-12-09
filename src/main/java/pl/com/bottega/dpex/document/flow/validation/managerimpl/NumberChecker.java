package pl.com.bottega.dpex.document.flow.validation.managerimpl;

import pl.com.bottega.dpex.document.flow.Document;
import pl.com.bottega.dpex.document.flow.DocumentStatus;
import pl.com.bottega.dpex.document.flow.validation.DocumentProblems;

public class NumberChecker extends AbstractChecker {

    public NumberChecker(DocumentStatus applicableStatus) {
        super(applicableStatus);
    }

    @Override
    public void check(Document document, DocumentProblems problems) {
        if(document.getNumber() == null)
            problems.add("Document must have a number");
    }

}
