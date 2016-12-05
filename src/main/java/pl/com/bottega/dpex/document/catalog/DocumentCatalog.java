package pl.com.bottega.dpex.document.catalog;

import pl.com.bottega.dpex.document.flow.DocumentNumber;

public interface DocumentCatalog {

	DocumentDto get(DocumentNumber nr);

    DocumentSearchResults find(DocumentSearchCriteria criteria);
	
}
