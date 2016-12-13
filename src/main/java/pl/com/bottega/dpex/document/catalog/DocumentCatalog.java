package pl.com.bottega.dpex.document.catalog;

import pl.com.bottega.dpex.document.flow.number.DocumentNumber;
import pl.com.bottega.dpex.document.shared.SearchResults;

public interface DocumentCatalog {

    DocumentDto get(DocumentNumber documentNumber);

    SearchResults<DocumentDto> find(DocumentCriteria criteria);

}
