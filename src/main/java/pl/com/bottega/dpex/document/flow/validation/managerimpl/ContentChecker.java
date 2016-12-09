package pl.com.bottega.dpex.document.flow.validation.managerimpl;

import pl.com.bottega.dpex.document.flow.Document;
import pl.com.bottega.dpex.document.flow.DocumentStatus;
import pl.com.bottega.dpex.document.flow.validation.DocumentProblems;

public class ContentChecker extends AbstractChecker {
    public ContentChecker(DocumentStatus applicableStatus) {
        super(applicableStatus);
    }

    @Override
    public void check(Document document, DocumentProblems problems) {
        if (document.getContent() == null || document.getContent().length() == 0)
            problems.add("Document must have content");
    }

}
