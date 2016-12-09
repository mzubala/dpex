package pl.com.bottega.dpex.document.flow.validation.managerimpl;

import pl.com.bottega.dpex.document.flow.Document;
import pl.com.bottega.dpex.document.flow.DocumentStatus;
import pl.com.bottega.dpex.document.flow.validation.DocumentProblems;
import pl.com.bottega.dpex.document.flow.validation.DocumentValidationException;
import pl.com.bottega.dpex.document.flow.validation.DocumentValidator;

public class DocumentValidationManager implements DocumentValidator {

    private AbstractChecker[] checkers;

    public DocumentValidationManager(AbstractChecker... checkers) {
        this.checkers = checkers;
    }

    @Override
    public void validate(Document document, DocumentStatus targetStatus) {
        DocumentProblems problems = new DocumentProblems();
        for(AbstractChecker abstractChecker : checkers) {
            if(abstractChecker.canCheck(targetStatus))
                abstractChecker.check(document, problems);
        }
        if(!problems.isEmpty())
            throw new DocumentValidationException(problems);
    }
}
