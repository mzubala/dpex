package pl.com.bottega.dpex.document.flow.validation;

import java.util.Collection;

public class DocumentValidationException extends RuntimeException {

    private DocumentProblems problems;

    public DocumentValidationException(DocumentProblems problems) {
        this.problems = problems;
    }

    public DocumentProblems getProblems() {
        return problems;
    }

}
