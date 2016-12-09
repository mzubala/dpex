package pl.com.bottega.dpex.document.flow.validation.managerimpl;

import pl.com.bottega.dpex.document.flow.Document;
import pl.com.bottega.dpex.document.flow.DocumentStatus;
import pl.com.bottega.dpex.document.flow.validation.DocumentProblems;

public class AuthorChecker extends AbstractChecker {


    public AuthorChecker(DocumentStatus applicableState) {
        super(applicableState);
    }

    @Override
    public void check(Document document, DocumentProblems problems) {
        if (document.getAuthor() == null)
            problems.add("Document must have an author");
    }
}
