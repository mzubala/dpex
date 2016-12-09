package pl.com.bottega.dpex.document.flow.validation;

import java.util.Collection;
import java.util.HashSet;

public class DocumentProblems {

    private Collection<String> problems = new HashSet<>();

    public void add(String problem) {
        this.problems.add(problem);
    }

    public Collection<String> getProblems() {
        return problems;
    }

    public boolean isEmpty() {
        return problems.isEmpty();
    }
}
