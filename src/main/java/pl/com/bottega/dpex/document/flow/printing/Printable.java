package pl.com.bottega.dpex.document.flow.printing;

public interface Printable {

    int pagesCount();

    int picturesCount();

    DocumentType getType();
}
